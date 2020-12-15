package com.costacarol.coreengineering.tema12.model;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate bornDate;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                ", data de nascimento: " + bornDate +
                ", endereço: " + address + ".";
    }
}
