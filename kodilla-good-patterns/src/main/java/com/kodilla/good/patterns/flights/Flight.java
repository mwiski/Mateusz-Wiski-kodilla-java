package com.kodilla.good.patterns.flights;

import java.util.Objects;

public final class Flight {

    private final FlightType flightType;
    private final CityType from;
    private final CityType to;
    private final CityType through;

    public Flight(final CityType from, final CityType to, final CityType through) {
        this.flightType = FlightType.CONNECTING;
        this.from = from;
        this.to = to;
        this.through = through;
    }

    public Flight(final CityType from, final CityType to) {
        this.flightType = FlightType.DIRECT;
        this.from = from;
        this.to = to;
        this.through = null;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public CityType getFrom() {
        return from;
    }

    public CityType getTo() {
        return to;
    }

    public CityType getThrough() {
        return through;
    }

    @Override
    public String toString() {
        if (flightType == FlightType.CONNECTING) {
            return "Flight{" +
                    "flightType = " + flightType +
                    ", from = " + from +
                    ", to = " + to +
                    ", through = " + through +
                    '}';
        } else {
            return "Flight{" +
                    "flightType = " + flightType +
                    ", from = " + from +
                    ", to = " + to +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return flightType == flight.flightType &&
                from == flight.from &&
                to == flight.to &&
                through == flight.through;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightType, from, to, through);
    }
}