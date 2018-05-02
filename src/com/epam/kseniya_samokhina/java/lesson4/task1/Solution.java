package com.epam.kseniya_samokhina.java.lesson4.task1;

import com.epam.kseniya_samokhina.java.lesson4.task1.Device.Device;
import com.epam.kseniya_samokhina.java.lesson4.task1.Device.TypeOfDevice;
import com.epam.kseniya_samokhina.java.lesson4.task1.Utils.ExceptionNegative;
import com.epam.kseniya_samokhina.java.lesson4.task1.Utils.ExceptionOfOrigin;
import com.epam.kseniya_samokhina.java.lesson4.task1.Utils.MyList;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Device fridge = createDevice("Hansa", "Russia", TypeOfDevice.FRIDGE, 2000, "White", "Kitchen", true);
        Device tv = createDevice("Sony", "Japan", TypeOfDevice.TV, 500, "Black", "Bed room", true);
        Device printer = createDevice("HP", "China", TypeOfDevice.PRINTER, 426, "Grey", "Bed room", false);
        Device computer = createDevice("ASUS", "Korean", TypeOfDevice.COMPUTER, 500, "Black/Silver", "Bed room", false);
        Device cooker = createDevice("Gefest", "Germany", TypeOfDevice.COOKER, 1500, "White", "Kitchen", true);

        MyList<Device> myList = new MyList<>();
        myList.add(fridge);
        myList.add(tv);
        myList.add(printer);
        myList.add(computer);
        myList.add(cooker);
        System.out.println("Name(Type | Origin | Power | Color | Location | State)\n");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("\nSorting devices by name that are plugged into the outlet:");
        MyList<Device> sortDeviceByState = getDeviceByState(myList, true);
        for (int i = 0; i < sortDeviceByState.size(); i++) {
            System.out.println(sortDeviceByState.get(i));
        }

        System.out.print("\nTotal power consumption: ");
        Integer sumPower = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).isStateOfDevice())
                sumPower += myList.get(i).getPower();
        }
        System.out.println(sumPower);

        System.out.println("\nDevice, whose power is in the range of 1000 to 2000:");
        MyList<Device> sortByPower = getDeviceByPower(myList, 1000, 2000);
        for (int i = 0; i < sortByPower.size(); i++) {
            System.out.println(sortByPower.get(i));
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
        try {
            if (power < 0) throw new ExceptionNegative(power);
            if(!origin.matches("^\\D*$")) throw new ExceptionOfOrigin(origin);
            return new Device(brand, origin, type, power, color, location, isOn);
        } catch (ExceptionNegative e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (ExceptionOfOrigin e1) {
            System.out.println(e1.getMessage());
            System.exit(0);
        }
        return null;
    }
}
