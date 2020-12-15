package com.costacarol.cloudnative.tema5.vehicles;

import org.springframework.stereotype.Component;

@Component
public class Bus implements Vehicles {

    private final double BUS_PRICE_TOLL = 1.59;

    @Override
    public double getPrice() {
        return BUS_PRICE_TOLL;
    }

    @Override
    public String toString() {
        return "Bus";
    }
}
