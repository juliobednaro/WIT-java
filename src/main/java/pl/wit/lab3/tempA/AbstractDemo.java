package pl.wit.lab3.tempA;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Klasa abstrakcyjna demonstracyjna
 * @author Łukasz
 *
 */
public abstract class AbstractDemo implements IDemoLogger {
	protected static final Logger log = LogManager.getLogger(AbstractDemo.class.getName());
	//imię
	private String firstName=null;
	//nazwisko
	private String lastName=null;
	/**
	 * Typ osoby
	 * @return
	 */
	protected abstract String getPersonType();
	
	public AbstractDemo(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void printData() {
		String personType = getPersonType();

		log.info((firstName!=null?firstName:"")
				.concat(" ")
				.concat(lastName!=null?lastName:"")
				.concat(" - ")
				.concat(personType!=null?personType:""));
	}

	public String getFullName() {
		return new StringBuilder().append(this.firstName).append(" ").append(this.lastName).toString();
	}

	@Override
	public String getAdditionalInfo() {
		return getPersonType().concat(" ").concat(getFullName());
	}
}
