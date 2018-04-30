package com.epam.kseniya_samokhina.java.lesson5.task1.Device;

public interface InterfaceDevice extends Comparable<InterfaceDevice> {
    String getBrandDevice();

    String getOriginDevice();

    String getDeviceLocation();

    String getColorDevice();

    boolean isStateOfDevice();

    int getPower();

    Device clone() throws CloneNotSupportedException;

    @Override
    int compareTo(InterfaceDevice o);
}
