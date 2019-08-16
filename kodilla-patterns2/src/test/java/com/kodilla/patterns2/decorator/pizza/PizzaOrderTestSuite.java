package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal totalCost = pizzaOrder.getCost();

        //Then
        assertThat(totalCost).isEqualTo(BigDecimal.valueOf(15.0));
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertThat(description).isEqualTo("Pizza with tomato sauce and cheese");
    }

    @Test
    public void testPizzaWithMushroomsTaxiNetworkGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomDecorator(pizzaOrder);

        //When
        BigDecimal totalCost = pizzaOrder.getCost();

        //Then
        assertThat(totalCost).isEqualTo(BigDecimal.valueOf(18.0));
    }

    @Test
    public void testPizzaWithMushroomsTaxiNetworkGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertThat(description).isEqualTo("Pizza with tomato sauce and cheese + mushrooms");
    }

    @Test
    public void testPizzaWithManyIngredientsGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);

        //When
        BigDecimal totalCost = pizzaOrder.getCost();

        //Then
        assertThat(totalCost).isEqualTo(BigDecimal.valueOf(30.0));
    }

    @Test
    public void testPizzaWithManyIngredientsGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertThat(description).isEqualTo("Pizza with tomato sauce and cheese + mushrooms + ham + ham + onion");
    }

    @Test
    public void testPizzaWithHamAndDeliveryGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new DeliveryDecorator(pizzaOrder);

        //When
        BigDecimal totalCost = pizzaOrder.getCost();

        //Then
        assertThat(totalCost).isEqualTo(BigDecimal.valueOf(30.0));
    }

    @Test
    public void testPizzaWithHamAndDeliveryGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new DeliveryDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertThat(description).isEqualTo("Pizza with tomato sauce and cheese + ham with delivery to client");
    }
}