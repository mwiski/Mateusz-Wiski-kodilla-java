package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public List<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> numbersEven = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0)
                numbersEven.add(number);
        }
        return numbersEven;
    }
}
