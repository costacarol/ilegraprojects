package com.costacarol.coreengineering.tema17.app;

import com.costacarol.coreengineering.tema17.decorator.*;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new MakePizzaDecorator(new AddCheeseDecorator(new AddCheeseDecorator(new AddBaconDecorator(new PizzaDough()))));
        System.out.println("O valor da pizza de bacon com o dobro de queijo é R$ " + pizza.getPrice() + ".");
    }
}
