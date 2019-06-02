package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightsRetriever {

    public List<Flight> retrieve() {

        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight(CityType.WARSAW, CityType.BERLIN));
        flights.add(new Flight(CityType.WARSAW, CityType.KRAKOW));
        flights.add(new Flight(CityType.WARSAW, CityType.KRAKOW, CityType.WROCLAW));
        flights.add(new Flight(CityType.WARSAW, CityType.ROME, CityType.BERLIN));
        flights.add(new Flight(CityType.LONDON, CityType.WARSAW));
        flights.add(new Flight(CityType.BERLIN, CityType.WARSAW));
        flights.add(new Flight(CityType.ROME, CityType.WARSAW, CityType.BERLIN));
        flights.add(new Flight(CityType.WROCLAW, CityType.WARSAW));
        flights.add(new Flight(CityType.GDANSK, CityType.WROCLAW, CityType.KRAKOW));
        flights.add(new Flight(CityType.GDANSK, CityType.WROCLAW, CityType.WARSAW));

        return flights;
    }
}