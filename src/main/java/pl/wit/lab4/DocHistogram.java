package pl.wit.lab4;

import java.io.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DocHistogram {
    private String filePathString = null;
    private Map<String,Integer> mapHistogram = null;
    protected static final Logger log =
            LogManager.getLogger(DocHistogram.class.getName());

    public DocHistogram(String filePathString) {
        this.filePathString = filePathString;
        this.mapHistogram =  new HashMap<>();
        parseFile();
    }

    private void parseFile() {
        String line;
        try (BufferedReader br=
                     new BufferedReader(new FileReader(filePathString))){
            while((line=br.readLine())!=null) {
                countWords(line.split("[ ,.\\r\\n]+"));

            }
        }catch(IOException e) {
            log.error(e,e);
        }
    }

    private void countWords(String[] arrText) {
        for(String word: arrText) {
            word=word.toLowerCase();
            if(this.mapHistogram.containsKey(word)) {
                this.mapHistogram.put(word, this.mapHistogram.get(word)+1);
            }
            else
                this.mapHistogram.put(word, 1);
        }
    }

    public String printHistogram() {
        StringBuilder sb = new StringBuilder();;
        ArrayList<String> sortedKeys = new ArrayList<>(this.getMapHistogram().keySet());
        Collections.sort(sortedKeys);
        for (String key : sortedKeys) {
            sb.append(key).append(",").append(this.mapHistogram.get(key)).append("\n");
        }
        return sb.toString();
    }

    public void saveHistogramToFile(String filepath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))) {
            bufferedWriter.write(this.printHistogram());
        } catch (IOException e) {
            log.error(e, e);
        }
    }

    public Map<String, Integer> getMapHistogram() {
        return mapHistogram;
    }
}