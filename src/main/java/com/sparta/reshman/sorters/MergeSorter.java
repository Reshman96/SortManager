package com.sparta.reshman.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSorter implements Sorter {
    private static long time;

    @Override
    public List<Integer> sort(int[] generatedArray) {
        List<Integer> list = new ArrayList<>();
        splitSubArray(generatedArray);

        // Not finished yet

        return new ArrayList<>();
    }

    private void splitSubArray(int[] subArray) {
        int midPoint = Math.round((float) subArray.length / 2);
        int[] tempArray1 = new int[midPoint];
        int[] tempArray2 = new int[subArray.length - midPoint];

        for (int i = 0; i < subArray.length; i++) {
            if (i < midPoint) {
                tempArray1[i] = subArray[i];
            } else {
                tempArray2[i - midPoint] = subArray[i];
            }
        }

        System.out.println("tempArray1 inside split = " + Arrays.toString(tempArray1));
        System.out.println("tempArray2 inside split = " + Arrays.toString(tempArray2));

        if (tempArray1.length > 2) {
            splitSubArray(tempArray1);
        }
        if (tempArray2.length > 2) {
            splitSubArray(tempArray2);
        }

        mergeArrays(tempArray1, tempArray2);

    }

    public void mergeArrays(int[] tempArray1, int[] tempArray2) {
        int[] resultArray = new int[tempArray1.length + tempArray2.length];
        int j = 0;
        int k = 0;
        for (int l = 0; l < resultArray.length; l++) {
            if (tempArray1[j] < tempArray2[k]) {
                resultArray[l] = tempArray1[j];
                j++;
                if (j == tempArray1.length) {
                    for (; l < resultArray.length; l++) {
                        resultArray[l] = tempArray2[k];
                        k++;
                        if (k == tempArray2.length) {
                            System.out.println("resultArray = " + Arrays.toString(resultArray));
                            return;
                        }
                    }
                }
            } else {
                resultArray[l] = tempArray2[k];
                k++;
                if (k == tempArray2.length) {
                    for (; l < resultArray.length; l++) {
                        resultArray[l] = tempArray1[j];
                        j++;
                        if (j == tempArray1.length) {
                            System.out.println("resultArray = " + Arrays.toString(resultArray));
                            return;
                        }
                    }
                }
            }
        }

    }

    @Override
    public long timeTaken() {
        return time;
    }
}
