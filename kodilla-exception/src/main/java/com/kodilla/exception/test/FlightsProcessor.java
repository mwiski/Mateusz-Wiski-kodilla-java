package com.kodilla.exception.test;

import java.util.Map;

public class FlightsProcessor {
    private Map<String, Boolean> airports;

    public FlightsProcessor(Map<String, Boolean> airports) {
        this.airports = airports;
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        for (Map.Entry<String, Boolean> entry : airports.entrySet()) {
            if (entry.getKey() == flight.getArrivalAirport()) {
                return entry.getValue();
            }
        }
        throw new RouteNotFoundException();
    }
}