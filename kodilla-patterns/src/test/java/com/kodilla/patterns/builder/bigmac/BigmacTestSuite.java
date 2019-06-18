package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuild() {
        //Given When
        Bigmac bigmac = new Bigmac.Builder()
                .bun(BunType.SEZAME)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .addIngredient(Ingredient.CHEESE)
                .addIngredient(Ingredient.LETTUCE)
                .addIngredient(Ingredient.CUCUMBER)
                .addIngredient(Ingredient.ONION)
                .addIngredient(Ingredient.MUSHROOM)
                .build();

        System.out.println(bigmac);

        //Then
        Assert.assertEquals(5, bigmac.getIngredients().size());
        Assert.assertEquals(BunType.SEZAME, bigmac.getBunType());
        Assert.assertEquals(2, bigmac.getBurgers());
    }
}
