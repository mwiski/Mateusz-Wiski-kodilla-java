package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

public class MoviePrinterTest {

    @Test
    public void testPrint() {
        //Given
        MoviePrinter moviePrinter = new MoviePrinter(new MovieStore());

        //Then
        Assert.assertEquals("Żelazny Człowiek ! Iron Man ! Mściciele ! Avengers ! Błyskawica ! Flash", moviePrinter.print());
    }
}
