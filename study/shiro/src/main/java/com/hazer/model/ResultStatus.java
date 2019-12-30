package com.hazer.model;

/**
 * @ClassName: ResultStatus
 * @Author: Hazer
 * @Description: 返回成功状态
 * @Date: 2019/12/30 17:07
 * @Version: 1.0
 */
public enum ResultStatus {
    RESULT_STATUS_FAILURE(1),
    RESULT_STATUS_SUCCESS(0);

    private int value;

    ResultStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}