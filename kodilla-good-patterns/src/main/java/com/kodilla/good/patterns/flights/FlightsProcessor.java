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
        return flights.stream()
                .filter(flight -> flight.getFrom() == from)
                .map(Flight::getTo)
                .filter(city -> flights.stream()
                        .filter(flight -> flight.getTo().equals(to))
                        .map(Flight::getFrom)
                        .anyMatch(c -> c.equals(city)))
                .map(City::toString)
                .collect(Collectors.joining(" or ", "Possible connecting flights from " + from.toString() + " to " + to.toString() + " via: ", ""));
    }
}