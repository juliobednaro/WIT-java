package pl.wit.lab3.tempB;

import java.util.Arrays;

/**
 * Klasa bazy danych osób
 * @author Łukasz
 *
 */
public class DbPersons {
	private Person4 persons[] = null;
	
	public DbPersons() {
		this.persons = new Person4[0];
	}
	
	public void addPerson(Person4 person) {
		persons =  Arrays.copyOf(persons, persons.length+1);
		persons[persons.length-1]=person;
	}
	
	
}
