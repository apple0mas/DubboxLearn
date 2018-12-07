package com.wocloud.constants;

/**
 * @Auther: apple0mas
 * @Date: 2018/10/30 15:50
 * @Description:
 */
public enum OperatorEnum {

    gt(1, ">", "大于"),
    lt(2,"<","小于"),
    eq(3,"=","等于"),
    ne(4,"!=","不等于"),
    gte(5,">=","大于等于"),
    lte(6,"<=","小于等于");

    private Integer code;
    private String operator;
    private String desc;

    OperatorEnum(Integer code, String operator, String desc) {
        this.code = code;
        this.operator = operator;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getOperator() {
        return operator;
    }
}
