package com.wocloud.model.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/15 11:18
 * @Description: 告警策略
 */
@Document(collection = "alarm_policy")
public @Data class AlarmPolicy implements Serializable {

    @Id
    //@Field("policyId")
    private String policyId;

    /**
     * 策略名称
     */
    @Field("policyName")
    private String policyName;

    /**
     * 策略类型
     */
    @Field("policyType")
    private String type;

    /**
     * 备注
     */
    @Field("remark")
    private String remark;

    ///**
    // * 告警接收组
    // */
    //@Field("userGroupId")
    //private String UserGroupId;

    /**
     * 告警指标
     */
    @Field("alarmConditions")
    private List<AlarmCondition> alarmConditions;

    /**
     * 是否启用
     */
    @Field("enable")
    private Boolean enable;

    /**
     * 告警事件
     */
    @Field("alarmEvents")
    private List<AlarmEvent> alarmEvents;

    @Field("createTime")
    private Long createTime;

    @Field("createBy")
    private String createBy;

    @Field("updateTime")
    private Long updateTime;

    @Field("updateBy")
    private String updateBy;

//    public Map<String,AlarmCondition> getAlarmConditionMap(){
////        HashMap<String, AlarmCondition> conditionMap = Maps.newHashMap();
////        if(this.getAlarmConditions().isEmpty()){
////            return conditionMap;
////        }
////        for (AlarmCondition alarmCondition:this.getAlarmConditions()){
////            conditionMap.put(alarmCondition.getType(),alarmCondition);
////        }
////        return conditionMap;
////    }

    public Map<String,AlarmCondition> getAlarmConditionMap(){
        Map<String, AlarmCondition> conditionMap = this.getAlarmConditions().stream().collect(Collectors.toMap(key -> key.getType(), value -> value));
        return conditionMap;
    }
}
