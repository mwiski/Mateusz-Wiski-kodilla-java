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
        List<Integer> result = exterminator.exterminate(numbers);
        System.out.println("Testing empty list case");

        //Then
        Assert.assertEquals(numbers, result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList () {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(2);
        expected.add(4);
        expected.add(6);

        //When
        List<Integer> result = exterminator.exterminate(numbers);
        System.out.println("Testing normal list case");

        //Then
        Assert.assertEquals(expected, result);
    }
}
