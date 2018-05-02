package com.epam.kseniya_samokhina.java.lesson4.task1.Utils;

import com.epam.kseniya_samokhina.java.lesson4.task1.Device.TypeOfDevice;

import java.lang.reflect.Type;

/**
 * Created by Kseniya on 02.05.2018.
 */
public class ExceptionOfOrigin extends Exception{
   private String origin;

    public ExceptionOfOrigin(String origin) {
        this.origin = origin;
    }

    public String  getOrigin() {
        return origin;
    }

    public String getMessage() {
        return "Incorrect producing country: " + this.getOrigin();
    }
}
