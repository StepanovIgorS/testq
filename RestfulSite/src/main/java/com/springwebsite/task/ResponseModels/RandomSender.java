package com.springwebsite.task.ResponseModels;


public class RandomSender {
    public String generated_value;

    public RandomSender(String value) {
        this.generated_value = value;
    }

    public String getGenerated_value() {
        return generated_value;
    }

    public void setGenerated_value(String generated_value) {
        this.generated_value = generated_value;
    }
}
