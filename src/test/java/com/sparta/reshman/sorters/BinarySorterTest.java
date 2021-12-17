package com.sparta.reshman.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinarySorterTest {
    private BinarySorter binarySorter;

    @BeforeEach
    void setup() {
        binarySorter = new BinarySorter();
    }

    @Test
    void sortTest() {
        int[] generatedArray = new int[] {45, 54, 23, 98, 11, 66};
        Assertions.assertEquals(Arrays.asList(11, 23, 45, 54, 66, 98), binarySorter.sort(generatedArray));
    }
}
