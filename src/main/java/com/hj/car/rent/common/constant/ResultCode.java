package com.hj.car.rent.common.constant;

public enum ResultCode {
    SUCCESS(2000, "Success"),
    DISPATCH_FAILURE(2100, "Dispatch failure"),
    DISPATCH_SUCCESS(2000, "Dispatch success"),
    RETURN_FAILURE(2100, "Return failure"),
    RETURN_SUCCESS(2000, "Return success"),
    PARAM_NOT_COMPLETE(4000, "Param not complete"),
    USER_NOT_EXIST(4550, "User not exist"),
    ERROR(5000, "Service exception"),
    URI_NOT_FOUND(404, "Uri not found");

    private int code;

    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
