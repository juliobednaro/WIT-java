package pl.wit.lab3;

import java.util.Date;
/**
 * Klasa przechowująca podstawowe dane osobowe
 * używająca konstruktorów przeciążonych
 * @author Łukasz
 *
 */
public class Person3 {
	// Imię
	private String firstName = null;
	// Nazwisko
	private String lastName = null;
	// Data urodzenia
	private Date dateOfBirth = null;

	public Person3(String firstName,String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

	public Person3(String firstName,String lastName,Date dateOfBirth) {
			this(firstName,lastName);
			this.dateOfBirth = dateOfBirth;
		}

	public boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo) {
		boolean isFN = true, isLN = true, isBF = true, isBT = true;

		if (firstName == null && lastName == null && birthFrom == null && birthTo == null) {
			return true;
		}

		if (firstName != null && firstName.strip() != "") {
			isFN = this.firstName.startsWith(firstName);
		}

		if (lastName != null && lastName.strip() != "") {
			isLN = this.lastName.startsWith(lastName);
		}

		if (birthFrom != null) {
			// dateOfBirth >= birthFrom
			isBF = this.dateOfBirth.equals(birthFrom) || this.dateOfBirth.after(birthFrom);
		}

		if (birthTo != null) {
			// dateOfBirth <= birthFrom
			isBT = this.dateOfBirth.equals(birthTo) || this.dateOfBirth.before(birthTo);
		}

		return isFN && isLN && isBF && isBT;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("firstName=").append(firstName).append("\n");
		sb.append("lastName=").append(lastName).append("\n");
		sb.append("dateOfBirth=").append(dateOfBirth.toString()).append("\n");
		return sb.toString();
	}
	///////////////////////////////////////////
	// getters and setters
	///////////////////////////////////////////
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
