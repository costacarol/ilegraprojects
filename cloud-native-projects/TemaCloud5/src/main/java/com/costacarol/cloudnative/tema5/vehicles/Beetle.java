package com.costacarol.cloudnative.tema5.vehicles;

import org.springframework.stereotype.Component;

@Component
public class Beetle implements Vehicles {

    private final double BEETLE_PRICE_TOLL = 2.11;

    @Override
    public double getPrice() {
        return BEETLE_PRICE_TOLL;
    }

    @Override
    public String toString() {
        return "Beetle";
    }
}
