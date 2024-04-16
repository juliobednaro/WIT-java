package pl.wit.lab2;

import java.time.LocalDate;
import java.time.Period;

/**
 * 
 * @author Julian Bednarz
 *
 * Klasa do prezentacji informacji o osobie w formie raportu. ???
 */
public class Presentation {
	
	// Imie
	private String firstName;
	// Nazwisko
	private String lastName;
	// Dzien i miesiac urodzenia
	private byte birthdayDay, birthdayMonth;
	// Rok urodzenia
	private short birthdayYear;
	// Miejsce urodzenia
	private String placeOfBirth;
	// Ilosc znajomych na Facebooku
	private short facebookFriendsQuantity;
	// Odwiedzone miejsca
	private String[] visitedPlaces = new String[0];
	
	public Presentation(String firstName,String lastName) {
		//inicjalizacja imienia i nazwiska
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Presentation(String firstName, String lastName, byte birthdayDay, byte birthdayMonth, short birthdayYear) {
		//wywołanie konstruktora 2-argumentowego
		this(firstName, lastName);

		//dalsza inicjalizacja
		if (birthdayYear >= 1900 && birthdayMonth > 0 && birthdayMonth <= 12 && birthdayDay > 0 && birthdayDay <= 31) {
			this.birthdayDay = birthdayDay;
			this.birthdayMonth = birthdayMonth;
			this.birthdayYear = birthdayYear;
		}
		// FB friends dostaje wartosc domyslna 0
	}
	
	public String getFullName() {
		//Zwrócenie połączonej wartości imienia i nazwiska ze spacją pomiędzy
		return new StringBuilder().append(this.firstName).append(" ").append(this.lastName).toString();
	}
	
	public String getBirthdayDateAsString() {
		//Ręczne zbudowanie Daty w formacie dd.MM.yyyy
		StringBuilder sb = new StringBuilder();

		if (this.birthdayDay < 10) sb.append(0);
		sb.append(this.birthdayDay).append(".");

		if (this.birthdayMonth < 10) sb.append(0);
		sb.append(birthdayMonth).append(".");

		sb.append(this.birthdayYear);

		return sb.toString();
	}
	
	public byte getAge() {
		LocalDate now = LocalDate.now();
		LocalDate bday = LocalDate.of(this.birthdayYear, this.birthdayMonth, this.birthdayDay);

		//Obliczenie aktualnego wieku
		return (byte) Period.between(bday, now).getYears();
	}
	
	public String getPresentationStory() {
		int friends = this.getFacebookFriendsQuantity();
		int visitedPlaces = this.visitedPlaces.length;
		String s1 = String.format("Nazywam się %s, mam %d lata a moim miejscem urodzenia jest %s. ",
				this.getFullName(), this.getAge(), this.getPlaceOfBirth());
		StringBuilder sb = new StringBuilder();

		sb.append(s1);
		sb.append("Mam ");

		if (friends < 50) {
			sb.append("niewielką");
		}
		else if (friends >= 50 && friends < 300) {
			sb.append("dosyć sporą");
		}
		else {
			sb.append("bardzo dużą");
		}
		sb.append(" liczbę znajomych na FB. ");

		switch (visitedPlaces) {
			case 0:
				sb.append("Nie odwiedziłem wiele miejsc w swoim życiu. ");
				break;
			default:
				sb.append("W życiu odwiedziłem takie miejsca jak: ");
				for (String place : this.getVisitedPlaces()) {
					sb.append(place).append(", ");
				}
				// Usuń przecinek i spacje
				sb.delete(sb.length()-2, sb.length());
				sb.append(".");
				break;
		}

		return sb.toString();
	}

	
	
	////////////////////////////////////////////
	// gettery i settery
	////////////////////////////////////////////

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte getBirthdayDay() {
		return birthdayDay;
	}

	public void setBirthdayDay(byte birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public byte getBirthdayMonth() {
		return birthdayMonth;
	}

	public void setBirthdayMonth(byte birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

	public short getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(short birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public short getFacebookFriendsQuantity() {
		return facebookFriendsQuantity;
	}

	public void setFacebookFriendsQuantity(short facebookFriendsQuantity) {
		this.facebookFriendsQuantity = facebookFriendsQuantity;
	}

	public String[] getVisitedPlaces() {
		return visitedPlaces;
	}

	public void setVisitedPlaces(String[] visitedPlaces) {
		this.visitedPlaces = visitedPlaces;
	}
}
