package com.costacarol.cloudnative.tema2.service;

import com.costacarol.cloudnative.tema2.decorator.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;

public class PetStoreServiceTest {

    @Test
    public void testAddPet() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        Assert.assertEquals("00080080008", petStoreService.listRegisterPets().get(0).getTutorCpf());
    }

    @Test
    public void testAddDuplicatedPet() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        Assert.assertEquals(1, petStoreService.listRegisterPets().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullNameOfTutor() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet(null, "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddEmptyNameOfTutor() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullCpfOfTutor() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", null, "Penny", "Cat NoRace BlackAndWhite", 12);
     }

    @Test (expected = IllegalArgumentException.class)
    public void testAddEmptyCpfOfTutor() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "", "Penny", "Cat NoRace BlackAndWhite", 12);
    }

     @Test (expected = IllegalArgumentException.class)
    public void testAddNullNameOfPet() {
         Injector injector = Guice.createInjector();
         PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", null, "Cat NoRace BlackAndWhite", 12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddEmptyNameOfPet() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "", "Cat NoRace BlackAndWhite", 12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullRaceOfPet() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", null, 12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddEmptyRaceOfPet() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "", 12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNegativeAgePet() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", -1);
    }

    @Test
    public void testRemovePet() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        petStoreService.addPet("Carolina", "10080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        Assert.assertEquals(2, petStoreService.listRegisterPets().size());
        petStoreService.removePet(1);
        Assert.assertEquals(1, petStoreService.listRegisterPets().size());
    }

    @Test
    public void testListRegisterPets() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        petStoreService.addPet("Carolina", "10080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        Assert.assertEquals(2, petStoreService.listRegisterPets().size());
    }

    @Test
    public void testListRegisterPetsEmpty() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        Assert.assertTrue(petStoreService.listRegisterPets().isEmpty());
    }

    @Test
    public void testSearchPetByAge() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        Assert.assertFalse(petStoreService.searchPetByAge(12).isEmpty());
        Assert.assertTrue(petStoreService.searchPetByAge(13).isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSearchPetByAgeWithNegativeAge() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        petStoreService.searchPetByAge(-12);
    }

    @Test
    public void testSearchPetByTutor() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        Assert.assertTrue(petStoreService.searchPetByCpfTutorAndName("00080080008", "Penny").isPresent());
    }

    @Test
    public void testCreateNewAttendance() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        Assert.assertEquals(35.0, petStoreService.createNewAttendance(1, new MakeAttendanceOnPetStore(new LongHairCutPet(new SimpleCleaning()))), 0.0);
    }

    @Test
    public void testTopTenRevenuePets() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite", 12);
        petStoreService.addPet("Carolina", "10080080008", "Manish", "Cat NoRace Black", 11);
        petStoreService.addPet("Carolina", "11080080008", "Maggie", "Dog NoRace Yellow", 8);
        petStoreService.createNewAttendance(1, new MakeAttendanceOnPetStore(new LongHairCutPet(new SimpleCleaning())));
        petStoreService.createNewAttendance(2, new MakeAttendanceOnPetStore(new ShortHairCutPet(new WaterOnTheCleaning(new SimpleCleaning()))));
        petStoreService.createNewAttendance(3, new MakeAttendanceOnPetStore(new ShortHairCutPet(new WaterOnTheCleaning(new PerfumeOnTheCleaning(new SimpleCleaning())))));
        Assert.assertEquals(3, petStoreService.topTenRevenuePets().get(0).getId());
        Assert.assertEquals(2, petStoreService.topTenRevenuePets().get(1).getId());
        Assert.assertEquals(1, petStoreService.topTenRevenuePets().get(2).getId());
    }

    @Test
    public void testListHistoryOfServicesByPetId() {
        Injector injector = Guice.createInjector();
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);
        petStoreService.addPet("Carolina", "00080080008", "Penny", "Cat NoRace BlackAndWhite",12);
        petStoreService.createNewAttendance(1, new MakeAttendanceOnPetStore(new LongHairCutPet(new SimpleCleaning())));
        Assert.assertEquals("Services realized on 2020-10-23: long cut on hair + simple cleaning", petStoreService.listHistoryOfServicesByPetId(1).get(0).toString());
    }
}