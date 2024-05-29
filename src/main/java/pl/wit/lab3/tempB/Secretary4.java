package pl.wit.lab3.tempB;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Secretary4 extends Employee4 {
	//Zbiór znanych języków obcych
	private Set<String> setLanguages = null;
	
	public Secretary4(String firstName, String lastName, Date dateOfBirth, Date employmentDate, BigDecimal sallary) {
		super(firstName, lastName, dateOfBirth, employmentDate,sallary);
		this.setLanguages = new HashSet<String>();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("setLanguages=").append(setLanguages.stream().collect(Collectors.joining(",","{","}")));
		return sb.toString();
	}
	
	protected boolean matches(String firstName,String lastName,Date birthFrom,Date birthTo,Date employmentFrom, Date employmentTo,BigDecimal sallaryFrom, BigDecimal sallaryTo,Set<String> setLanguages,boolean strict) {
		return super.matches(firstName,lastName,birthFrom,birthTo,employmentFrom,employmentTo,sallaryFrom,sallaryTo,strict) 
				&& matchesLanguages(setLanguages);
		
	}
	
	protected boolean matches(String firstName,String lastName,Date birthFrom,Date birthTo,Date employmentFrom, Date employmentTo,BigDecimal sallaryFrom, BigDecimal sallaryTo,Set<String> setLanguages) {
		return matches(firstName,lastName,birthFrom,birthTo,employmentFrom,employmentTo,sallaryFrom,sallaryTo,setLanguages,false);
		
	}
	
	private boolean matchesLanguages(Set<String> setLanguages) {
		if(setLanguages!=null) {
			if(this.setLanguages!=null) {
				return this.setLanguages.containsAll(setLanguages);
			}else {
				return false;
			}
		}
		return true;
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
