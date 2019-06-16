package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {

            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 4) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("Burgers number should be less than four");
            }
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {

            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {

            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (bun != null) {
                return new Bigmac(bun, burgers, sauce, ingredients);
            } else {
                throw new IllegalStateException("Bigmac must have bun");
            }
        }
    }

    private Bigmac(final Bun bun, final int burgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public Bun getBun() {
        return bun;
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
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
