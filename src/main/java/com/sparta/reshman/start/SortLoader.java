package com.sparta.reshman.start;

import com.sparta.reshman.array.ArrayGenerator;
import com.sparta.reshman.display.DisplayManager;
import com.sparta.reshman.enums.SorterEnums;
import com.sparta.reshman.sorters.Sorter;

import java.util.Scanner;

public class SortLoader {

    public static void start() {

        Scanner scanner = new Scanner(System.in);

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
        int[] generatedArray = ArrayGenerator.setSize(arraySize);


        // Prints the sorter name being used and saves it as a variable
        DisplayManager.displayPreSort(sortingMethodName);


        // Prints the array after sorting using the selected sorter
        assert sortingMethodName != null;
        Sorter sorter = SortFactory.getSorter(sortingMethodName);
        assert sorter != null;
        int[] sortedArray = sorter.sort(generatedArray);
        DisplayManager.displaySort(sortedArray);

        // Prints the time taken for the sorter to sort the array
        DisplayManager.displayTime(sorter.timeTaken());
    }
}
