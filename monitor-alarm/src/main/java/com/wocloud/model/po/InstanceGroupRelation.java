package com.wocloud.model.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/15 11:25
 * @Description: 实例和分组关联表
 */
@Document(collection = "instance_group_relation")
@CompoundIndex(collection = "instance_group_relation",unique = true,def = "{'instanceId':1,'groupId':1}",name = "uk_instance_group")
public @Data class InstanceGroupRelation {

    @Id
    private String id;

    @Field("instanceId")
    private String instanceId;

    @Field("instanceType")
    private String instanceType;

    @Field("groupId")
    private String groupId;

    @Field("createTime")
    private Long createTime;
}
