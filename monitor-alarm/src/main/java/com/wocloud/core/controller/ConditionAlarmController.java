package com.wocloud.core.controller;


import com.wocloud.constants.AlarmStatusEnum;
import com.wocloud.constants.ConditionEnum;
import com.wocloud.constants.MessageEnum;
import com.wocloud.constants.OperatorEnum;
import com.wocloud.core.dao.mongo.AlarmInfoService;
import com.wocloud.core.dao.mongo.GroupRelationService;
import com.wocloud.core.dao.mongo.GroupService;
import com.wocloud.core.dao.mongo.PolicyService;
import com.wocloud.model.dto.KafkaMessage;
import com.wocloud.model.dto.VmWinMemoryMessage;
import com.wocloud.model.po.*;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/6 14:20
 * @Description:
 */
@Slf4j
@Controller
public class ConditionAlarmController {

    @Autowired
    private AlarmInfoService alarmInfoService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private GroupRelationService groupRelationService;

    @Autowired
    private GroupService groupService;

    private AlarmPolicy defaultAlarmPolicy;

    public void conditionAlarm(KafkaMessage message) {
        defaultAlarm(message);
        customAlarm(message);
    }

    private void defaultAlarm(KafkaMessage message) {
        if (defaultAlarmPolicy == null) {
            defaultAlarmPolicy = policyService.findDefaultAlarmPolicy();
        }
        Map<String, AlarmCondition> alarmConditionMap = defaultAlarmPolicy.getAlarmConditionMap();
        AlarmCondition alarmCondition = alarmConditionMap.get(MessageEnum.getConditionType(message));
        String policyId = defaultAlarmPolicy.getPolicyId();
        alarmOperation(policyId, alarmCondition, message, null);
    }

    private void customAlarm(KafkaMessage message) {
        String instanceId = message.getInstanceId();
        String conditionType = MessageEnum.getConditionType(message);
        List<InstanceGroupRelation> groupRelationList = groupRelationService.findGroupByInstanceId(instanceId);
        if (!groupRelationList.isEmpty()) {
            for (InstanceGroupRelation groupRelation : groupRelationList) {
                String groupId = groupRelation.getGroupId();
                InstanceGroup group = groupService.findGroupById(groupId);
                if (group == null) {
                    log.info("分组不存在");
                    continue;
                }
                String policyId = group.getPolicyId();
                if (StringUtils.isEmpty(policyId)) {
                    //有分组无模板,
                    policyIsNull(instanceId, conditionType, groupId);
                    continue;
                }
                AlarmPolicy policy = policyService.findPolicyById(policyId);
                Map<String, AlarmCondition> conditionMap = policy.getAlarmConditionMap();
                AlarmCondition alarmCondition = conditionMap.get(conditionType);
                if (alarmCondition != null) {
                    alarmOperation(policyId, alarmCondition, message, groupId);
                } else {
                    //有分组有模板，无指标
                    ConditionIsNull(instanceId, conditionType, policyId);
                }
            }
        } else {
            //无分组信息，
            groupIsNull(instanceId, conditionType);
        }
    }

    private void groupIsNull(String instanceId, String alarmType) {
        List<AlarmInfo> alarmInfoList = alarmInfoService.findAlarmInfoByInstanceIdAndAlarmType(instanceId, alarmType);
        noAlarm(alarmInfoList);
    }

    private void policyIsNull(String instanceId, String alarmType, String groupId) {
        List<AlarmInfo> alarmInfoList = alarmInfoService.findAlarmInfoByGroupIdAndAlarmType(instanceId, alarmType, groupId);
        noAlarm(alarmInfoList);
    }

    /**
     * 有分组有模板，无指标
     *
     * @param instanceId 实例ID
     * @param alarmType  告警类型
     * @param policyId   策略ID
     */
    private void ConditionIsNull(String instanceId, String alarmType, String policyId) {
        List<AlarmInfo> alarmInfoList = alarmInfoService.findAlarmInfoByPolicyIdAndAlarmType(instanceId, alarmType, policyId);
        noAlarm(alarmInfoList);
    }

    /**
     * 无法告警
     *
     * @param alarmInfoList 告警记录
     */
    private void noAlarm(List<AlarmInfo> alarmInfoList) {
        if (alarmInfoList.isEmpty()) {
            return;
        }
        for (AlarmInfo alarmInfo : alarmInfoList) {
            if (!defaultAlarmPolicy.getPolicyId().equals(alarmInfo.getPolicyId())) {
                alarmInfoService.removeAlarmInfoById(alarmInfo.getId());
                if (AlarmStatusEnum.PRE_ALARM.getCode() == alarmInfo.getStatus()) {
                    continue;
                }
                if (alarmInfo.getStatus() == AlarmStatusEnum.ALARM.getCode()) {
                    //告警信息置为终止状态
                    alarmInfo.setStatus(AlarmStatusEnum.END.getCode());
                }
                alarmInfoService.insertAlarmHistory(alarmInfo.toAlarmHistory());
            }
        }
    }

