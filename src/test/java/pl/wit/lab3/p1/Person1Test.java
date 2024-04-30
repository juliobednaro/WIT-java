package pl.wit.lab3.p1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class Person1Test {

    @Test
    void firstNameTest() {
        Person1 person1 = new Person1();

        person1.setFirstName("Julian");

        Assertions.assertEquals("Julian", person1.getFirstName());
    }

    @Test
    void lastNameTest() {
        Person1 person1 = new Person1();

        person1.setLastName("Bednarz");

        Assertions.assertEquals("Bednarz", person1.getLastName());
    }

    @Test
    void dateOfBirthTest() {
        Person1 person1 = new Person1();

        person1.setDateOfBirth(new Date(2001-1900, 1, 1));

        Assertions.assertEquals(2001, person1.getDateOfBirth().getYear()+1900);
        Assertions.assertEquals(1, person1.getDateOfBirth().getMonth());
        Assertions.assertEquals(1, person1.getDateOfBirth().getDate());
    }
}