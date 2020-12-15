package com.costacarol.cloudnative.tema2.decorator;

public class PerfumeOnTheCleaning extends MakeAttendanceOnPetStore {

    public PerfumeOnTheCleaning(ServiceOfferedOnPetStore serviceOfferedOnPetStore){
        super(serviceOfferedOnPetStore);
    }

    private final double PERFUME_COST = 10.0;

    public double getPERFUME_COST() {
        return PERFUME_COST;
    }

    @Override
    public String toString() {
        return " add perfume on the cleaning +" + serviceOfferedOnPetStore;
    }

    @Override
    public double totalServicePrice() {
        return super.totalServicePrice() + getPERFUME_COST();
    }
}
