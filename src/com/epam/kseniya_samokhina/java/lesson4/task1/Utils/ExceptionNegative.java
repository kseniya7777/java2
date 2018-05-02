package com.epam.kseniya_samokhina.java.lesson4.task1.Utils;

public class ExceptionNegative extends Throwable{

    private Integer number;

    public ExceptionNegative(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getMessage() {
        return "You are not allowed to enter negative numbers here: " + this.getNumber();
    }

}
