package com.costacarol.cloudnative.tema5.vehicles;

import org.springframework.stereotype.Component;

@Component
public class Motorcycle implements Vehicles {

    private final double MOTO_PRICE_TOLL = 1;

    @Override
    public double getPrice() {
        return MOTO_PRICE_TOLL;
    }

    @Override
    public String toString() {
        return "Motorcycle";
    }
}
