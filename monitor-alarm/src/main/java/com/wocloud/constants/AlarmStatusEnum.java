package com.wocloud.constants;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/14 10:54
 * @Description:
 */
public enum  AlarmStatusEnum {

    PRE_ALARM(0, "预告警"),
    ALARM(1, "告警"),
    RECOVER(2, "恢复"),
//    EXECTION(3, "异常"),
    END(3, "终止");

    private Integer code;
    private String message;


    AlarmStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
