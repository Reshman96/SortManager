package com.sparta.reshman.enums;

public enum SorterEnums {
    BINARY,
    BUBBLE,
    MERGE;

    public static String toString(SorterEnums methodName) {
        switch (methodName) {
            case BINARY:
                return "BinarySorter";
            case BUBBLE:
                return "BubbleSorter";
            case MERGE:
                return "MergeSorter";
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
                return MERGE;
        }
        return null;
    }
}
