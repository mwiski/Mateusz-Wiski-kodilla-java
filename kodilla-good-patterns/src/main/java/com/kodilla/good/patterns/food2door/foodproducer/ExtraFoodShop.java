package com.kodilla.good.patterns.food2door.foodproducer;

import com.kodilla.good.patterns.food2door.product.Product;

public class ExtraFoodShop implements FoodProducer {

    private Product product;

    public boolean process(Product product, int orderedQuantity) {
        this.product = product;
        if(product.getQuantity() >= orderedQuantity)
            product.decreaseQuantity(orderedQuantity);
        return true;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
