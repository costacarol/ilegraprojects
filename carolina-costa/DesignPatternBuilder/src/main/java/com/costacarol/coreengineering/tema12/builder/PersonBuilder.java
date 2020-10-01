package com.costacarol.coreengineering.tema12.builder;

import com.costacarol.coreengineering.tema12.model.Address;
import com.costacarol.coreengineering.tema12.model.Person;
import com.costacarol.coreengineering.tema12.model.StatesOfBrazilOptions;
import java.time.LocalDate;

public class PersonBuilder {

    private Person person;

    public PersonBuilder(){
        this.person = new Person();
    }

    public PersonBuilder withAddress(String street, String number, String city, StatesOfBrazilOptions state){
        if(street == null || number == null || city == null || state == null || street.equalsIgnoreCase("null") || number.equalsIgnoreCase("null") || city.equalsIgnoreCase("null")) {
            throw new IllegalArgumentException("Parâmetro(s) inválido(s): um ou mais parâmetros inseridos com valor nulo.");
        }
        else if(street.isEmpty() || number.isEmpty() || city.isEmpty()){
            throw new IllegalArgumentException("Endereço incompleto: o endereço deve possuir o nome da rua+número+cidade+estado).");
        }
        Address address = new Address();
        address.setStreet(street);
        address.setNumber(number);
        address.setCity(city);
        address.setState(state);
        person.setAddress(address);
        return this;
    }

    public PersonBuilder withName(String name){
        if(name == null || name.equalsIgnoreCase("null")) {
            throw new IllegalArgumentException("Parâmetro inválido: informe um nome. ");
        }
        else if(name.isEmpty()){
            throw new IllegalArgumentException("Parâmetro inválido: informe um nome.");
        }
        person.setName(name);
        return this;
    }

    public PersonBuilder withBornDate(LocalDate bornDate){
        if(bornDate == null) {
            throw new IllegalArgumentException("Parâmetro inválido: informe um data de nascimento.");
        }
        person.setBornDate(bornDate);
        return this;
    }


    public Person build(){
        return person;
    }
}
