package com.sparta.reshman.array;

public class ArrayGenerator {

    public static int[] size(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) Math.floor(Math.random() * 10);
        }
        return array;
    }
}
