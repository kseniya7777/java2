package com.epam.kseniya_samokhina.java.lesson6.task1.Device;

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

    void setBrandDevice(String brandAppliances);

    void setTypeOfDevice(TypeOfDevice typeOfDevice);


    void setPowerOfDevice(int powerOfDevice);

    void setStateOfDevice(boolean stateOfDevice);

    void setColorOfDevice(String colorOfDevice);

    void setDeviceLocation(String location);
}
