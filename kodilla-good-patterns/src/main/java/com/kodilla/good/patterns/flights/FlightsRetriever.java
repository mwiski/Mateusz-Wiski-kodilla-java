package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightsRetriever {

    public List<Flight> retrieve() {

        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight(City.WARSAW, City.BERLIN));
        flights.add(new Flight(City.WARSAW, City.KRAKOW));
        flights.add(new Flight(City.WARSAW, City.KRAKOW, City.WROCLAW));
        flights.add(new Flight(City.WARSAW, City.ROME, City.BERLIN));
        flights.add(new Flight(City.LONDON, City.WARSAW));
        flights.add(new Flight(City.BERLIN, City.WARSAW));
        flights.add(new Flight(City.ROME, City.WARSAW, City.BERLIN));
        flights.add(new Flight(City.WROCLAW, City.WARSAW));
        flights.add(new Flight(City.GDANSK, City.WROCLAW, City.KRAKOW));
        flights.add(new Flight(City.GDANSK, City.WROCLAW, City.WARSAW));

        return flights;
    }
}