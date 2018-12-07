package com.wocloud.model.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/15 11:24
 * @Description: 实例分组
 */
@Document(collection = "instance_group")
public @Data class InstanceGroup {

    @Id
    private String groupId;

    @Field("groupName")
    private String groupName;

    @Field("type")
    private String type;

    @Field("policyId")
    private String policyId;

    @Field("remark")
    private String remark;

    @Field("createTime")
    private Long createTime;

    @Field("createBy")
    private String createBy;

    @Field("updateTime")
    private Long updateTime;

    @Field("updateBy")
    private String updateBy;

}
