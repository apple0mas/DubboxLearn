package com.wocloud.model.po;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/14 11:05
 * @Description:
 */
@Document(collection = "alarm_info")
@CompoundIndex(collection = "alarm_info",def = "{'instanceId':1,'alarmType':1,'policyId':1,'groupId':1}",name = "uk_alarm_info")
//@NoArgsConstructor
@Builder
public @Data class AlarmInfo {

    @Id
    private String id;

    @Field("instanceId")
    private String instanceId;

    /**
     * 告警类型
     */
    @Field("alarmType")
    private String alarmType;

    /**
     * 告警描述
     */
    @Field("alarmDesc")
    private String alarmDesc;

    /**
     * 该实例属于分组
     */
    @Field("groupId")
    private ObjectId groupId;

    /**
     * 触发模板
     */
    @Field("policyId")
    private ObjectId policyId;

    /**
     * 0:预告警；1：告警；2：恢复；3：监控数据异常
     */
    @Field("status")
    private Integer status;

    /**
     * 设备名称
     */
    @Field("deviceName")
    private String deviceName;

    /**
     * 设备类型
     */
    @Field("deviceType")
    private String deviceType;

    /**
     * 设备ID
     */
    @Field("deviceUUID")
    private String deviceUUID;

    /**
     * 设备别名
     */
    @Field("host")
    private String host;

    /**
     * 设备IP
     */
    @Field("manageIp")
    private String manageIp;

    /**
     * 资源池
     */
    @Field("resourcePool")
    private String resourcePool;

    /**
     * 可用域ID
     */
    @Field("availableZoneId")
    private String availableZoneId;

    /**
     * 虚拟机ID
     */
    @Field("vmUUID")
    private String vmUUID;

    /**
     * 系统类型
     */
    @Field("osType")
    private String osType;

    /**
     * 告警时间
     */
    @Field("alarmTime")
    private Long alarmTime;

    /**
     * 最后更新时间
     */
    @Field("updateTime")
    private Long updateTime;

    public AlarmHistory toAlarmHistory(){
        AlarmHistory alarmHistory = new AlarmHistory();
        alarmHistory.setInstanceId(this.instanceId);
        alarmHistory.setAlarmDesc(this.alarmDesc);
        alarmHistory.setAlarmTime(this.alarmTime);
        alarmHistory.setAlarmType(this.alarmType);
        alarmHistory.setPolicyId(this.policyId);
        alarmHistory.setStatus(this.status);
        alarmHistory.setDeviceName(this.deviceName);
        alarmHistory.setDeviceType(this.deviceType);
        alarmHistory.setDeviceUUID(this.deviceUUID);
        alarmHistory.setHost(this.host);
        alarmHistory.setManageIp(this.manageIp);
        alarmHistory.setAvailableZoneId(this.availableZoneId);
        alarmHistory.setResourcePool(this.resourcePool);
        alarmHistory.setVmUUID(this.vmUUID);
        alarmHistory.setOsType(this.osType);
        alarmHistory.setUpdateTime(this.updateTime);
        alarmHistory.setGroupId(this.groupId);
        return alarmHistory;
    }
}
