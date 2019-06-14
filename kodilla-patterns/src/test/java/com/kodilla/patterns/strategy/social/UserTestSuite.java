package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    private User adam = new Millenials("Adam Małysz");
    private User jan = new YGeneration("Jan Kowalski");
    private User justin = new ZGeneration("Justin Bieber");

    @Test
    public void testDefaultSharingStrategies() {

        //Then
        Assert.assertEquals("Twitter", adam.sharePost());
        Assert.assertEquals("Facebook", jan.sharePost());
        Assert.assertEquals("Snapchat", justin.sharePost());
    }

    @Test
    public void testIndividualSharingStrategy() {
        //When
        jan.setSocialPublisher(new TwitterPublisher());

        //Then
        Assert.assertEquals("Twitter", jan.sharePost());
    }
}
