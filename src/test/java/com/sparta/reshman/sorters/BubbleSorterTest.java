package com.sparta.reshman.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSorterTest {
    private BubbleSorter bubbleSorter;

    @BeforeEach
    void Setup() {
        bubbleSorter = new BubbleSorter();
    }

    @Test
    void BubbleSortOnAnArrayTest() {
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), bubbleSorter.sort(new int[]{5, 4, 7, 3, 1, 2, 6}));
        bubbleSorter.timeTaken();
    }
}