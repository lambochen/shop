package com.chensanwa.shop.handle;

import com.chensanwa.shop.enums.ResultEnum;
import com.chensanwa.shop.exception.BaseException;
import com.chensanwa.shop.util.ResultUtil;
import com.chensanwa.shop.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 2018/5/13
 * Time: 8:59
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            return ResultUtil.error(baseException.getCode(), baseException.getMessage());
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR);
        }
    }

}
