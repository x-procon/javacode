package com.hazer.exception;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.hazer.model.ResultModel;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hazer
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandle.class);
    /**
     * 捕获shiro异常
     * @param e 异常
     * @return Result
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResultModel<Integer> handle401(ShiroException e) {
        log.error(e.getMessage());
        return ResultModel.fail(401, e.getMessage());
    }

    /**
     * 捕获shiro异常
     * @param e 异常
     * @return Result
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public ResultModel<Integer> handle401(UnauthenticatedException e) {
        log.error(e.getMessage());
        return ResultModel.fail(401, "你没有权限访问");
    }

    /**
     *  校验错误异常处理
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultModel<Integer> handler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        //这一步是把异常的信息最简化
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return ResultModel.fail(HttpStatus.BAD_REQUEST.value(),objectError.getDefaultMessage());
    }

    /**
     * 处理Assert的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResultModel<Integer> handler(IllegalArgumentException e) {
        log.error("Assert异常:-------------->{}",e.getMessage());
        return ResultModel.fail(400,e.getMessage());
    }


    /**
     * 运行异常
     * @param e 异常
     * @return Result
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResultModel<Integer> handle(RuntimeException e){
        return ResultModel.fail(HttpStatus.BAD_REQUEST.value(),e.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = TokenExpiredException.class)
    public ResultModel<Integer> handler(TokenExpiredException e) {
        log.error(e.getMessage());
        return ResultModel.fail(HttpStatus.BAD_REQUEST.value(),"token已经过期，请重新登录");
    }
}
