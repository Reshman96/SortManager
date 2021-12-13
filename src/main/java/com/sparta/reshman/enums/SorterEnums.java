package com.sparta.reshman.enums;

public enum SorterEnums {
    BINARY,
    BUBBLE,
    INSERTION,
    MERGE,
    QUICK;

    public static String toString(SorterEnums methodName) {
        switch (methodName) {
            case BINARY:
                return "BinarySorter";
            case BUBBLE:
                return "BubbleSorter";
            case INSERTION:
                return "InsertionSorter";
            case MERGE:
                return "MergeSorter";
            case QUICK:
                return "QuickSorter";
        }
        return null;
    }

    public static SorterEnums toMethodName(int sortingMethodNumber) {
        switch (sortingMethodNumber) {
            case 1:
                return BINARY;
            case 2:
                return BUBBLE;
            case 3:
                return INSERTION;
            case 4:
                return MERGE;
            case 5:
                return QUICK;
        }
        return null;
    }
}
