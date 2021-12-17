package com.sparta.reshman.sorters;

import java.util.ArrayList;
import java.util.List;

public class BubbleSorter implements Sorter {
    private static long time;

    @Override
    public List<Integer> sort(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int number : array) {
            list.add(number);
        }

        time = 0;
        long start = System.nanoTime();
        boolean flag = true;

        while(flag) {

            // Turning the flag off so that the while loop only plays once unless it's changed later
            flag = false;

            // Looping through the list and checking neighbouring elements
            for (int i = 1; i < list.size(); i++) {

                // If the current element in the list is smaller than the previous element, swap them around
                if (list.get(i) < list.get(i - 1)) {
                    int tempNum = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, tempNum);

                    // Flag changed to true so that the process can repeat since there may be more swapping necessary
                    flag = true;
                }
            }
        }
        long end = System.nanoTime();
        time = (end - start) / 1000;
        return list;
    }

    @Override
    public long timeTaken() {
        return time;
    }
}
