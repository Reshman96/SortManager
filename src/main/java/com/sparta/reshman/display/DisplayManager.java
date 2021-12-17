package com.sparta.reshman.display;

import com.sparta.reshman.enums.SorterEnums;

import java.util.Arrays;
import java.util.List;

public class DisplayManager {

    public static void displaySelectedSorter(SorterEnums sortingMethodName) {
        System.out.println("Sorting using " + SorterEnums.toString(sortingMethodName));
    }

    public static void displaySort(List<Integer> sortedArray) {
        System.out.println(sortedArray);
    }

    public static void displayTime(long timeTaken) {
        System.out.println("Time taken: " + timeTaken + " nanoseconds.\n");
    }

    public static void displayUnsortedArray(int[] generatedArray) {
        System.out.println(Arrays.toString(generatedArray));
    }

    public static void requestArraySize() {
        System.out.println("Please enter the desired size of the array as a number: ");
    }

    public static void requestSorter() {
        System.out.println("Please select the Sorter method by entering the option number below: ");
        System.out.println("1) BinarySorter \n" +
                "2) BubbleSorter \n" +
                "3) MergeSorter");
    }

    public static void displayStartOver() {
        System.out.println("Would you like to perform another sort? (Yes / No)");
    }
}
