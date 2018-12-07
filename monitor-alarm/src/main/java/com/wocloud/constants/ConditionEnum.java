package com.wocloud.constants;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/14 10:55
 * @Description:
 */
public enum ConditionEnum {

    cpu(Constants.ConditionType.CPU, "cpu利用率"),
    disk(Constants.ConditionType.DISK, "磁盘利用率"),
    memory(Constants.ConditionType.MEMORY, "内存利用率");

    private String conditionType;
    private String message;

    ConditionEnum(String code, String message) {
        this.conditionType = code;
        this.message = message;
    }

    public String getConditionType() {
        return conditionType;
    }

    public String getMessage() {
        return message;
    }

}
