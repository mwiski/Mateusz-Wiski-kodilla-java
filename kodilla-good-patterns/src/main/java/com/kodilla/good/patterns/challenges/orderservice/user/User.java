package com.kodilla.good.patterns.challenges.orderservice.user;

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
}
