package com.springwebsite.task.ResponseModels;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException() {
        super();
    }
    public ItemNotFoundException(String message) {
        super(message);
    }
}
