package pl.wit.lab3.p1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

class Secretary1Test {
    Secretary1 secretary1 = null;

    @BeforeEach
    void setUp() {
        this.secretary1 = new Secretary1("Ania", "Radna", new Date(2001-1900, 10, 1), new Date(2022-1900, 4, 21), new BigDecimal(11000));
    }

    @Test
    void addLanguage() {
        secretary1.addLanguage("English");
        secretary1.addLanguage("Polish");

        Assertions.assertTrue(secretary1.getLanguages().contains("English"));
        Assertions.assertTrue(secretary1.getLanguages().contains("Polish"));
    }

    @Test
    void firstNameTest() {
        this.secretary1.setFirstName("Kristen");

        Assertions.assertEquals("Kristen", this.secretary1.getFirstName());
        Assertions.assertNotEquals("Ania", this.secretary1.getFirstName());
        Assertions.assertEquals("Radna", this.secretary1.getLastName());
    }

    @Test
    void lastNameTest() {
        this.secretary1.setLastName("Stewart");

        Assertions.assertEquals("Ania", this.secretary1.getFirstName());
        Assertions.assertEquals("Stewart", this.secretary1.getLastName());
        Assertions.assertNotEquals("Radna", this.secretary1.getLastName());
    }

    @Test
    void changeEmploymentTest() {
        this.secretary1.setEmploymentDate(new Date(2023-1900, 8, 3));
        this.secretary1.setSallary(new BigDecimal(1234));

        Assertions.assertEquals(2023, this.secretary1.getEmploymentDate().getYear()+1900);
        Assertions.assertEquals(8, this.secretary1.getEmploymentDate().getMonth());
        Assertions.assertEquals(3, this.secretary1.getEmploymentDate().getDate());

        Assertions.assertNotEquals(2022, this.secretary1.getEmploymentDate().getYear()+1900);
        Assertions.assertNotEquals(4, this.secretary1.getEmploymentDate().getMonth());
        Assertions.assertNotEquals(21, this.secretary1.getEmploymentDate().getDate());
    }

    @Test
    void changeSalaryTest() {
        this.secretary1.setSallary(new BigDecimal(1234));

        Assertions.assertTrue(this.secretary1.getSallary().compareTo(new BigDecimal(1234)) == 0);
        Assertions.assertFalse(this.secretary1.getSallary().compareTo(new BigDecimal(11000)) == 0);
    }
}