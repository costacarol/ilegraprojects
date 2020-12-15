package com.costacarol.cloudnative.tema2.decorator;

public class ShortHairCutPet extends MakeAttendanceOnPetStore {

    private final double PRICE_SHORT_CUT = 10.0;

    public ShortHairCutPet(ServiceOfferedOnPetStore serviceOfferedOnPetStore) {
        super(serviceOfferedOnPetStore);
    }

    public double getPRICE_SHORT_CUT() {
        return PRICE_SHORT_CUT;
    }

    @Override
    public String toString() {
        return " short cut on hair +" + serviceOfferedOnPetStore;
    }

    @Override
    public double totalServicePrice() {
        return  super.totalServicePrice() + getPRICE_SHORT_CUT();
    }
}
