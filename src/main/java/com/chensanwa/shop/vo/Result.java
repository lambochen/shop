package com.chensanwa.shop.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/5/13
 * Time: 9:05
 */
public class Result<T> implements Serializable {

    private Integer code;      //错误码

    private String msg;     //提示信息

    private T data;         //具体内容

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
