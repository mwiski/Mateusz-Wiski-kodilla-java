package com.kodilla.stream.world;

import java.util.Objects;
import java.util.Set;

public final class Continent {

    private final Set<Country> countries;

    public Continent(final Set<Country> countries) {
        this.countries = countries;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public Set<Country> getCountries() {
        return countries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;
        Continent continent = (Continent) o;
        return countries.equals(continent.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countries);
    }
}