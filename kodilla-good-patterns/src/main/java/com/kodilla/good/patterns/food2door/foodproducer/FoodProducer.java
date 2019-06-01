package com.kodilla.good.patterns.food2door.foodproducer;

import com.kodilla.good.patterns.food2door.product.Product;

public interface FoodProducer {

    boolean process(Product product, int orderedQuantity);

    Product getProduct();
}
