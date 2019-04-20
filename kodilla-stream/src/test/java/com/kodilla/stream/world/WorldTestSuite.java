package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.HashSet;

public class WorldTestSuite {

    private World initWorld () {
        Continent europe = new Continent(new HashSet<>());
        Continent asia = new Continent(new HashSet<>());
        Continent africa = new Continent(new HashSet<>());
        Continent northAmerica = new Continent(new HashSet<>());

        europe.addCountry(new Country("Poland", new BigDecimal("38945192")));
        europe.addCountry(new Country("Germany", new BigDecimal("80123543")));
        europe.addCountry(new Country("France", new BigDecimal("60565836")));
        asia.addCountry(new Country("China", new BigDecimal("1562465966")));
        asia.addCountry(new Country("India", new BigDecimal("1260535848")));
        asia.addCountry(new Country("Japan", new BigDecimal("85123453")));
        africa.addCountry(new Country("Egypt", new BigDecimal("90876346")));
        africa.addCountry(new Country("Rwanda", new BigDecimal("20965784")));
        africa.addCountry(new Country("Niger", new BigDecimal("47873456")));
        northAmerica.addCountry(new Country("USA", new BigDecimal("356875329")));
        northAmerica.addCountry(new Country("Mexico", new BigDecimal("152398538")));
        northAmerica.addCountry(new Country("Canada", new BigDecimal("32097126")));

        World world = new World(new HashSet<>());
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);

        return world;
    }

    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = initWorld();
        BigDecimal expected = new BigDecimal("3788846417");

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(expected, result);
    }
}