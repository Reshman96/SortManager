package com.sparta.reshman.start;

import com.sparta.reshman.enums.SorterEnums;
import com.sparta.reshman.sorters.*;

public class SortFactory {
    public static Sorter getSorter(SorterEnums sorter) {
        switch(sorter) {
            case BINARY:
                return new BinarySorter();
            case BUBBLE:
                return new BubbleSorter();
            case INSERTION:
                return new InsertionSorter();
            case MERGE:
                return new MergeSorter();
            case QUICK:
                return new QuickSorter();
        }
        return null;
    }
}
