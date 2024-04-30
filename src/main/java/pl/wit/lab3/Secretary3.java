package pl.wit.lab3;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Klasa pochodna przetwarzające dane Pracownika na stanowisku sekretarka
 * @author Łukasz
 *
 */
public class Secretary3 extends Employee3 {
	//Zbiór znanych języków obcych
	private Set<String> setLanguages = null;
	
	public Secretary3(String firstName, String lastName, Date dateOfBirth, Date employmentDate, BigDecimal sallary) {
		super(firstName, lastName, dateOfBirth, employmentDate,sallary);
		this.setLanguages = new HashSet<String>();
	}

	public boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, Set<String> languages) {
		boolean isL = true;

		if (firstName == null && lastName == null && birthFrom == null && birthTo == null && languages == null) {
			return true;
		}

		if (languages != null) {
			for (String lang : languages) {
				if (!this.setLanguages.contains(lang)) {
					isL = false;
					break;
				}
			}
		}

		return super.matches(firstName, lastName, birthFrom, birthTo) && isL;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("setLanguages=").append(setLanguages.stream().collect(Collectors.joining(",","{","}")));
		return sb.toString();
	}
	/**
	 * Metoda dodająca kolejny język
	 * @param language
	 */
	public void addLanguage(String language) {
		setLanguages.add(language);
	}
	/**
	 * Metoda zwracająca posortowaną tablice języków obcych
	 * @return
	 */
	public Set<String> getLanguages() {
		return setLanguages;
	}
}
