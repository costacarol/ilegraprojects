package com.costacarol.cloudnative.tema2.model;

import com.costacarol.cloudnative.tema2.decorator.ServiceOfferedOnPetStore;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private String tutorName;
    private String tutorCpf;
    private String name;
    private String race;
    private int id;
    private int age;

    private List<ServiceOfferedOnPetStore> historyOfServices;

    public Pet(String tutorName, String tutorCpf, String name, String race, int age, int id) {
        this.tutorName = tutorName;
        this.tutorCpf = tutorCpf;
        this.name = name;
        this.race = race;
        this.age = age;
        this.id = id;
        this.historyOfServices = new ArrayList<>();
    }

    public List<ServiceOfferedOnPetStore> getListHistoryOfServices(){
        return historyOfServices;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getId() {
        return id;
    }

    public String getTutorName() {
        return tutorName;
    }

    public String getTutorCpf() {
        return tutorCpf;
    }

    public double getTotalRevenueGeneratedToThePetStore() {
        double sum = getListHistoryOfServices().stream()
                .mapToDouble(total -> total.totalServicePrice())
                .sum();
        return sum;
        }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pet id number " + getId() + ": " +
                "race='" + getRace() + '\'' +
                ", tutorName='" + getTutorName() + '\'' +
                ", tutorCpf='" + getTutorCpf() + '\'' +
                ", name='" + getName() + '\'' +
                ", age= " + getAge() +
                ", totalRevenueGeneratedThePetStore= $" + getTotalRevenueGeneratedToThePetStore() +
                '}';
    }
}
