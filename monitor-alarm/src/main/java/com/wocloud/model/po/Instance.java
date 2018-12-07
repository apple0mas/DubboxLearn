package com.wocloud.model.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/20 15:41
 * @Description:
 */
public @Data
class Instance {

    @Id
    private String Id;

    @Field(value = "uuid")
    private String uuid;

    @Field(value = "vm_uuid")
    private String vmUUID;

    private String instanceId;

    @Field(value = "state")
    private String state;

    @Field(value = "vm_state")
    private String vmState;

    @Field(value = "cpuUpdateTime")
    private Long updateTime;

    public void setInstanceId() {
        this.instanceId = (vmUUID == null) ? uuid : vmUUID;
    }

}
