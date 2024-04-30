package pl.wit.lab3;

import java.math.BigDecimal;
import java.util.Date;
/**
 * Klasa pracownika
 * wykonana z użyciem wywołania konstruktora
 * klasy bazowej
 * @author Łukasz
 *
 */
public class Employee3 extends Person3{
	//Data zatrudnienia
	private Date employmentDate = null;
	//Wyngrodzenie
	private BigDecimal sallary = null;
	
	public Employee3(String firstName, String lastName, Date dateOfBirth,Date employmentDate, BigDecimal sallary ) {
		super(firstName, lastName, dateOfBirth);
		this.employmentDate = employmentDate;
		this.sallary = sallary;
	}

	public boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, Date employmentFrom, Date employmentTo, BigDecimal sallaryFrom, BigDecimal sallaryTo) {
		boolean isEF = true, isET = true, isSF = true, isST = true;

		if (firstName == null && lastName == null && birthFrom == null && birthTo == null && employmentFrom == null && employmentTo == null && sallaryFrom == null && sallaryTo == null) {
			return true;
		}

		if (employmentFrom != null) {
			// employmentDate >= employmentFrom
			isEF = this.employmentDate.equals(employmentFrom) || this.employmentDate.after(employmentFrom);
		}

		if (employmentTo != null) {
			// employmentDate <= employmentTo
			isET = this.employmentDate.equals(employmentTo) || this.employmentDate.before(employmentTo);
		}

		if (sallaryFrom != null) {
			// sallary >= sallaryFrom
			isSF = this.sallary.compareTo(sallaryFrom) >= 0;
		}

		if (sallaryTo != null) {
			// sallary <= sallaryTo
			isST = this.sallary.compareTo(sallaryTo) <= 0;
		}

		return super.matches(firstName, lastName, birthFrom, birthTo) && isEF && isET && isSF && isST;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("employmentDate=").append(employmentDate.toString()).append("\n");
		sb.append("sallary=").append(sallary.toString()).append("\n");
		return sb.toString();
	}
	////////////////////////////////////////
	//	getters and setters
	////////////////////////////////////////
	
	public Date getEmploymentDate() {
		return employmentDate;
	}

	public BigDecimal getSallary() {
		return sallary;
	}
}