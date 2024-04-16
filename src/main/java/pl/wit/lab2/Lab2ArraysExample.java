package pl.wit.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * @author Julian Bednarz
 *
 * Klasa z przykładami metod operującymi na tablicach
 */
public class Lab2ArraysExample {
    private int intNumbers[] = null;
    private String stringElements[] = null;
    private boolean boolElements[] = null;

    protected static final Logger log = LogManager.getLogger(Lab2ArraysExample.class.getName());


    private Lab2ArraysExample() {
        this.intNumbers = new int[0];
        this.stringElements = new String[0];
        this.boolElements = new boolean[0];
    }

    public Lab2ArraysExample(int intValue) {
        this();
        this.intNumbers = Arrays.copyOf(this.intNumbers, 1);
        this.intNumbers[0] = intValue;
    }

    public Lab2ArraysExample(String stringValue) {
        this();
        this.stringElements = Arrays.copyOf(this.stringElements, 1);
        this.stringElements[0] = stringValue;
    }

    public Lab2ArraysExample(boolean boolValue) {
        this();
        this.boolElements = Arrays.copyOf(this.boolElements, 1);
        this.boolElements[0] = boolValue;
    }

    public void printArraysToLog() {
        if (this.intNumbers != null) {
            for (int el : this.intNumbers) {
                log.info("" + el + ", ");
            }
        }
        if (this.stringElements != null) {
            for (String el : this.stringElements) {
                log.info("" + el + ", ");
            }
        }
        if (this.boolElements != null) {
            for (boolean el : this.boolElements) {
                log.info("" + el + ", ");
            }
        }
    }

    public void addElement(int element) {
        this.intNumbers = Arrays.copyOf(this.intNumbers, this.intNumbers.length+1);
        this.intNumbers[this.intNumbers.length-1] = element;
    }

    public void addElement(String element) {
        this.stringElements = Arrays.copyOf(this.stringElements, this.stringElements.length+1);
        this.stringElements[this.stringElements.length-1] = element;
    }

    public void addElement(boolean element) {
        this.boolElements = Arrays.copyOf(this.boolElements, this.boolElements.length+1);
        this.boolElements[this.boolElements.length-1] = element;
    }

    public int getIntArraySize() {
        if (this.intNumbers != null)
            return this.intNumbers.length;
        else
            return -1;
    }

    public int getStringArraySize() {
        if (this.stringElements != null)
            return this.stringElements.length;
        else
            return -1;
    }

    public int getBooleanArraySize() {
        if (this.boolElements != null)
            return this.boolElements.length;
        else
            return -1;
    }

    public int getIntArrayElement(int index) {
        if (this.intNumbers != null && index < this.intNumbers.length && index >= 0)
            return this.intNumbers[index];
        return -1;
    }

    public String getStringArrayElement(int index) {
        if (this.stringElements != null && index < this.stringElements.length && index >= 0)
            return this.stringElements[index];
        return "";
    }

    public boolean getBooleanArrayElement(int index) {
        if (this.boolElements != null && index < this.boolElements.length && index >= 0)
            return this.boolElements[index];
        return false;
    }

    ////////////////////////////////////////////
    // gettery i settery
    ////////////////////////////////////////////

    public int[] getIntNumbers() {
        return intNumbers;
    }

    public void setIntNumbers(int[] intNumbers) {
        this.intNumbers = intNumbers;
    }

    public String[] getStringElements() {
        return stringElements;
    }

    public void setStringElements(String[] stringElements) {
        this.stringElements = stringElements;
    }

    public boolean[] getBoolElements() {
        return boolElements;
    }

    public void setBoolElements(boolean[] boolElements) {
        this.boolElements = boolElements;
    }
}
