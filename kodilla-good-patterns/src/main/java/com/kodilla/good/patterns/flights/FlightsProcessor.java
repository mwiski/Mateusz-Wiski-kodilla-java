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

    public String findFlightVia(City via) {
        return flights.stream()
                .filter(flight -> flight.getVia() == via)
                .map(Flight::toString)
                .collect(Collectors.joining("\n"));
    }
}