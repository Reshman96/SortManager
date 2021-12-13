package com.sparta.reshman.start;

import com.sparta.reshman.display.DisplayManager;
import com.sparta.reshman.enums.SorterEnums;

import java.util.Scanner;

public class SortLoader {

    public static void start() {

        Scanner scanner = new Scanner(System.in);
        /*
        1. Request which sorter the user wants to use (BinarySorter, BubbleSorter,
        InsertionSorter, MergeSorter, QuickSorter)
        2. Request the size of the array user wants to generate
        3. "Sorting using (sortername)"
            "Before sorting:"
            "(array/array list?)"
            "After sorting:"
            "(array/array list?)"
            "Time taken: (nanoseconds) nanoseconds"
         */

        DisplayManager.requestSorter();
        int sortingMethodNumber = scanner.nextInt();
        scanner.nextLine();

        DisplayManager.requestArraySize();
        int arraySize = scanner.nextInt();
        scanner.nextLine();

        SorterEnums sortingMethodName = SorterEnums.toMethodName(sortingMethodNumber);
        DisplayManager.sort(sortingMethodName);
    }
}
