package com.wocloud.model.po;

import lombok.Data;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/15 11:16
 * @Description: 告警指标
 */
public @Data
class AlarmCondition {

    /**
     * ID
     */
    private Integer conditionId;

    /**
     * 指标类型
     */
    private String type;

    /**
     * 操作符
     */
    private String operator;

    /**
     * 阈值
     */
    private String threshold;

    /**
     * 单位
     */
    private String unit;

    /**
     * 频率
     */
    private String rate;

    /**
     * 指标描述
     */
    private String typeDesc;

    public String getAlarmDesc() {
        return typeDesc;
    }

    public void setAlarmDesc(String typeDesc) {
        this.typeDesc = typeDesc + " " + operator + " " + threshold + unit;
    }
}
