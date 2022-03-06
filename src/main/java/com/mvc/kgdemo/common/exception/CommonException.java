package com.mvc.kgdemo.common.exception;

public class CommonException extends RuntimeException {

    public CommonException(Exception e) {
    }

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(String s, Exception ex) {
    }
}
