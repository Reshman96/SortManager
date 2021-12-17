package com.sparta.reshman.sorters.binaryTree;

import com.sparta.reshman.sorters.MergeSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSorterTest {
    private MergeSorter mergeSorter;


    @BeforeEach
    void setup() {
        mergeSorter = new MergeSorter();
    }

    @Test
    void sortTest() {
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), mergeSorter.sort(new int[]{6, 5, 3, 1, 8, 7, 2, 4}));

    }

    @Test
    void main() {
        System.out.println(mergeSorter.sort(new int[]{6, 5, 3, 1, 8, 7, 2, 4}));
    }
}
