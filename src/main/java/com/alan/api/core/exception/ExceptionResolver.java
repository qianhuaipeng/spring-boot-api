package com.alan.api.core.exception;

import com.alan.api.core.response.Result;
import com.alan.api.core.response.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * author: alan.peng
 * description: 异常统一处理
 * date: create in 17:09 2018/11/7
 * modified By：
 */
@RestControllerAdvice
public class ExceptionResolver {

    private final static Logger log = LoggerFactory.getLogger(ExceptionResolver.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Result validatorException(ConstraintViolationException e){
        log.error("验证实体类异常 => {}" , e.getMessage());
        String msg = e.getConstraintViolations().stream()
                .map(ConstraintViolation:: getMessage)
                .collect(Collectors.joining(","));
        return ResultGenerator.genFaildResult(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ ServiceException.class, ServletException.class})
    public Result serviceException(Throwable e){
        log.error("服务异常 => {}", e.getMessage());
        return ResultGenerator.genFaildResult(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public Result databaseException(Throwable e){
        log.error("数据库异常 => {}" ,e.getMessage());
        return ResultGenerator.genFaildResult("database error");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({BadCredentialsException.class, AuthenticationException.class})
    public Result authException(Throwable e ){
        log.error("身份验证异常 => " + e.getMessage()) ;
        return ResultGenerator.genFaildResult(e.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class, UsernameNotFoundException.class})
    public Result userException(Throwable e) {
        log.error("用户异常 => {}", e.getMessage());
        return ResultGenerator.genFaildResult(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result apiNotFound(Throwable e, HttpServletRequest request) {
        log.error("API 不存在 => " + e.getMessage());
        return ResultGenerator.genFaildResult("API [" + request.getRequestURI() + "] not existed.");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result globalException(HttpServletRequest request, Throwable e){
        log.error("全局异常 => {}" + e.getMessage());
        return ResultGenerator.genInternalServerErrorResult(String.format("%s => %s", request.getRequestURI(), e.getMessage()));
    }
}
