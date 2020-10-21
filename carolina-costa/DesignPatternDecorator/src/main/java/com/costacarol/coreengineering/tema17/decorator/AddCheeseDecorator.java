package com.costacarol.coreengineering.tema17.decorator;

public class AddCheeseDecorator extends MakePizzaDecorator {

    private final double CHEESE_PRICE = 3.0;

    public AddCheeseDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + CHEESE_PRICE;
    }
}
