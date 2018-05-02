package com.epam.kseniya_samokhina.java.lesson4.task1.Utils;

public class ExceptionNegative extends Throwable {

    private Integer number;

    public ExceptionNegative(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getMessage() {
        return "There can be no negative values: " + this.getNumber();
    }
}
