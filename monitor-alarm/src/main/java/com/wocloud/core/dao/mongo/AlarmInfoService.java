package com.wocloud.core.dao.mongo;


import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import com.wocloud.constants.AlarmStatusEnum;
import com.wocloud.model.po.AlarmHistory;
import com.wocloud.model.po.AlarmInfo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/1 15:51
 * @Description:
 */
@Service
@Slf4j
public class AlarmInfoService {


    @Autowired
    private MongoOperations mongoOperations;

    /**
     * @param alarmInfo
     */
    public void saveAlarm(AlarmInfo alarmInfo) {
        mongoOperations.insert(alarmInfo);
    }

    public List<AlarmInfo> findAlarmInfoByInstanceIdAndAlarmType(String instanceId, String alarmType) {
        List<AlarmInfo> alarmInfoList = mongoOperations.find(new Query(Criteria.where("instanceId").is(instanceId).and("alarmType").is(alarmType)), AlarmInfo.class);
        return alarmInfoList;
    }

    public List<AlarmInfo> findAlarmInfoByGroupIdAndAlarmType(String instanceId, String alarmType, String groupId) {
        List<AlarmInfo> alarmInfoList = mongoOperations.find(new Query(
                        Criteria.where("instanceId").is(instanceId)
                                .and("alarmType").is(alarmType)
                                .and("groupId").is(new ObjectId(groupId))),
                AlarmInfo.class);
        return alarmInfoList;
    }

    public List<AlarmInfo> findAlarmInfoByPolicyIdAndAlarmType(String instanceId, String alarmType, String policyId) {
        List<AlarmInfo> alarmInfoList = mongoOperations.find(new Query(
                        Criteria.where("instanceId").is(instanceId)
                                .and("alarmType").is(alarmType)
                                .and("policyId").is(new ObjectId(policyId))),
                AlarmInfo.class);
        return alarmInfoList;
    }

    public void updateAlarmStatusById(AlarmInfo alarmInfo) {
        mongoOperations.updateFirst(new Query(
                        Criteria.where("_id").is(alarmInfo.getId())),
                new Update()
                        .set("status", alarmInfo.getStatus())
                        .set("updateTime", alarmInfo.getUpdateTime()),
                AlarmInfo.class);
    }

    /**
     * 查询一台机器是否有告警信息
     *
     * @param instanceId
     * @param policyId
     * @param alarmType
     * @return
     */
    public List<AlarmInfo> findAlarmInfo(String instanceId, String alarmType, ObjectId policyId) {
        List<AlarmInfo> alarmInfoList = mongoOperations.find(new Query(
                        Criteria.where("instanceId").is(instanceId)
                                .and("alarmType").is(alarmType)
                                .and("policyId").is(policyId)
                                .orOperator(Criteria.where("status").is(AlarmStatusEnum.PRE_ALARM.getCode()),
                                        Criteria.where("status").is(AlarmStatusEnum.ALARM.getCode()))),
                AlarmInfo.class);
        return alarmInfoList;
    }

    /**
     * 查询已恢复的告警信息并删除
     * 只删除匹配的第一个
     *
     * @param instanceId
     * @param policyId
     * @param alarmType
     * @return
     */
    public AlarmInfo findOneAndRemoveRecoverInfo(String instanceId, ObjectId policyId, String alarmType) {
        AlarmInfo alarmInfo = mongoOperations.findAndRemove(new Query(
                        Criteria.where("instanceId").is(instanceId)
                                .and("alarmType").is(alarmType)
                                .and("policyId").is(policyId)),
                AlarmInfo.class);
        return alarmInfo;
    }

    public void removeAlarmInfoById(String id) {
        mongoOperations.remove(new Query(Criteria.where("_id").is(id)), AlarmInfo.class);
    }

    /**
     * 删除匹配的所有数据
     *
     * @param instanceId
     * @param policyId
     * @param alarmType
     * @return
     */
    public List<AlarmInfo> findAllAndRemoveRecoverInfo(String instanceId, String policyId, String alarmType) {
        List<AlarmInfo> allAndRemove = mongoOperations.findAllAndRemove(new Query(
                        Criteria.where("instanceId").is(instanceId)
                                .and("alarmType").is(alarmType)
                                .and("policyId").is(new ObjectId(policyId))
                               ),
                AlarmInfo.class);
        return allAndRemove;
    }

    public List<AlarmInfo> findAlarmInfoTest(String instanceId, String alarmType, String policyId) {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.append("instanceId", instanceId).append("policyId", new ObjectId(policyId)).append("alarmType", alarmType);
        BasicDBObject basicDBObject1 = new BasicDBObject("status", AlarmStatusEnum.PRE_ALARM.getCode());
        basicDBObject1.append("status", AlarmStatusEnum.PRE_ALARM.getCode());
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.and(basicDBObject)
                .or(new BasicDBObject("status", AlarmStatusEnum.PRE_ALARM.getCode()),
                        new BasicDBObject("status", AlarmStatusEnum.ALARM.getCode()));
        Query query = new BasicQuery(queryBuilder.get());
        List<AlarmInfo> alarmInfoList = mongoOperations.find(query, AlarmInfo.class);
        return alarmInfoList;
    }

    public void insertAlarmHistory(AlarmHistory alarmInfo) {
        mongoOperations.insert(alarmInfo);
    }
}
