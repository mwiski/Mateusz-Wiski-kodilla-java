package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsProcessor {

    private List<Flight> flights;

    public FlightsProcessor(List<Flight> flights) {
        this.flights = flights;
    }

    public String findFlightFrom(CityType city) {
        return flights.stream()
                .filter(flight -> flight.getFrom() == city)
                .map(Flight::toString)
                .collect(Collectors.joining("\n"));
    }

    public String findFlightTo(CityType city) {
        return flights.stream()
                .filter(flight -> flight.getTo() == city)
                .map(Flight::toString)
                .collect(Collectors.joining("\n"));
    }

    public String findFlightThrough(CityType from, CityType to, CityType through) {
        return flights.stream()
                .filter(flight -> flight.getFrom() == from && flight.getTo() == to && flight.getThrough() == through)
                .map(Flight::toString)
                .collect(Collectors.joining("\n"));
    }
}