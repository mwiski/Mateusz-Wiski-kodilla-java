package com.kodilla.testing.shape;

import com.kodilla.testing.forum.shape.ShapeCollector;
import com.kodilla.testing.forum.shape.*;
import org.junit.*;

import java.awt.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Square square = new Square(10);

        //When
        collector.addFigure(square);

        //Then
        Assert.assertEquals(square, collector.getFigure(0));
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(10);

        //When
        boolean result = collector.removeFigure(circle);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Triangle triangle = new Triangle(5, 10);

        //When
        collector.addFigure(triangle);
        boolean result = collector.removeFigure(triangle);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(null, collector.getFigure(0));
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Square expected = new Square(10);

        //When
        collector.addFigure(expected);
        Square result = (Square) collector.getFigure(0);

        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testShowFiguresWhenNone() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Square square = new Square(10);
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(10, 5);

        //When
        String result = collector.showFigures();
        String expectedOutput = "";

                //Then
        Assert.assertEquals(expectedOutput, result);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Square square = new Square(10);
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(10, 5);

        //When
        collector.addFigure(square);
        collector.addFigure(circle);
        collector.addFigure(triangle);
        String result = collector.showFigures();
        String expectedOutput = square.getName() + "\n" + circle.getName() + "\n" + triangle.getName() + "\n";

        //Then
        Assert.assertEquals(expectedOutput, result);
    }
}
