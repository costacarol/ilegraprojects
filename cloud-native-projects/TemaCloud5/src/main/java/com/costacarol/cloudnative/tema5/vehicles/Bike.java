package com.costacarol.cloudnative.tema5.vehicles;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicles {

    private final double BIKE_PRICE_TOLL = 0.49;

    @Override
    public double getPrice() {
        return BIKE_PRICE_TOLL;
    }

    @Override
    public String toString() {
        return "Bike";
    }
}
