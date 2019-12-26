package com.ustc.travelbook.dto;

import java.io.Serializable;

/**
 * @author liuwang
 * @date 2019/12/26 11:52
 */
public class ResultMessage<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private static final int SUCCESS_CODE = 201;
    private static final int FAIL_CODE = 205;
    private static final String SUCCESS_MESSAGE = "SUCCESS";
    private static final String FAIL_MESSAGE = "FAILED";

    public ResultMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static ResultMessage success() {
        return new ResultMessage(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static ResultMessage success(String message) {
        return new ResultMessage(SUCCESS_CODE, message);
    }

    public static ResultMessage success(Object data) {
        return new ResultMessage(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static ResultMessage failed() {
        return new ResultMessage(FAIL_CODE, FAIL_MESSAGE);
    }

    public static ResultMessage failed(String message) {
        return new ResultMessage(FAIL_CODE, message);
    }

}
