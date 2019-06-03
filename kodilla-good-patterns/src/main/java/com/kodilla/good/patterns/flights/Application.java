package com.kodilla.good.patterns.flights;

public class Application {

    public static void main(String[] args) {

        FlightsRetriever retriever = new FlightsRetriever();
        FlightsProcessor flightsProcessor = new FlightsProcessor(retriever.retrieve());

        System.out.println(flightsProcessor.findFlightFrom(City.WARSAW));
        System.out.println();
        System.out.println(flightsProcessor.findFlightTo(City.WARSAW));
        System.out.println();
        System.out.println(flightsProcessor.findFlightVia(City.KRAKOW));
    }
}