package com.chensanwa.shop.enums;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/5/13
 * Time: 9:11
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "请求成功"),
    PARAM_ERROR(1, "参数错误"),
    PARAM_IS_NULL(2, "参数为空"),
    INSUFFICIENT_PERMISSIONS(3, "权限不足"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
