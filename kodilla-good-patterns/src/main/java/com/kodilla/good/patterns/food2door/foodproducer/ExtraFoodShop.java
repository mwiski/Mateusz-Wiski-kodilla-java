package com.kodilla.good.patterns.food2door.foodproducer;

import com.kodilla.good.patterns.food2door.product.Product;

public class ExtraFoodShop implements FoodProducer {

    public boolean process(Product product, int orderedQuantity) {
        if(product.getQuantity() >= orderedQuantity)
            product.decreaseQuantity(orderedQuantity);
        return true;
    }
}
