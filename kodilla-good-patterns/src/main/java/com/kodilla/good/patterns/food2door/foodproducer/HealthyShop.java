package com.kodilla.good.patterns.food2door.foodproducer;

import com.kodilla.good.patterns.food2door.product.Product;
import java.util.LinkedList;
import java.util.List;

public class HealthyShop implements FoodProducer {

    private List<Product> products;

    public HealthyShop() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean process(Product product, int orderedQuantity) {
        if(products.contains(product) && product.getQuantity() >= orderedQuantity)
            product.decreaseQuantity(orderedQuantity);
        return true;
    }
}
