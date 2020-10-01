package com.costacarol.coreengineering.tema12.model;

public class Address {

    private String street, number, city;
    private StatesOfBrazilOptions state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public StatesOfBrazilOptions getState() {
        return state;
    }

    public void setState(StatesOfBrazilOptions state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Rua " + getStreet() +
                ", nº " + getNumber() +
                ", " + getCity() +
                ", " + getState();
    }
}
