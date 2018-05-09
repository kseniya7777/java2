package com.epam.kseniya_samokhina.java.lesson8.task1.Device;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Device implements Serializable, InterfaceDevice, Cloneable {
    private String brandDevice;
    private String originDevice;
    private TypeOfDevice typeOfDevice;
    private int powerOfDevice;
    private String colorDevice;
    private String deviceLocation;
    private boolean stateOfDevice;

    public Device() {
    }

    public Device(String brandDevice, String originDevice, TypeOfDevice typeOfDevice, int powerOfDevice, String colorDevice, String deviceLocation, boolean stateOfDevice) {
        this.brandDevice = brandDevice;
        this.originDevice = originDevice;
        this.typeOfDevice = typeOfDevice;
        this.powerOfDevice = powerOfDevice;
        this.colorDevice = colorDevice;
        this.deviceLocation = deviceLocation;
        this.stateOfDevice = stateOfDevice;
    }

    @Override
    public String getBrandDevice() {
        return brandDevice;
    }

    @Override
    public String getOriginDevice() {
        return originDevice;
    }

    @Override
    public boolean isStateOfDevice() {
        return stateOfDevice;
    }

    @Override
    public int getPower() {
        return powerOfDevice;
    }

    @Override
    public Device clone() throws CloneNotSupportedException {
        return (Device) super.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.brandDevice).append("(").append(this.typeOfDevice).append(" | ").append(this.originDevice).append(" | ")
                .append(this.powerOfDevice).append(" | ").append(this.colorDevice).append(" | ").append(this.deviceLocation).append(" | ")
                .append(this.isStateOfDevice() ? "on" : "off").append(")");
        return sb.toString();
    }

    @Override
    public int compareTo(InterfaceDevice devToCompare) {
        int result;
        result = Boolean.compare(isStateOfDevice(), devToCompare.isStateOfDevice());
        if (result != 0) return result;
        result = Integer.compare(getPower(), devToCompare.getPower());
        return result;
    }

    @Override
    public String getColorDevice() {
        return colorDevice;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public TypeOfDevice getTypeOfDevice() {

        return typeOfDevice;
    }

    public int getPowerOfDevice() {
        return powerOfDevice;
    }

    @XmlElement
    public void setBrandDevice(String brandDevice) {
        this.brandDevice = brandDevice;
    }

    @XmlElement
    public void setOriginDevice(String originDevice) {
        this.originDevice = originDevice;
    }

    @XmlElement
    public void setTypeOfDevice(TypeOfDevice typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    @XmlElement
    public void setPowerOfDevice(int powerOfDevice) {
        this.powerOfDevice = powerOfDevice;
    }

    @XmlElement
    public void setStateOfDevice(boolean stateOfDevice) {
        this.stateOfDevice = stateOfDevice;
    }

    @XmlElement
    public void setColorDevice(String colorOfDevice) {
        this.colorDevice = colorOfDevice;
    }

    @XmlElement

    public void setDeviceLocation(String location) {
        this.deviceLocation = location;
    }
}

