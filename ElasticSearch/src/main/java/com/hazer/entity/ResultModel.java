package com.hazer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Hazer
 * @since  2020-07-20 17:23
 */
public class ResultModel {
    /**
     *
     */
    private static final long serialVersionUID = -2445273895966412540L;

    @JsonProperty("errorcode")
    Integer errorCode;

    String msg;

    private Object content;

    public ResultModel() {
    }

    public static ResultModel success() {
        return new ResultModel(0);
    }

    public static ResultModel success(Object content) {
        return new ResultModel(0, "", content);
    }

    public static ResultModel success(String msg, Object content) {
        return new ResultModel(0, msg, content);
    }


    public static ResultModel success(Integer errorCode, String msg, Object content) {
        return new ResultModel(errorCode, msg, content);
    }

    public static ResultModel fail() {
        return new ResultModel(0, "系统异常", null);
    }

    public static ResultModel fail(String msg, Object content) {
        return new ResultModel(0, msg, content);
    }


    public static ResultModel fail(Integer errorCode, String msg) {
        return new ResultModel(errorCode, msg, null);
    }

    public static ResultModel fail(Integer errorCode, String msg, Object content) {
        return new ResultModel(errorCode, msg, content);
    }

    /**
     * 构造方法
     **/
    public ResultModel(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ResultModel(Integer errorCode, String msg, Object content) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.content = content;
    }

    /**
     * setter&getter
     **/
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
