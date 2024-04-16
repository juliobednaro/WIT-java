package pl.wit.lab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab2ArraysExampleTest {
    private Lab2ArraysExample lab;


    @Test
    void addIntElement() {
        int[] tab = {1, 5, 3};
        this.lab = new Lab2ArraysExample(1);

        this.lab.addElement(5);
        this.lab.addElement(3);

        for (int i=0; i<this.lab.getIntArraySize(); i++) {
            Assertions.assertEquals(tab[i], this.lab.getIntArrayElement(i));
        }
    }

    @Test
    void addStringElement() {
        String[] tab = {"Hi", "Hello", "World"};
        this.lab = new Lab2ArraysExample("Hi");

        this.lab.addElement("Hello");
        this.lab.addElement("World");

        for (int i=0; i<this.lab.getStringArraySize(); i++) {
            Assertions.assertEquals(tab[i], this.lab.getStringArrayElement(i));
        }
    }

    @Test
    void addBooleanElement() {
        boolean[] tab = {true, false, true};
        this.lab = new Lab2ArraysExample(true);

        this.lab.addElement(false);
        this.lab.addElement(true);

        for (int i=0; i<this.lab.getBooleanArraySize(); i++) {
            Assertions.assertEquals(tab[i], this.lab.getBooleanArrayElement(i));
        }
    }


    @Test
    void getIntArraySize() {
        this.lab = new Lab2ArraysExample(10);

        this.lab.addElement(55);
        this.lab.addElement(130);

        Assertions.assertEquals(3, this.lab.getIntArraySize());
    }

    @Test
    void getStringArraySize() {
        this.lab = new Lab2ArraysExample("A");

        this.lab.addElement("Hi");
        this.lab.addElement("Nope");

        Assertions.assertEquals(3, this.lab.getStringArraySize());
    }

    @Test
    void getBooleanArraySize() {
        this.lab = new Lab2ArraysExample(false);

        this.lab.addElement(false);
        this.lab.addElement(true);

        Assertions.assertEquals(3, this.lab.getBooleanArraySize());
    }

    @Test
    void getIntArrayElement() {
        int el;
        this.lab = new Lab2ArraysExample(1);

        el = this.lab.getIntArrayElement(0);

        Assertions.assertNotEquals(-1, el);
    }

    @Test
    void getStringArrayElement() {
        String el;
        this.lab = new Lab2ArraysExample("HI");

        el = this.lab.getStringArrayElement(0);

        Assertions.assertNotEquals("", el);
    }

    @Test
    void getBooleanArrayElement() {
        boolean el;
        this.lab = new Lab2ArraysExample(true);

        el = this.lab.getBooleanArrayElement(0);

        Assertions.assertNotEquals(false, el);
    }
}