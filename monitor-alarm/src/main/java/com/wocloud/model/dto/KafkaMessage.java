package com.wocloud.model.dto;


import com.wocloud.model.po.AlarmInfo;

/**
 * @Auther: apple0mas
 * @Date: 2018/9/17 14:28
 * @Description:
 */

public abstract class KafkaMessage {

    protected TagsBean tags;

    public TagsBean getTags() {
        return tags;
    }

    public void setTags(TagsBean tags) {
        this.tags = tags;
    }

    protected String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public AlarmInfo toAlarmInfo() {
        AlarmInfo alarmInfo = tags.tagsBeanToAlarmInfo();
        alarmInfo.setAlarmTime(getTimestamp());
        alarmInfo.setUpdateTime(getTimestamp());
        return alarmInfo;
    }

    public abstract String getName();

    public abstract String getInstanceId();

    public abstract Long getTimestamp();

    public abstract Object getTarget();

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "tags=" + tags +
                ", topic='" + topic + '\'' +
                '}';
    }
}
