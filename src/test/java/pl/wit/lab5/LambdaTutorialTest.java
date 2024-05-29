package pl.wit.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;


public class LambdaTutorialTest {
    LambdaTutorial l = null;

    @BeforeEach
    void setUp() {
        l = new LambdaTutorial();
    }

    @Test
    public void isMoreThan10Test() {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i=0; i<10; i++) l.addNumber(i);

        Assertions.assertFalse(l.isMoreThan10());
        l.addNumber(10);
        Assertions.assertTrue(l.isMoreThan10());
    }

    @Test
    public void isNotEmptyTest() {
        Assertions.assertFalse(l.isNotEmpty());
        l.addNumber(0);
        Assertions.assertTrue(l.isNotEmpty());
    }

    @Test
    public void printSetTest() {
        l.printSet();
    }

    @Test
    public void firstElementTest() {
        l.addNumber(12);
        l.addNumber(6);
        l.addNumber(24);
        Assertions.assertEquals(12, l.getFirstElement());
    }

    @Test
    public void maxElementTest() {
        Assertions.assertEquals(null, l.getMaxElement());

        l.addNumber(1);
        l.addNumber(3);
        l.addNumber(2);

        Assertions.assertEquals(3, l.getMaxElement());
    }

}
