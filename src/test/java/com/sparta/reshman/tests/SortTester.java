package com.sparta.reshman.tests;

import com.sparta.reshman.sorters.BinarySorter;
import com.sparta.reshman.sorters.BubbleSorter;
import com.sparta.reshman.sorters.MergeSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTester {
    private BinarySorter binary;
    private BubbleSorter bubble;
    private MergeSorter merge;

    @BeforeEach
    void setup() {
        binary = new BinarySorter();
        bubble = new BubbleSorter();
        merge = new MergeSorter();
    }

    @Test
    void properlySortsTest() {
        Assertions.assertEquals(Arrays.asList(23, 46, 65, 87), binary.sort(new int[] {65, 23, 87, 46}));
        Assertions.assertEquals(Arrays.asList(23, 46, 65, 87), bubble.sort(new int[] {65, 23, 87, 46}));
        Assertions.assertEquals(Arrays.asList(23, 46, 65, 87), merge.sort(new int[] {65, 23, 87, 46}));
    }

    @Test
    void singleNumberLengthTest() {
//        Assertions.assertEquals();
    }

    @Test
    void oddNumberLengthTest() {
        Assertions.assertEquals(Arrays.asList(23, 46, 65, 87, 94), merge.sort(new int[] {94, 65, 23, 87, 46}));
    }

    @Test
    void duplicateNumbersTest() {
        Assertions.assertEquals(Arrays.asList(35, 47, 53, 77), binary.sort(new int[] {53, 47, 53, 53, 77, 35}));
        Assertions.assertEquals(Arrays.asList(35, 47, 53, 77), merge.sort(new int[] {53, 47, 53, 53, 77, 35}));
    }

    @Test
    void largeNumberTest() {
//        Assertions.assertEquals(bubble.sort());
    }
}
