package com.wocloud.model.po;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/19 10:07
 * @Description:
 */
@Document(collection = "alarm_history")
public @Data
class AlarmHistory {


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
     * 触发模板
     */
    @Field("policyId")
    private ObjectId policyId;

    /**
     * 该实例属于分组
     */
    @Field("groupId")
    private ObjectId groupId;
    /**
     * 2：恢复
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

}
