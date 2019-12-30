package com.hazer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultModel implements Serializable {
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
        return new ResultModel(ResultStatus.RESULT_STATUS_SUCCESS.getValue());
    }

    public ResultModel(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public static ResultModel success(String msg, Object content) {
        return new ResultModel(ResultStatus.RESULT_STATUS_SUCCESS.getValue(),
                msg, content);
    }

    public static ResultModel fail() {
        return new ResultModel(ResultStatus.RESULT_STATUS_FAILURE.getValue());
    }

    public static ResultModel fail(String msg, Object content) {
        return new ResultModel(ResultStatus.RESULT_STATUS_FAILURE.getValue(),
                msg, content);
    }

    public ResultModel(Integer errorCode, String msg, Object content) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.content = content;
    }

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
