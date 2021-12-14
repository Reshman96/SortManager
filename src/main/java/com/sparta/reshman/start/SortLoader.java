package com.sparta.reshman.start;

import com.sparta.reshman.array.ArrayGenerator;
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

        // Asks the user to select the type of sorter and saves it as an int variable
        DisplayManager.requestSorter();
        int sortingMethodNumber = scanner.nextInt();
        scanner.nextLine();


        // Asks the user to select the size of the array and saves it as an int variable
        DisplayManager.requestArraySize();
        int arraySize = scanner.nextInt();
        scanner.nextLine();


        // Converts int variable to the selected sorter type
        SorterEnums sortingMethodName = SorterEnums.toMethodName(sortingMethodNumber);

        // Generates the unsorted array
        int[] generatedArray = ArrayGenerator.size(arraySize);

        // Prints the sorter name being used
        DisplayManager.sort(sortingMethodName);

    }
}
