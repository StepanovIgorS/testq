package com.springwebsite.task.ResponseModels;

public class ErrorModel {
    public int error_code;
    public String error_msg;

    public ErrorModel(int error_code, String error_msg) {
        this.error_code = error_code;
        this.error_msg = error_msg;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_msg() {
        return error_msg;
    }
}
