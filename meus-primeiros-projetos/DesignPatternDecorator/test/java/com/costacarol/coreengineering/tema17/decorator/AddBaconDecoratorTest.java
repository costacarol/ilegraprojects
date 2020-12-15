package com.costacarol.coreengineering.tema17.decorator;

import org.junit.Assert;
import org.junit.Test;

public class AddBaconDecoratorTest {

    @Test
    public void testGetPriceAddBaconInThePizza(){
        Pizza pizza = new AddBaconDecorator(new PizzaDough());
        Assert.assertEquals(23.5, pizza.getPrice(), 0.0);
    }

    @Test
    public void testGetPriceAddDoubleBaconInThePizza(){
        Pizza pizza = new AddBaconDecorator(new AddBaconDecorator(new PizzaDough()));
        Assert.assertEquals(27, pizza.getPrice(), 0.0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetPriceNullParameterInThePizza(){
        Pizza pizza = new AddBaconDecorator(null);
        pizza.getPrice();
    }
}