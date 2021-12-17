package com.sparta.reshman.array;

import com.sparta.reshman.exceptions.InvalidArraySizeException;

public class ArrayGenerator {

    public static int[] setSize(int arraySize) throws InvalidArraySizeException {
        if (arraySize < 2) {
            throw new InvalidArraySizeException();
        }
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) Math.floor(Math.random() * 1000);
        }
        return array;
    }
}
