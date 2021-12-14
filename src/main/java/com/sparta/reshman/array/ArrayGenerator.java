package com.sparta.reshman.array;

public class ArrayGenerator {

    public static int[] setSize(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) Math.floor(Math.random() * 1000);
        }
        return array;
    }
}
