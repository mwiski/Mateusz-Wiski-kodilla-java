package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public final class Country {

    private final BigDecimal population;
    private final String name;

    public Country(final String name, final BigDecimal population) {
        this.name = name;
        this.population = population;
    }

    public BigDecimal getPeopleQuantity() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return population.equals(country.population) &&
                name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(population, name);
    }
}