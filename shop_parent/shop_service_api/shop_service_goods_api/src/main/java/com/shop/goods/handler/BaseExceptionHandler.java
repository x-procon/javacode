package com.shop.goods.handler;

import com.gyo.shop.entity.Result;
import com.gyo.shop.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共异常处理
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
