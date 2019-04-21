package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;
import static com.kodilla.stream.array.ArrayOperations.getAverage;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given When
        int[] numbers = {125, 434, 9856, 757, 7823, 888};

        //Then
        Assert.assertEquals(3313.8333, getAverage(numbers), 0.0001);
    }
}