package com.epam.kseniya_samokhina.java.lesson6.task1;

import com.epam.kseniya_samokhina.java.lesson6.task1.Device.Device;
import com.epam.kseniya_samokhina.java.lesson6.task1.Device.TypeOfDevice;
import com.epam.kseniya_samokhina.java.lesson6.task1.Utils.MyList;
import com.epam.kseniya_samokhina.java.lesson6.task1.Utils.Serializator;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Device fridge = createDevice("Hansa", "Russia", TypeOfDevice.FRIDGE, 2000, "White", "Kitchen", true);
        Device tv = createDevice("Sony", "Japan", TypeOfDevice.TV, 500, "Black", "Bed room", true);
        Device printer = createDevice("HP", "China", TypeOfDevice.PRINTER, 426, "Gray", "Bed room", false);
        Device computer = createDevice("ASUS", "Korean", TypeOfDevice.COMPUTER, 500, "Black/Silver", "Bed room", false);
        Device cooker = createDevice("Gefest", "Germany", TypeOfDevice.COOKER, 1500, "White", "Kitchen", true);

        MyList<Device> myList = new MyList<>();
        myList.add(fridge);
        myList.add(tv);
        myList.add(printer);
        myList.add(computer);
        myList.add(cooker);
        Scanner in = new Scanner(System.in);
        System.out.println("Choose one of the options: " +
                "\n1 - Serialized all objects" +
                "\n2 - Change device color " +
                "\n3 - Output of all devices" +
                "\n4 - Sorting devices by name that are plugged into the outlet " +
                "\n5 - Total power consumption " +
                "\n6 - Device, whose power is in the range of 1000 to 2000");
        int choice = in.nextInt();
        switch (choice) {
            case 1: {
                for (int i = 0; i < myList.size(); i++) {
                    StringBuilder fileName = new StringBuilder(String.valueOf(myList.get(i).getBrandDevice()));
                    fileName.append(".txt");
                    Serializator.writeObject(String.valueOf(fileName), myList.get(i));
                }
                break;
            }
            case 2: {
                System.out.println("Enter the device brand that you want to change the color ");
                String brand = in.next();
                Device device = Serializator.readObject(String.valueOf(brand + ".txt"));
                device.setColorOfDevice("Red");
                Serializator.writeObject(String.valueOf(brand + ".txt"), device);
                break;
            }
            case 3: {
                System.out.println("Name(Type | Origin | Power | Color | Location | State)\n");
                for (int i = 0; i < myList.size(); i++) {
                    System.out.println(myList.get(i));
                }
                break;
            }
            case 4: {
                System.out.println("\nSorting devices by name that are plugged into the outlet:");
                MyList<Device> sortDeviceByState = getDeviceByState(myList, true);
                for (int i = 0; i < sortDeviceByState.size(); i++) {
                    System.out.println(sortDeviceByState.get(i));
                }
                break;
            }
            case 5: {
                System.out.print("\nTotal power consumption: ");
                Integer sumPower = 0;
                for (int i = 0; i < myList.size(); i++) {
                    if (myList.get(i).isStateOfDevice())
                        sumPower += myList.get(i).getPower();
                }
                System.out.println(sumPower);
                break;
            }
            case 6: {
                System.out.println("\nDevice, whose power is in the range of 1000 to 2000:");
                MyList<Device> sortByPower = getDeviceByPower(myList, 1000, 2000);
                for (int i = 0; i < sortByPower.size(); i++) {
                    System.out.println(sortByPower.get(i));
                }
                break;
            }
        }
    }

    public static MyList<Device> getDeviceByState(MyList<Device> list, boolean state) {
        MyList<Device> result = new MyList<>();
        int countOn = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isStateOfDevice() == state) {
                countOn++;
            }
        }
        String[] brend = new String[countOn];
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isStateOfDevice() == state) {
                brend[temp] = list.get(i).getBrandDevice();
                temp++;
            }
        }
        Arrays.sort(brend);
        for (int i = 0; i < brend.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (brend[i] == list.get(j).getBrandDevice()) {
                    result.add(list.get(j));
                }
            }
        }
        return result;
    }

    public static MyList<Device> getDeviceByPower(MyList<Device> list, int lowerBound, int upperBound) {
        MyList<Device> result = new MyList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPower() >= lowerBound && list.get(i).getPower() <= upperBound) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static Device createDevice(String brand, String origin, TypeOfDevice type, int power, String color, String location, boolean isOn) {
        return new Device(brand, origin, type, power, color, location, isOn);
    }
}
