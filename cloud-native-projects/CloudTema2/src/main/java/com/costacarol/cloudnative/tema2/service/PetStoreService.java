package com.costacarol.cloudnative.tema2.service;

import com.costacarol.cloudnative.tema2.model.Pet;
import com.costacarol.cloudnative.tema2.decorator.ServiceOfferedOnPetStore;
import com.google.inject.Singleton;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Singleton
public class PetStoreService {

    private AtomicInteger atomicInteger;

    private List<Pet> petRegister;

    public PetStoreService(){
        this.petRegister = new ArrayList<>();
        this.atomicInteger = new AtomicInteger(1);
    }

    public boolean addPet(String tutorName, String tutorCpf, String petName, String race, int age){
        if(tutorName == null || tutorName.isEmpty() || tutorCpf == null || tutorCpf.isEmpty() || petName == null || petName.isEmpty() || race == null || race.isEmpty()){
            throw new IllegalArgumentException("Invalid Parameter: all fields are mandatory.");
        }
        if(age < 0){
            throw new IllegalArgumentException("Invalid parameter: insert a number equal to or above zero");
        }
        if(!searchPetByCpfTutorAndName(tutorCpf, petName).isPresent()) {
            int id = atomicInteger.getAndIncrement();
            petRegister.add(new Pet(tutorName, tutorCpf, petName, race, age, id));
            return true;
        }
        return false;
    }

    public void removePet(int id){
        listRegisterPets().removeIf(pet -> pet.getId() == id);
    }

    public List<Pet> listRegisterPets(){
        return petRegister;
    }

    public List<Pet> searchPetByAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid parameter: insert a number equal to or above zero");
        }
            List<Pet> petWithInformedAge = petRegister.stream()
                    .filter(pet -> pet.getAge() == age)
                    .collect(Collectors.toList());
                return petWithInformedAge;
        }



    public Optional<Pet> searchPetByCpfTutorAndName(String tutorCpf, String petName){
        for (Pet pet: petRegister)
            if(tutorCpf.equals(pet.getTutorCpf()) && petName.equalsIgnoreCase(pet.getName())){
                return Optional.of(pet);
            }
        return Optional.empty();
    }

    public double createNewAttendance(int id, ServiceOfferedOnPetStore serviceOfferedOnPetStore){
        for (Pet pet: petRegister){
            if(id == pet.getId()) {
                pet.getListHistoryOfServices().add(serviceOfferedOnPetStore);
            }
        }
        return serviceOfferedOnPetStore.totalServicePrice();
    }

    public List<Pet> topTenRevenuePets(){
        List<Pet> topTenRevenuePets = petRegister.stream()
                .limit(10)
                .sorted(Comparator.comparing(Pet::getTotalRevenueGeneratedToThePetStore).reversed())
                .collect(Collectors.toList());
        return topTenRevenuePets;
    }

    public List<ServiceOfferedOnPetStore> listHistoryOfServicesByPetId(int id){
        for (Pet pet: petRegister){
            if (pet.getId() == id){
                return pet.getListHistoryOfServices();
            }
        }
        return Collections.emptyList();
    }
}
