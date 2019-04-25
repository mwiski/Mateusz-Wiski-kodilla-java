package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;
import static com.kodilla.stream.array.ArrayOperations.getAverage;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverageWhenNull() {
        //Given When
        int[] numbers = null;

        //Then
        Assert.assertEquals(0, getAverage(numbers), 0);
    }

    @Test
    public void testGetAverageWhenArrayIsEmpty() {
        //Given When
        int[] numbers = {};

        //Then
        Assert.assertEquals(0, getAverage(numbers), 0);
    }

    @Test
    public void testGetAverageWhenArrayHasOneNumber() {
        //Given When
        int[] numbers = {1};

        //Then
        Assert.assertEquals(1, getAverage(numbers), 0);
    }

    @Test
    public void testGetAverageWhenArrayHasMultipleNumbers() {
        //Given When
        int[] numbers = {1, 2, 3};

        //Then
        Assert.assertEquals(2, getAverage(numbers), 0);
    }
}