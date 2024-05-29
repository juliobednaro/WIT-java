package pl.wit.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DocHistogramTest {
    DocHistogram docHistogram = null;

    @BeforeEach
    public void setup() {
        this.docHistogram = new DocHistogram("./src/test/resources/tutorial9.txt");
    }

    @Test
    public void printHistogramTest( ) {
        String s = this.docHistogram.printHistogram();
        Map<String, Integer> histogram = this.docHistogram.getMapHistogram();

        for (String line : s.split("\n")) {
            String key = line.split(",")[0];
            String val = line.split(",")[1];

            Assertions.assertTrue(histogram.containsKey(key));
            Assertions.assertEquals(histogram.get(key), Integer.parseInt(val));
        }
    }

    @Test
    public void saveHistogramToFileTest() {
        String output = "./src/test/resources/histogram.txt";
        File f  = new File(output);

        this.docHistogram.saveHistogramToFile(output);

        Assertions.assertTrue(f.exists());
    }

    /*
    Zawartość pliku small.txt:
    Ala ma kota
    ale Ala nie ma psa
    za to psa ma Ela
     */
    @Test
    public void getMapHistogramTest() {
        String input = "./src/test/resources/small.txt";
        docHistogram = new DocHistogram(input);
        Map<String, Integer> histogramMap = new HashMap<>();

        histogramMap.put("ala", 2);
        histogramMap.put("ma", 3);
        histogramMap.put("kota", 1);
        histogramMap.put("ale", 1);
        histogramMap.put("nie", 1);
        histogramMap.put("psa", 2);
        histogramMap.put("za", 1);
        histogramMap.put("to", 1);
        histogramMap.put("ela", 1);

        Assertions.assertEquals(this.docHistogram.getMapHistogram(), histogramMap);
    }
}
