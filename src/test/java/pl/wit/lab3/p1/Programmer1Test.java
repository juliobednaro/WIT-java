package pl.wit.lab3.p1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;


class Programmer1Test {
    Programmer1 programmer1 = null;

    @BeforeEach
    void setUp() {
        this.programmer1 =  new Programmer1("John", "Wick", new Date(1987-1900, 4, 3), new Date(2015-190, 6, 17), new BigDecimal(60000));
    }

    @Test
    void addProgrammingLanguage() {
        this.programmer1.addProgrammingLanguage("Python", (short) 6);

        Assertions.assertEquals("Python 6", programmer1.getProgrammingLanguageInfo("Python"));
    }

    @Test
    void changeFirstNameTest() {
        this.programmer1.setFirstName("Jay");

        Assertions.assertEquals("Jay", this.programmer1.getFirstName());
        Assertions.assertNotEquals("John", this.programmer1.getFirstName());
        Assertions.assertEquals("Wick", this.programmer1.getLastName());
    }

    @Test
    void changeLastNameTest() {
        this.programmer1.setLastName("Wunderbaum");

        Assertions.assertEquals("John", this.programmer1.getFirstName());
        Assertions.assertEquals("Wunderbaum", this.programmer1.getLastName());
        Assertions.assertNotEquals("Wick", this.programmer1.getLastName());
    }

    @Test
    void changeEmploymentTest() {
        this.programmer1.setEmploymentDate(new Date(2023-1900, 8, 3));
        this.programmer1.setSallary(new BigDecimal(1234));

        Assertions.assertEquals(2023, this.programmer1.getEmploymentDate().getYear()+1900);
        Assertions.assertEquals(8, this.programmer1.getEmploymentDate().getMonth());
        Assertions.assertEquals(3, this.programmer1.getEmploymentDate().getDate());

        Assertions.assertNotEquals(2015, this.programmer1.getEmploymentDate().getYear()+1900);
        Assertions.assertNotEquals(6, this.programmer1.getEmploymentDate().getMonth());
        Assertions.assertNotEquals(17, this.programmer1.getEmploymentDate().getDate());
    }

    @Test
    void changeSalaryTest() {
        this.programmer1.setSallary(new BigDecimal(1234));

        Assertions.assertTrue(this.programmer1.getSallary().compareTo(new BigDecimal(1234)) == 0);
        Assertions.assertFalse(this.programmer1.getSallary().compareTo(new BigDecimal(60000)) == 0);
    }
}