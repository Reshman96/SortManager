package com.sparta.reshman.tests;

import com.sparta.reshman.array.ArrayGenerator;
import com.sparta.reshman.sorters.BinarySorter;
import com.sparta.reshman.sorters.BubbleSorter;
import com.sparta.reshman.sorters.MergeSorter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PerformanceTester {
    private static int[] randomArray;
    private final int[] unsortedArray = new int[randomArray.length];
    /*
    Take an array and run every single sort algorithm against it.
    And gives time taken in nanoseconds to see how fast they are.
     */

    @BeforeAll
    static void classSetup() {
        randomArray = ArrayGenerator.setSize(100);
    }

    @BeforeEach
    void setup() {
        for (int i = 0; i < randomArray.length; i++) {
            unsortedArray[i] = randomArray[i];
        }
    }

    @Test
    void testBinarySorter() {
        BinarySorter binary = new BinarySorter();
        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
        System.out.println("BinarySorter:");
        System.out.println(binary.sort(unsortedArray));
        System.out.println("Time taken: " + binary.timeTaken() + " nanoseconds\n");
        System.out.println("**************************************\n");
    }

    @Test
    void testBubbleSorter() {
        BubbleSorter bubble = new BubbleSorter();
        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
        System.out.println("BubbleSorter:");
        System.out.println(bubble.sort(unsortedArray));
        System.out.println("Time taken: " + bubble.timeTaken() + " nanoseconds\n");
        System.out.println("**************************************\n");
    }

    @Test
    void testMergeSorter() {
        MergeSorter merge = new MergeSorter();
        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
        System.out.println("MergeSorter:");
        System.out.println(merge.sort(unsortedArray));
        System.out.println("Time taken: " + merge.timeTaken() + " nanoseconds\n");
        System.out.println("**************************************\n");
    }
}
