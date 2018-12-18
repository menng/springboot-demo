package org.springboot.shiro.comm.exception;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    String handleException(){
        return "Exception!";
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    String handleUnauthorizedException(){
        return "无此权限";
    }

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseBody
    String handleUnauthenticatedException(){
        return "token错误";
    }
}
