package com.kodilla.good.patterns.challenges.orderservice.informationservice;

import com.kodilla.good.patterns.challenges.orderservice.user.User;

public class MailService implements InformationService {

    public boolean inform(User user) {
        String message = "Your product has been ordered";
        return true;
    }
}
