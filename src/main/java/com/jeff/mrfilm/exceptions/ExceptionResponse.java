package com.jeff.mrfilm.exceptions;

public class ExceptionResponse {
    private String msg;
    private String details;

    public ExceptionResponse(String msg, String details) {
        this.msg = msg;
        this.details = details;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
