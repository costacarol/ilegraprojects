package com.costacarol.cloudnative.tema5.vehicles;

import org.springframework.stereotype.Component;

@Component
public class Truck implements Vehicles {

    private final double TRUCK_PRICE_TOLL = 3.95;
    private int numberOfAxle = 1;

    @Override
    public double getPrice() {
        return TRUCK_PRICE_TOLL * getNumberOfAxle() ;
    }

    public int getNumberOfAxle() {
        return numberOfAxle;
    }

    public void setNumberOfAxle(int numberOfAxle) {
        this.numberOfAxle = numberOfAxle;
    }

    @Override
    public String toString() {
        return "Truck";
    }
}
