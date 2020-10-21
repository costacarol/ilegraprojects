package com.costacarol.coreengineering.tema17.decorator;

public class MakePizzaDecorator extends Pizza {

    Pizza pizza;

    public MakePizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        if(pizza == null){
            throw new IllegalArgumentException("Parâmetro inválido: é necessário informar a massa da pizza para efetuar o cálculo do valor.");
        }
        return pizza.getPrice();
    }
}
