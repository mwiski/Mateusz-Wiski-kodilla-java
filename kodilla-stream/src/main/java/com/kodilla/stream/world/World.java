package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Set;

public final class World {

    private final Set<Continent> continents;

    public World(final Set<Continent> continents) {
        this.continents = continents;
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }
}