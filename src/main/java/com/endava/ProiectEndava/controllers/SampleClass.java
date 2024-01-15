package com.endava.ProiectEndava.controllers;

public class SampleClass {
    private Integer result = null;

    public Integer getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void Add(Integer input1, int input2){
        setResult(input1+input2);
    }
}
