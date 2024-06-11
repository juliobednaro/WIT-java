package pl.wit.lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectionsTutorialTest {
    CollectionsTutorial collectionsTutorial = null;
    @BeforeEach
    void setUp() {
        collectionsTutorial = new CollectionsTutorial();
    }

    @Test
    void getSet() {
        Set<String> collection = collectionsTutorial.getSet();

        Assertions.assertFalse(collection.isEmpty());
        Assertions.assertEquals(10000, collection.size());
    }

    @Test
    void getOnlyEvenItems() {
        List<String> collection = collectionsTutorial.getOnlyEvenItems();

        Assertions.assertEquals(50000, collection.size());
        Assertions.assertFalse(collection.isEmpty());

        for (String item : collection) {
            String[] parts = item.split("_");
            int number = Integer.parseInt(parts[1]);
            Assertions.assertTrue(number % 2 == 0);
        }
    }

    @Test
    void getSetWithOrder() {
        Set<String> collection = collectionsTutorial.getSetWithOrderWithNoLessThan100();

        Assertions.assertFalse(collection.isEmpty());

        int previousNumber = -1;
        for (String item : collection) {
            String[] parts = item.split("_");
            int number = Integer.parseInt(parts[1]);
            Assertions.assertTrue(number <= 100);
        }

        Assertions.assertEquals(101, collection.size());
    }

    @Test
    void getEvery3ElementAsSortedSet() {
        TreeSet<String> collection = collectionsTutorial.getEvery3ElementAsSortedSet();

        Assertions.assertFalse(collection.isEmpty());

//        for (String c : collection) {
//            System.out.println(c);
//        }

//        String[] array = collection.toArray(new String[0]);
//        for (int i = 0; i < array.length; i++) {
//            String item = array[i];
//            String[] parts = item.split("_");
//            int number = Integer.parseInt(parts[1]);
//        }
    }
}
