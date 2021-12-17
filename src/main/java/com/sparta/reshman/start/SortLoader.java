package com.sparta.reshman.start;

import com.sparta.reshman.array.ArrayGenerator;
import com.sparta.reshman.display.DisplayManager;
import com.sparta.reshman.enums.SorterEnums;
import com.sparta.reshman.exceptions.InvalidArraySizeException;
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
        SorterEnums sortingMethodName = SorterEnums.toMethodName(sortingMethodNumber);

        // User selects array size
        DisplayManager.requestArraySize();
        int[] generatedArray = new int[1];
        boolean flag = true;
        while(flag) {
            try {
                int arraySize = scanner.nextInt();
                scanner.nextLine();
                generatedArray = ArrayGenerator.setSize(arraySize);
                flag = false;
            } catch (InvalidArraySizeException e) {
                DisplayManager.getInvalidArraySizeExceptionMessage(e.getMessage());
                DisplayManager.displayTryAgain();
            }
        }

        // Prints the sorter name
        DisplayManager.displayUnsortedArray(generatedArray);
        DisplayManager.displaySelectedSorter(sortingMethodName);

        // Prints the array and time taken after sorting using the selected sorter
        Sorter sorter = SortFactory.getSorter(sortingMethodName);
        List<Integer> sortedArray = sorter.sort(generatedArray);
        DisplayManager.displaySort(sortedArray);
        DisplayManager.displayTime(sorter.timeTaken());

        // Asks the user if they'd like to perform another sort. If yes, replays the app, otherwise terminates
        DisplayManager.displayStartOver();
        String wantToReset = scanner.nextLine();
        if (wantToReset.toLowerCase().contains("yes")) {
            start();
        }
    }
}
