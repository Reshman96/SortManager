package com.sparta.reshman.sorters;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter implements Sorter {
    private static long time;

    @Override
    public List<Integer> sort(int[] generatedArray) {

        int midPoint = Math.round((float) generatedArray.length / 2);
        int[] tempArray1 = new int[midPoint];
        int[] tempArray2 = new int[generatedArray.length - midPoint];

        for (int i = 0; i < generatedArray.length; i++) {
            if (i < midPoint) {
                tempArray1[i] = generatedArray[i];
            } else {
                tempArray2[i - midPoint] = generatedArray[i];
            }
        }

        splitSubArray(tempArray1);
        splitSubArray(tempArray2);


        // Not finished yet

        return new ArrayList<>();
    }

    private int[] splitSubArray(int[] subArray) {
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

        if (tempArray1.length > 1) {
            splitSubArray(tempArray1);
        }
        if (tempArray2.length > 1) {
            splitSubArray(tempArray2);
        }

        int[] resultArray = new int[tempArray1.length + tempArray2.length];
        int j = 0;
        int k = 0;
        for (int l = 0; l < resultArray.length; l++) {
            if (tempArray1[j] > tempArray2[k]) {
                resultArray[l] = tempArray1[j];
                j++;
            } else {
                resultArray[l] = tempArray2[k];
                k++;
            }
        }
        return resultArray;
    }

    @Override
    public long timeTaken() {
        return time;
    }
}
