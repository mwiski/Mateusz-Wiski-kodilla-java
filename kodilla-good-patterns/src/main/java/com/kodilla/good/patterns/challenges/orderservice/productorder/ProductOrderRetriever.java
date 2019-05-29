package com.kodilla.good.patterns.challenges.orderservice.productorder;

import com.kodilla.good.patterns.challenges.orderservice.product.Toothbrush;
import com.kodilla.good.patterns.challenges.orderservice.user.User;

public class ProductOrderRetriever {

    private ProductOrder productOrder;

    public ProductOrder retrieve() {

        User user = new User("Jan", "Kowalski", "jkowalski", "kowalskijan001", "jkowalski@gmail.com");
        Toothbrush toothbrush = new Toothbrush("Oral B", "1231", 99);

        return productOrder = new ProductOrder(user, toothbrush, "001a", 1);
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }
}
