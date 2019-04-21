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

        europe.addCountry(new Country("Poland", BigDecimal.valueOf(38945192)));
        europe.addCountry(new Country("Germany", BigDecimal.valueOf(80123543)));
        europe.addCountry(new Country("France", BigDecimal.valueOf(60565836)));
        asia.addCountry(new Country("China", BigDecimal.valueOf(1562465966)));
        asia.addCountry(new Country("India", BigDecimal.valueOf(1260535848)));
        asia.addCountry(new Country("Japan", BigDecimal.valueOf(85123453)));
        africa.addCountry(new Country("Egypt", BigDecimal.valueOf(90876346)));
        africa.addCountry(new Country("Rwanda", BigDecimal.valueOf(20965784)));
        africa.addCountry(new Country("Niger", BigDecimal.valueOf(47873456)));
        northAmerica.addCountry(new Country("USA", BigDecimal.valueOf(356875329)));
        northAmerica.addCountry(new Country("Mexico", BigDecimal.valueOf(152398538)));
        northAmerica.addCountry(new Country("Canada", BigDecimal.valueOf(32097126)));

        World world = new World(new HashSet<>());
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);

        return world;
    }

    @Test
    public void testGetPeopleQuantity() {
        //Given When
        World world = initWorld();

        //Then
        Assert.assertEquals(BigDecimal.valueOf(3788846417L), world.getPeopleQuantity());
    }
}