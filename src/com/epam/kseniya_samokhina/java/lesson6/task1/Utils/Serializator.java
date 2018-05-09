package com.epam.kseniya_samokhina.java.lesson6.task1.Utils;

import com.epam.kseniya_samokhina.java.lesson6.task1.Device.Device;

import java.io.*;

public class Serializator {
    public static Device readObject(String fileName) {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Device device = (Device) input.readObject();
            input.close();
            fileInput.close();
            return device;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeObject(String fileName, Object object) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(object);
            output.close();
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
