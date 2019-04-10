package com.kodilla.testing.collection;
import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList<>();
        //When
        ArrayList<Integer> numbers2 = exterminator.exterminate(numbers);
        System.out.println("Testing empty list case");
        //Then
        Assert.assertArrayEquals(numbers.toArray(), numbers2.toArray());
    }
    @Test
    public void testOddNumbersExterminatorNormalList () {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> numbers = new ArrayList<>();
        exterminator.init(numbers);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(2);
        result.add(4);
        result.add(6);
        //When
        exterminator.exterminate(numbers);
        System.out.println("Testing normal list case");
        //Then
        Assert.assertArrayEquals(result.toArray(), numbers.toArray());
    }
}
