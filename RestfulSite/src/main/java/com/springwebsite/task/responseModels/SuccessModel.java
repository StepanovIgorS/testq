package com.springwebsite.task.ResponseModels;

public class SuccessModel {
    public int status;

    public SuccessModel(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
