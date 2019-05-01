package com.kodilla.exception.test;

import java.util.Map;

public final class FlightsProcessor {
    private Map<String, Boolean> airports;

    public FlightsProcessor(Map<String, Boolean> airports) {
        this.airports = airports;
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        try {
            return airports.get(flight.getArrivalAirport());
        } catch (NullPointerException e) {
            throw new RouteNotFoundException("Route to " + flight.getArrivalAirport() + " not found");
        }
    }
}