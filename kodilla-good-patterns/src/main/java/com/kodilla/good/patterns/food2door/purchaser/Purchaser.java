package com.kodilla.good.patterns.food2door.purchaser;

import java.util.Objects;

public class Purchaser {

    private String firstName;
    private String lastName;
    private String address;

    public Purchaser(String firstName, String lastName, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchaser)) return false;
        Purchaser purchaser = (Purchaser) o;
        return firstName.equals(purchaser.firstName) &&
                lastName.equals(purchaser.lastName) &&
                address.equals(purchaser.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address);
    }
}
