package com.costacarol.coreengineering.tema5;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WhiteLampTest extends TestCase {
    WhiteLamp testWhiteLamp = new WhiteLamp();

    @Test
    public void testWhiteIsOn() throws Exception {

        StateLamp stateWhiteOn = new StateLamp(testWhiteLamp);
        stateWhiteOn.switchState();
        Assert.assertTrue(testWhiteLamp.getState());
    }
    @Test
    public void testWhiteIsOff() throws Exception{

        StateLamp stateWhiteOff = new StateLamp(testWhiteLamp);
        Assert.assertFalse(testWhiteLamp.getState());
    }
}