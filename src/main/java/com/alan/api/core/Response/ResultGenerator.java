package com.alan.api.core.Response;

import org.springframework.http.HttpStatus;

/**
 * author: alan.peng
 * description: 响应结果生成工具
 * date: create in 13:35 2018/11/7
 * modified By：
 */
public class ResultGenerator {

    private static final String DEFAULT_OK_MESSAGE = "OK";
    private static final String DEFAULT_UNAUTHORIZED_MESSAGE = "Need authorized";
    private static final String DEFAULT_METHOD_NOT_ALLOWED_MESSAGE = "Request method incorrect";

    public static Result genOkResult() {
        return new Result
                .Builder(HttpStatus.OK.value())
                .msg(DEFAULT_OK_MESSAGE)
                .build();
    }

    public static Result genOkResult(Object data) {
        return new Result
                .Builder(HttpStatus.OK.value())
                .msg(DEFAULT_OK_MESSAGE)
                .data(data)
                .build();
    }

    public static Result genFaildResult(String msg) {
        return new Result
                .Builder(HttpStatus.BAD_REQUEST.value())
                .msg(msg)
                .build();
    }

    public static Result genMethodErrorResult() {
        return new Result
                .Builder(HttpStatus.METHOD_NOT_ALLOWED.value())
                .msg(DEFAULT_METHOD_NOT_ALLOWED_MESSAGE)
                .build();
    }

    public static Result genUnauthorizedResult() {
        return new Result
                .Builder(HttpStatus.UNAUTHORIZED.value())
                .msg(DEFAULT_UNAUTHORIZED_MESSAGE)
                .build();
    }

    public static Result genUnauthorizedResult(String msg) {
        return new Result
                .Builder(HttpStatus.UNAUTHORIZED.value())
                .msg(msg).build();
    }

    public static Result genInternalServerErrorResult(String url) {
        return new Result
                .Builder(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .msg("API [" + url + "] inernal server error. Please call engineer to debug")
                .build();
    }
}
