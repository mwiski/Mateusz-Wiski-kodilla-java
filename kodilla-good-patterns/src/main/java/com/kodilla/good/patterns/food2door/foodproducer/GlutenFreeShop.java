package com.kodilla.good.patterns.food2door.foodproducer;

import com.kodilla.good.patterns.food2door.product.Product;

public class GlutenFreeShop implements FoodProducer {

    private double glutenFreeFlourMass;

    public GlutenFreeShop(double glutenFreeFlourCount) {
        this.glutenFreeFlourMass = glutenFreeFlourCount;
    }

    public boolean process(Product product, int orderedQuantity) {
        double requiredFlour = (double) orderedQuantity / 2;
        if(glutenFreeFlourMass >= requiredFlour) {
            product.decreaseQuantity(orderedQuantity);
        }
        return true;
    }
}
