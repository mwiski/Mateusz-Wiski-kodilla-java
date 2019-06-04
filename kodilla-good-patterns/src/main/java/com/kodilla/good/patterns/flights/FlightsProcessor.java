package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsProcessor {

    private List<Flight> flights;

    public FlightsProcessor(List<Flight> flights) {
        this.flights = flights;
    }

    public String findFlightFrom(City city) {
        return flights.stream()
                .filter(flight -> flight.getFrom() == city)
                .map(Flight::toString)
                .collect(Collectors.joining("\n"));
    }

    public String findFlightTo(City city) {
        return flights.stream()
                .filter(flight -> flight.getTo() == city)
                .map(Flight::toString)
                .collect(Collectors.joining("\n"));
    }

    public String findConnectingFlights(City from, City to) {
        List<City> via1 = flights.stream()
                .filter(flight -> flight.getFrom() == from)
                .map(flight -> flight.getTo())
                .collect(Collectors.toList());

        List<City> via2 = flights.stream()
                .filter(flight -> flight.getTo() == to)
                .map(flight -> flight.getFrom())
                .collect(Collectors.toList());

        return via1.stream()
                .filter(city -> via2.contains(city))
                .map(City::toString)
                .collect(Collectors.joining(", ", "Possible connecting flights from " + from.toString() + " to " + to.toString() + " via: ", "."));
    }
}