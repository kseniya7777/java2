package com.epam.kseniya_samokhina.java.lesson8.task1.Device;

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

    void setBrandDevice(String brandDevice);

    void setOriginDevice(String originDevice);

    void setTypeOfDevice(TypeOfDevice typeOfDevice);

    void setPowerOfDevice(int powerOfDevice);

    void setStateOfDevice(boolean stateOfDevice);

    void setColorDevice(String colorOfDevice);

    void setDeviceLocation(String location);
}
