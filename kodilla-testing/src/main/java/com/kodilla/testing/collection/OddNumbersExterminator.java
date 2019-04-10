package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> numbersEven = new ArrayList<>();
        for (Integer number : numbers) {
            if (number == 0 || number % 2 == 0)
                numbersEven.add(number);
        }
        numbers.clear();
        numbers.addAll(numbersEven);
        return numbers;
    }

    private static ArrayList<Integer> initList(ArrayList<Integer> numbers) {
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        return numbers;
    }

    public ArrayList<Integer> init(ArrayList<Integer> numbers) {
        return initList(numbers);
    }
}
