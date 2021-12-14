package com.sparta.reshman.start;

import com.sparta.reshman.array.ArrayGenerator;
import com.sparta.reshman.display.DisplayManager;
import com.sparta.reshman.enums.SorterEnums;
import com.sparta.reshman.sorters.Sorter;

import java.util.List;
import java.util.Scanner;

public class SortLoader {

    public static void start() {

        Scanner scanner = new Scanner(System.in);

        // User selects sorter
        DisplayManager.requestSorter();
        int sortingMethodNumber = scanner.nextInt();
        scanner.nextLine();


        // User selects array size
        DisplayManager.requestArraySize();
        int arraySize = scanner.nextInt();
        scanner.nextLine();


        // Retrieves sorter type
        SorterEnums sortingMethodName = SorterEnums.toMethodName(sortingMethodNumber);


        // Generates the unsorted array
        int[] generatedArray = ArrayGenerator.setSize(arraySize);


        // Prints the sorter name
        DisplayManager.displayUnsortedArray(generatedArray);
        DisplayManager.displaySelectedSorter(sortingMethodName);


        // Prints the array after sorting using the selected sorter
        assert sortingMethodName != null;
        Sorter sorter = SortFactory.getSorter(sortingMethodName);
        assert sorter != null;
        List<Integer> sortedArray = sorter.sort(generatedArray);
        DisplayManager.displaySort(sortedArray);

        // Prints the time taken for the sorter to sort the array
        DisplayManager.displayTime(sorter.timeTaken());
    }
}
