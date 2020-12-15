package com.costacarol.cloudnative.tema2.app;

import com.costacarol.cloudnative.tema2.decorator.*;
import com.costacarol.cloudnative.tema2.service.PetStoreService;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Application {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);

        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        petStoreService.createNewAttendance(1, new MakeAttendanceOnPetStore(new ShortHairCutPet(new WaterOnTheCleaning(new PerfumeOnTheCleaning(new SimpleCleaning())))));
        System.out.println(petStoreService.searchPetByAge(12));
        System.out.println(petStoreService.listHistoryOfServicesByPetId(1));
        System.out.println(petStoreService.topTenRevenuePets());
    }
}
