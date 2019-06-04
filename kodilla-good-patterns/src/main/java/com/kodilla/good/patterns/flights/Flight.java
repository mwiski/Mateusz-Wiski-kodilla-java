package com.kodilla.good.patterns.flights;

import java.util.Objects;

public final class Flight {

    private final City from;
    private final City to;

    public Flight(final City from, final City to) {
        this.from = from;
        this.to = to;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "from = " + from +
                ", to = " + to +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return from == flight.from &&
                to == flight.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}