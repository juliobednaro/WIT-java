package pl.wit.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab2SetAndMapExampleTest {

    @Test
    void addElementToSet() {
        Lab2SetAndMapExample lab = new Lab2SetAndMapExample();

        lab.addElement("AUDI");
        lab.addElement("MERCEDES");

        Assertions.assertEquals(2, lab.getSetCars().size());
        Assertions.assertTrue(lab.isSetContains("AUDI"));
        Assertions.assertTrue(lab.isSetContains("MERCEDES"));
    }

    @Test
    void addElementToMap() {
        Lab2SetAndMapExample lab = new Lab2SetAndMapExample();

        lab.addElement("AUDI", 500);
        lab.addElement("MERCEDES", 860);

        Assertions.assertEquals(2, lab.getMapCarPower().keySet().size());
        Assertions.assertEquals(500, lab.getMapValue("AUDI"));
        Assertions.assertEquals(860, lab.getMapValue("MERCEDES"));
    }

    @Test
    void getMapValue() {
        Lab2SetAndMapExample lab = new Lab2SetAndMapExample();

        lab.addElement("BMW", 600);

        Assertions.assertEquals(-1, lab.getMapValue(""));
        Assertions.assertEquals(600, lab.getMapValue("BMW"));
    }

    @Test
    void isSetContains() {
        Lab2SetAndMapExample lab = new Lab2SetAndMapExample();

        lab.addElement("AUDI");
        lab.addElement("BMW");

        Assertions.assertFalse(lab.isSetContains(""));
        Assertions.assertTrue(lab.isSetContains("AUDI"));
        Assertions.assertTrue(lab.isSetContains("BMW"));
    }
}