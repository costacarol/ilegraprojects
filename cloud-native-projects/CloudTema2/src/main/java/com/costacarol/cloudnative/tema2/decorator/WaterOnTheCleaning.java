package com.costacarol.cloudnative.tema2.decorator;

public class WaterOnTheCleaning extends MakeAttendanceOnPetStore {

    public WaterOnTheCleaning(ServiceOfferedOnPetStore serviceOfferedOnPetStore) {
        super(serviceOfferedOnPetStore);
    }

    private final double WATER_BATH_PRICE = 10.0;

    public double getWATER_BATH_PRICE() {
        return WATER_BATH_PRICE;
    }

    @Override
    public String toString() {
        return " add water on the cleaning +" + serviceOfferedOnPetStore;
    }

    public double totalServicePrice() {
        return super.totalServicePrice() + getWATER_BATH_PRICE();
    }
}
