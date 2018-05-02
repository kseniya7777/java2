package com.epam.kseniya_samokhina.java.lesson4.task1.Utils;

public class ExceptionOfOrigin extends Exception {
    private String origin;

    public ExceptionOfOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public String getMessage() {
        return "Incorrect producing country: " + this.getOrigin();
    }
}
