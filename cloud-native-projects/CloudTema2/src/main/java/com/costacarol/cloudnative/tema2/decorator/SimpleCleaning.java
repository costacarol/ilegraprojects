package com.costacarol.cloudnative.tema2.decorator;

public class SimpleCleaning implements ServiceOfferedOnPetStore {

    private final double PRICE_SIMPLE_CLEANING = 20.0;


    public double getPRICE_SIMPLE_CLEANING() {
        return PRICE_SIMPLE_CLEANING;
    }

    @Override
    public String toString() {
        return " simple cleaning";
    }

    @Override
    public double totalServicePrice() {
        return getPRICE_SIMPLE_CLEANING();
    }
}
