package com.costacarol.cloudnative.tema2.decorator;

import java.time.LocalDate;

public class MakeAttendanceOnPetStore implements ServiceOfferedOnPetStore {

    ServiceOfferedOnPetStore serviceOfferedOnPetStore;

    public MakeAttendanceOnPetStore(ServiceOfferedOnPetStore petStore){
        this.serviceOfferedOnPetStore = petStore;
    }

    @Override
    public String toString() {
        return "Services realized on " + LocalDate.now() + ":" + serviceOfferedOnPetStore;
    }

    @Override
    public double totalServicePrice() {
        return serviceOfferedOnPetStore.totalServicePrice();
    }
}
