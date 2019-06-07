package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        //Then
        Assert.assertEquals(2, context.getBean(Calculator.class).add(1, 1), 0);
        Assert.assertEquals(-1, context.getBean(Calculator.class).sub(0, 1), 0);
        Assert.assertEquals(3, context.getBean(Calculator.class).mul(2, 1.5), 0);
        Assert.assertEquals(2, context.getBean(Calculator.class).div(10, 5), 0);
    }
}
