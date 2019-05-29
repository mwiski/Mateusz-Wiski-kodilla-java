package com.kodilla.good.patterns.challenges.orderservice.user;

import java.util.Objects;

public class User {

    private String firstName;
    private String lastName;
    private String nickName;
    private String eMail;
    private String userId;

    public User(String firstName, String lastName, String nickName, String userId, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.userId = userId;
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                nickName.equals(user.nickName) &&
                eMail.equals(user.eMail) &&
                userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, nickName, eMail, userId);
    }
}
