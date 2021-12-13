package com.sparta.reshman.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SorterEnumsTest {

    @Test
    void toMethodNameTest() {
        Assertions.assertEquals(SorterEnums.BUBBLE, SorterEnums.toMethodName(2));
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals("MergeSorter", SorterEnums.toString(SorterEnums.MERGE));
    }
}
