package com.costacarol.coreengineering.tema17.decorator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddCheeseDecoratorTest {

    @Test
    public void testGetPriceAddCheeseInThePizza(){
        Pizza pizza = new AddCheeseDecorator(new PizzaDough());
        Assert.assertEquals(23, pizza.getPrice(), 0.0);
    }

    @Test
    public void testGetPriceAddDoubleCheeseInThePizza(){
        Pizza pizza = new AddCheeseDecorator(new AddCheeseDecorator(new PizzaDough()));
        Assert.assertEquals(26, pizza.getPrice(), 0.0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetPriceNullParameterInThePizza(){
        Pizza pizza = new AddCheeseDecorator(null);
        pizza.getPrice();
    }
}