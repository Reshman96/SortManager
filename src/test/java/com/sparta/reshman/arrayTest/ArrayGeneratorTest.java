package com.sparta.reshman.arrayTest;

import com.sparta.reshman.array.ArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayGeneratorTest {

    @Test
    void setSizeTest() {
        Assertions.assertEquals(10,ArrayGenerator.setSize(10).length);
    }
}
