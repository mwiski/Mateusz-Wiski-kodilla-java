package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final BunType bunType;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    public static class Builder {
        private BunType bunType;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public Builder bun(BunType bunType) {

            this.bunType = bunType;
            return this;
        }

        public Builder burgers(int burgers) {
            if (burgers < 4) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("Burgers number should be less than four");
            }
            return this;
        }

        public Builder sauce(Sauce sauce) {

            this.sauce = sauce;
            return this;
        }

        public Builder addIngredient(Ingredient ingredient) {

            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (bunType != null) {
                return new Bigmac(bunType, burgers, sauce, ingredients);
            } else {
                throw new IllegalStateException("Bigmac must have a bun");
            }
        }
    }

    private Bigmac(final BunType bunType, final int burgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.bunType = bunType;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public BunType getBunType() {
        return bunType;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bunType='" + bunType + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
