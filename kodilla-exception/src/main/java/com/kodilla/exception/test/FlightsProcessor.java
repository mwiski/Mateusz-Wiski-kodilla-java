package com.kodilla.exception.test;

import java.util.Map;

public final class FlightsProcessor {
    private final Map<String, Boolean> airports;

    public FlightsProcessor(final Map<String, Boolean> airports) {
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