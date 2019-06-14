package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;

public class YGeneration extends User {

    public YGeneration(String name) {
        super(name);
        setSocialPublisher(new FacebookPublisher());
    }
}