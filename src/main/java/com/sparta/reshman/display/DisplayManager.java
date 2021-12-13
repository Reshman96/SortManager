package com.sparta.reshman.display;

import com.sparta.reshman.enums.SorterEnums;

public class DisplayManager {

    /*
    Only deals with printing/displaying
     */

    public static void requestSorter() {
        System.out.println("Please select the Sorter method by entering the option number below: ");
        System.out.println("1) BinarySorter \n" +
                "2) BubbleSorter \n " +
                "3) InsertionSorter \n + " +
                "4) MergeSorter \n + " +
                "5) QuickSorter");
    }

    public static void requestArraySize() {
        System.out.println("Please enter the desired size of the array as a number: ");
    }

    public static void sort(SorterEnums sortingMethodName) {
        System.out.println("Sorting using " + SorterEnums.toString(sortingMethodName));
    }

}
