package pl.wit.lab3.p1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

class Employee1Test {
    Employee1 employee1 = null;

    @BeforeEach
    void setUp() {
        this.employee1 =  new Employee1();
    }

    @Test
    void nameTest() {
        this.employee1.setFirstName("Mark");
        this.employee1.setLastName("Robbers");

        Assertions.assertEquals("Mark", this.employee1.getFirstName());
        Assertions.assertEquals("Robbers", this.employee1.getLastName());
    }

    @Test
    void employmentTest() {
        this.employee1.setEmploymentDate(new Date(2022-1900, 4, 3));
        this.employee1.setSallary(new BigDecimal(1234));

        Assertions.assertEquals(2022, this.employee1.getEmploymentDate().getYear()+1900);
        Assertions.assertEquals(4, this.employee1.getEmploymentDate().getMonth());
        Assertions.assertEquals(3, this.employee1.getEmploymentDate().getDate());
    }

    @Test
    void sallaryTest() {
        this.employee1.setSallary(new BigDecimal(11000));

        Assertions.assertTrue(this.employee1.getSallary().compareTo(new BigDecimal(11000)) == 0);
    }
}