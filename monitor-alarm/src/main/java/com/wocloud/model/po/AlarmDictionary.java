package com.wocloud.model.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/15 11:19
 * @Description:
 */
@Document(collection = "alarm_dictionary")
public @Data class AlarmDictionary implements Serializable {

    @Id
    private String id;

    @Field("type")
    private String type;

    @Field("name")
    private String name;

    @Field("value")
    private String value;

    @Field("createTime")
    private Long createTime;

}
