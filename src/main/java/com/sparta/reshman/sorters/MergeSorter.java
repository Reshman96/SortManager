package com.sparta.reshman.sorters;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter implements Sorter {
    private static long time;
    private static int arraySize;

    @Override
    public List<Integer> sort(int[] generatedArray) {
        arraySize = generatedArray.length;
        List<Integer> list = new ArrayList<>();
        int arrayLength = generatedArray.length;
        time = 0;
        long start = System.nanoTime();
        splitAndSort(generatedArray, arrayLength, list);
        long end = System.nanoTime();
        time = (end - start) / 1000;
        return list;
    }

    private void splitAndSort(int[] subArray, int arrayLength, List<Integer> list) {
        if (arrayLength < 2) {
            return;
        }
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
//        System.out.println("tempArray1 inside split = " + Arrays.toString(tempArray1));
//        System.out.println("tempArray2 inside split = " + Arrays.toString(tempArray2));
        splitAndSort(tempArray1, midPoint, list);
        splitAndSort(tempArray2, arrayLength - midPoint, list);

//        System.out.println("about to perform mergeArrays with " + Arrays.toString(tempArray1) + " and " + Arrays.toString(tempArray2) + " currently list looks like " + list);

        mergeArrays(subArray, tempArray1, tempArray2, midPoint, arrayLength - midPoint, list);

    }

    public void mergeArrays(int[] subArray, int[] tempArray1, int[] tempArray2, int arraySize1, int arraySize2, List<Integer> list) {
        int j = 0;
        int k = 0;
        for (int l = 0; l < subArray.length; l++) {
            if (tempArray1[j] < tempArray2[k]) {
                subArray[l] = tempArray1[j];
                j++;
                if (j == arraySize1) {
                    l++;
                    for (; l < subArray.length; l++) {
                        subArray[l] = tempArray2[k];
                        k++;
                        if (k == arraySize2) {
//                            System.out.println("tempArray3 = " + Arrays.toString(subArray));
                            if (subArray.length == arraySize) {
                                for (int i : subArray) {
                                    list.add(i);
                                }
                            }
                        }
                    }
                }
            } else {
                subArray[l] = tempArray2[k];
                k++;
                if (k == tempArray2.length) {
                    l++;
                    for (; l < subArray.length; l++) {
                        subArray[l] = tempArray1[j];
                        j++;
                        if (j == arraySize1) {
//                            System.out.println("tempArray3 = " + Arrays.toString(subArray));
                            if (subArray.length == arraySize) {
                                for (int i : subArray) {
                                    list.add(i);
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("when returning result list is " + list);
        }
    }

    @Override
    public long timeTaken() {
        return time;
    }
}
