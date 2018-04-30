package com.epam.kseniya_samokhina.java.lesson2.task1.Utils;

public class MyList<Device> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Device[] array = (Device[]) new Object[INIT_SIZE];
    private int pointer = 0;

    public Device get(int index) {
        return (Device) array[index];
    }

    public void add(Device item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Device[] newArray = (Device[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
