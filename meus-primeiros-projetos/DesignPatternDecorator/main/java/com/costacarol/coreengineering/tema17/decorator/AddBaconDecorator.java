package com.costacarol.coreengineering.tema17.decorator;

public class AddBaconDecorator extends MakePizzaDecorator {

    private final double BACON_PRICE = 3.5;

    public AddBaconDecorator(Pizza pizza){
       super(pizza);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + BACON_PRICE;
    }
}
