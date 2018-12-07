package com.wocloud.model.po;

import lombok.Data;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/15 11:17
 * @Description: 告警事件
 */
public @Data class AlarmEvent {

    private Integer eventId;

    private String content;

    private String rate;

}
