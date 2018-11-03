package com.alan.api.core.exception;

/**
 * author: alan.peng
 * description:
 * date: create in 11:43 2018/11/3
 * modified By：
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
