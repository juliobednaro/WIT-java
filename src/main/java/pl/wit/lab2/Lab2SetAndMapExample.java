package pl.wit.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Klasa z przykładami metod operującymi na HashMapie i
 * HashSet
 *
 * @author Julian Bednarz
 */
public class Lab2SetAndMapExample {
    // Zbiór aut
    private Set<String> setCars = null;
    // Mapa Auto => Moc
    private Map<String,Integer> mapCarPower=null;
    // Logger
    protected static final Logger log = LogManager.getLogger(Lab2SetAndMapExample.class.getName());

    public Lab2SetAndMapExample() {
        this.setCars = new HashSet<String>();
        this.mapCarPower = new HashMap<String, Integer>();
    }

    public void printSetToLog() {
        if(this.setCars != null) {
            for(String el : this.setCars)
                this.log.info("" + el + ", ");
        }
    }

    public void printMapToLog() {
        if(this.mapCarPower != null) {
            for(String el : this.mapCarPower.keySet())
                log.info("" + el + "=" + this.mapCarPower .get(el) + ",");
        }
    }

    public void addElement(String element) {
        if(this.setCars != null)
            this.setCars.add(element);
    }

    public void addElement(String key, Integer value) {
        if(this.mapCarPower != null)
            this.mapCarPower.put(key, value);
    }

    public Integer getMapValue(String key) {
        return this.mapCarPower.get(key) != null ? this.mapCarPower.get(key) : -1;
    }

    public boolean isSetContains(String element){
        return this.setCars.contains(element);
    }


    //
    // GETTERY I SETTERY
    //
    public Set<String> getSetCars() {
        return setCars;
    }

    public void setSetCars(Set<String> setCars) {
        this.setCars = setCars;
    }

    public Map<String, Integer> getMapCarPower() {
        return mapCarPower;
    }

    public void setMapCarPower(Map<String, Integer> mapCarPower) {
        this.mapCarPower = mapCarPower;
    }
}
