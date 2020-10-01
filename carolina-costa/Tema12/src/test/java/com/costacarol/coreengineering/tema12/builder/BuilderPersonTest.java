package com.costacarol.coreengineering.tema12.builder;

import com.costacarol.coreengineering.tema12.model.Person;
import com.costacarol.coreengineering.tema12.model.StatesOfBrazilOptions;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BuilderPersonTest {

    @Test
    public void testBuilderCompletePerson() {
        Person person = new PersonBuilder()
                .withName("Xuxa Meneghel")
                .withBornDate(LocalDate.of(1963, Month.MARCH, 27))
                .withAddress("Saturnino de Brito", "74", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();
        Assert.assertEquals("Xuxa Meneghel", person.getName());
        Assert.assertEquals(LocalDate.of(1963, Month.MARCH, 27), person.getBornDate());
        Assert.assertEquals("74", person.getAddress().getNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuilderCompletePersonWithNameNull() {
        Person person = new PersonBuilder()
                .withName(null)
                .withBornDate(LocalDate.of(1963, Month.MARCH, 27))
                .withAddress("Saturnino de Brito", "74", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuilderCompletePersonWithBornDateNull() {
        Person person = new PersonBuilder()
                .withName("Xuxa Meneghel")
                .withBornDate(null)
                .withAddress("Saturnino de Brito", "74", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuilderCompletePersonWithTwoParametersNull() {
        Person person = new PersonBuilder()
                .withName(null)
                .withBornDate(null)
                .withAddress("Saturnino de Brito", "74", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuilderCompletePersonWithEmptyName() {
        Person person = new PersonBuilder()
                .withName("")
                .withBornDate(LocalDate.of(1963, Month.MARCH, 27))
                .withAddress("Saturnino de Brito", "74", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuilderCompletePersonWithStreetAddressEmpty() {
        Person person = new PersonBuilder()
                .withName("Xuxa Meneghel")
                .withBornDate(LocalDate.of(1963, Month.MARCH, 27))
                .withAddress("", "74", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuilderCompletePersonWithNumberAddressEmpty() {
        Person person = new PersonBuilder()
                .withName("Xuxa Meneghel")
                .withBornDate(LocalDate.of(1963, Month.MARCH, 27))
                .withAddress("Saturnino de Brito", "", "Rio de Janeiro", StatesOfBrazilOptions.RJ)
                .build();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuilderCompletePersonWithCityAddressEmpty() {
        Person person = new PersonBuilder()
                .withName("Xuxa Meneghel")
                .withBornDate(LocalDate.of(1963, Month.MARCH, 27))
                .withAddress("Saturnino de Brito", "74", "", StatesOfBrazilOptions.RJ)
                .build();
    }
}