    private void convertAlarmDesc(AlarmCondition condition) {
        ConditionEnum conditionEnum = ConditionEnum.valueOf(condition.getType());
        condition.setAlarmDesc(conditionEnum.getMessage());
    }

    private void alarmOperation(String policyId, AlarmCondition condition, KafkaMessage message, String groupId) {
        AlarmInfo alarmInfo = message.toAlarmInfo();
        convertAlarmDesc(condition);
        alarmInfo.setAlarmDesc(condition.getAlarmDesc());
        alarmInfo.setAlarmType(condition.getType());
        if (!StringUtils.isEmpty(policyId)) {
            alarmInfo.setPolicyId(new ObjectId(policyId));
        }
        if (!StringUtils.isEmpty(groupId)) {
            alarmInfo.setGroupId(new ObjectId(groupId));//TODO ObjectId类型转换
        }
        alarmInfo.setDeviceType(MessageEnum.getInstanceType(message));
        alarmInfo.setStatus(AlarmStatusEnum.PRE_ALARM.getCode());
        if (isNeedAlarm(condition, message)) {
            requiredAlarm(alarmInfo);
        } else {
            requiredNotAlarm(alarmInfo);
        }
    }

    /**
     * 告警策略
     *
     * @param alarmInfo
     */
    private void requiredAlarm(AlarmInfo alarmInfo) {
        List<AlarmInfo> alarmInfoList = alarmInfoService.findAlarmInfo(alarmInfo.getInstanceId(), alarmInfo.getAlarmType(), alarmInfo.getPolicyId());
        if (alarmInfoList.isEmpty()) {
            alarmInfoService.saveAlarm(alarmInfo);
        } else {
            if (alarmInfoList.size() == 1) {
                AlarmInfo info = alarmInfoList.get(0);
                if (info.getAlarmDesc().equals(alarmInfo.getAlarmDesc())) {//告警指标未修改
                    alarmInfo.setId(info.getId());
                    alarmInfo.setStatus(AlarmStatusEnum.ALARM.getCode());
                    alarmInfoService.updateAlarmStatusById(alarmInfo);
                } else {//告警指标已修改
                    alarmInfoService.removeAlarmInfoById(info.getId());
                    alarmInfoService.saveAlarm(alarmInfo);
                    if (info.getStatus() != AlarmStatusEnum.PRE_ALARM.getCode()) {
                        AlarmHistory alarmHistory = info.toAlarmHistory();
                        alarmHistory.setStatus(AlarmStatusEnum.END.getCode());
                        alarmInfoService.insertAlarmHistory(alarmHistory);
                    }
                }
            } else {
                //TODO
                log.info("异常，有多条告警:{}", alarmInfoList.toString());
            }
        }
    }

    /**
     * 不需要告警策略
     *
     * @param alarmInfo
     */
    private void requiredNotAlarm(AlarmInfo alarmInfo) {
        AlarmInfo recoverInfo = alarmInfoService.findOneAndRemoveRecoverInfo(alarmInfo.getInstanceId(), alarmInfo.getPolicyId(), alarmInfo.getAlarmType());
        if (recoverInfo != null) {
            if (recoverInfo.getStatus() != AlarmStatusEnum.PRE_ALARM.getCode()) {
                if (alarmInfo.getAlarmDesc().equals(recoverInfo.getAlarmDesc())) {
                    recoverInfo.setStatus(AlarmStatusEnum.RECOVER.getCode());
                } else {
                    recoverInfo.setStatus(AlarmStatusEnum.END.getCode());
                }
                //插入历史表
                alarmInfoService.insertAlarmHistory(recoverInfo.toAlarmHistory());
            } else {
                //删除
            }
        }
    }

    private boolean isNeedAlarm(AlarmCondition condition, KafkaMessage message) {
        //TODO windows虚拟机内存指标暂时不告警
        if (message instanceof VmWinMemoryMessage) return false;
        String operator = condition.getOperator();
        Double usedPercent = (Double) message.getTarget();
        Double threshold = Double.parseDouble(condition.getThreshold());
        return judge(operator, usedPercent, threshold);
    }

    private boolean judge(String operator, Double used, Double threshold) {
        if (operator.equals(OperatorEnum.gt.getOperator())) {
            return used > threshold;
        } else if (operator.equals(OperatorEnum.lt.getOperator())) {
            return used < threshold;
        } else if (operator.equals(OperatorEnum.eq.getOperator())) {
            return used == threshold;
        } else if (operator.equals(OperatorEnum.ne.getOperator())) {
            return used != threshold;
        } else if (operator.equals(OperatorEnum.gte.getOperator())) {
            return used >= threshold;
        } else if (operator.equals(OperatorEnum.lte.getOperator())) {
            return used <= threshold;
        }
        return false;
    }

}
