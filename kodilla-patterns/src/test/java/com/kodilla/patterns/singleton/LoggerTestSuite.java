package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLogWhenNotLogged() {

        //Then
        Assert.assertEquals("", Logger.getInstance().getLastLog());
    }

    @Test
    public void testGetLastLogWhenLogged() {
        //When
        Logger.getInstance().log("test");

        //Then
        Assert.assertEquals("test", Logger.getInstance().getLastLog());
    }
}
