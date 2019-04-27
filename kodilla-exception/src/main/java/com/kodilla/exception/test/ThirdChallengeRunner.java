package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class ThirdChallengeRunner {

    private static Map<String, Boolean> init() {

        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Wrocław", true);
        airports.put("Kijów", true);
        airports.put("Londyn", true);
        airports.put("Paryż", false);

        return airports;
    }

    public static void main(String[] args) {

        FlightsProcessor processor = new FlightsProcessor(init());

        try {
            System.out.println(processor.findFlight(new Flight("Warszawa", "Kijów")));
            System.out.println(processor.findFlight(new Flight("Warszawa", "Paryż")));
            System.out.println(processor.findFlight(new Flight("Warszawa", "Nowy Jork")));

        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
    }
}