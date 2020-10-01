package com.costacarol.coreengineering.tema5;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BlueLampTest extends TestCase {
    BlueLamp testBlueLamp = new BlueLamp();

    @Test
    public void testBlueIsOn() throws Exception {

        StateLamp stateBlueOn = new StateLamp(testBlueLamp);
        stateBlueOn.switchState();
        Assert.assertTrue(testBlueLamp.getState());
    }

    @Test
    public void testBlueIsOff() throws Exception {
        StateLamp stateBlueOff = new StateLamp(testBlueLamp);
        Assert.assertFalse(testBlueLamp.getState());

    }
}