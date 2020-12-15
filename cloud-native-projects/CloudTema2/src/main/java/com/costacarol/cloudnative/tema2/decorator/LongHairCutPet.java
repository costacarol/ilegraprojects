package com.costacarol.cloudnative.tema2.decorator;

public class LongHairCutPet extends MakeAttendanceOnPetStore {

    private final double PRICE_LONG_CUT = 15.0;

    public LongHairCutPet(ServiceOfferedOnPetStore serviceOfferedOnPetStore) {
        super(serviceOfferedOnPetStore);
    }


    public double getPRICE_LONG_CUT() {
        return PRICE_LONG_CUT;
    }

    @Override
    public String toString() {
        return " long cut on hair +" + serviceOfferedOnPetStore;
    }

    @Override
    public double totalServicePrice() {
        return super.totalServicePrice() + getPRICE_LONG_CUT();
    }
}
