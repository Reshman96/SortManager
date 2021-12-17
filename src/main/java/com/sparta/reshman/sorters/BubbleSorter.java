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
            flag = false;

            for (int i = 1; i < list.size(); i++) {

                if (list.get(i) < list.get(i - 1)) {
                    int tempNum = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, tempNum);

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
