package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuild() {
        //Given When
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.SEZAME)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.LETTUCE)
                .ingredient(Ingredient.CUCUMBER)
                .ingredient(Ingredient.ONION)
                .ingredient(Ingredient.MUSHROOM)
                .build();

        System.out.println(bigmac);

        //Then
        Assert.assertEquals(5, bigmac.getIngredients().size());
        Assert.assertEquals(Bun.SEZAME, bigmac.getBun());
        Assert.assertEquals(2, bigmac.getBurgers());
    }
}
