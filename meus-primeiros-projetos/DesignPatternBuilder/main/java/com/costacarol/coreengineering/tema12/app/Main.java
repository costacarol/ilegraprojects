package com.costacarol.coreengineering.tema12.app;

import com.costacarol.coreengineering.tema12.builder.PersonBuilder;
import com.costacarol.coreengineering.tema12.model.Person;
import com.costacarol.coreengineering.tema12.model.StatesOfBrazilOptions;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Person person1 = new PersonBuilder()
                .withName("Xuxa Meneghel")
                .withBornDate(LocalDate.of(1963, Month.MARCH, 27))
                .withAddress("Saturnino de Brito", "74", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();

        System.out.println(person1);
    }
}

