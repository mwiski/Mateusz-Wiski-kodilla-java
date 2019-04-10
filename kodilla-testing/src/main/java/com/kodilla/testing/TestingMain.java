package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();

        int addTest = calculator.add(3, 5);
        int subtractTest = calculator.subtract(18, 6);

        if (addTest == 8) {
            System.out.println("Success! Calculator's method add() test was positive!");
        } else {
            System.out.println("Error! Calculator's method add() is not working properly.");
        }

        if (subtractTest == 12) {
            System.out.println("Success! Calculator's method subtract test was positive!");
        } else {
            System.out.println("Error! Calculator's method subtract() is not working properly.");
        }
    }
}

