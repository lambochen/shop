package com.chensanwa.shop.exception;


import com.chensanwa.shop.enums.ResultEnum;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/5/13
 * Time: 8:57
 */
public class BaseException extends RuntimeException{

    private Integer code;

    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public BaseException(String message, Throwable cause){
        super(message,cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
