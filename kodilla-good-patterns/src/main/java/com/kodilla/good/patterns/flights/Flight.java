package com.kodilla.good.patterns.flights;

import java.util.Objects;

public final class Flight {

    private final City from;
    private final City to;
    private final City via;

    public Flight(final City from, final City to, final City via) {
        this.from = from;
        this.to = to;
        this.via = via;
    }

    public Flight(final City from, final City to) {
        this.from = from;
        this.to = to;
        this.via = null;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public City getVia() {
        return via;
    }

    @Override
    public String toString() {
        if (via == null) {
            return "Flight{" +
                    "from = " + from +
                    ", to = " + to +
                    '}';
        } else {
            return "Flight{" +
                    "from = " + from +
                    ", to = " + to +
                    ", via = " + via +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return from == flight.from &&
                to == flight.to &&
                via == flight.via;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, via);
    }
}