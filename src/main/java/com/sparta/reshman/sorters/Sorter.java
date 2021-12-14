package com.sparta.reshman.sorters;

import java.util.List;

public interface Sorter {

    List<Integer> sort(int[] generatedArray);

    long timeTaken();
}
