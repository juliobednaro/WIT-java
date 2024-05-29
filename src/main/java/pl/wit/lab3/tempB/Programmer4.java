package pl.wit.lab3.tempB;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;


public class Programmer4 extends Employee4{
	//Mapa znanych języków z oceną umiejęstności
	private Map<String,Short> mapProgrammingLanguages = null;
	
	public Programmer4(String firstName, String lastName, Date dateOfBirth, Date employmentDate, BigDecimal sallary) {
		super(firstName, lastName, dateOfBirth, employmentDate, sallary);
		this.mapProgrammingLanguages = new HashMap<String,Short>();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("mapProgrammingLanguages=").append(mapProgrammingLanguages.toString());
		
		return sb.toString();
	}
	
	protected boolean matches(String firstName,String lastName,Date birthFrom,Date birthTo,Date employmentFrom, Date employmentTo,BigDecimal sallaryFrom, BigDecimal sallaryTo,Map<String,Short> mapProgrammingLanguages ) {
		return matches(firstName,lastName,birthFrom,birthTo,employmentFrom,employmentTo,sallaryFrom,sallaryTo,mapProgrammingLanguages,false);
		
	}
	
	protected boolean matches(String firstName,String lastName,Date birthFrom,Date birthTo,Date employmentFrom, Date employmentTo,BigDecimal sallaryFrom, BigDecimal sallaryTo,Map<String,Short> mapProgrammingLanguages,boolean strict) {
		return super.matches(firstName,lastName,birthFrom,birthTo,employmentFrom,employmentTo,sallaryFrom,sallaryTo,strict) 
				&& matchesProgLanguages(mapProgrammingLanguages);
		
	}
	
	private boolean matchesProgLanguages(Map<String,Short> mapProgrammingLanguages) {
		if(mapProgrammingLanguages!=null) {
			Short markQuery=null;
			Short mark=null;
			if(this.mapProgrammingLanguages!=null) {
				for(String progLang:mapProgrammingLanguages.keySet()) {
					//Po napotkaniu pierwszego niezgodnego zwracamy false
					if(!this.mapProgrammingLanguages.containsKey(progLang))
						return false;
					else {
						markQuery = mapProgrammingLanguages.get(progLang);
						mark = this.mapProgrammingLanguages.get(progLang);
						if(markQuery!=null && mark!=null && markQuery.compareTo(mark)>0)
							return false;
					}
				}
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
	public void addProgrammingLanguage(String language,Short mark) {
		if(mark!=null && mark.compareTo((short)0)>0 && mark.compareTo((short)6)<=0)
			mapProgrammingLanguages.put(language,mark);
	}
	/**
	 * Metoda zwraqcająca posortowaną tablice języków obcych
	 * @return
	 */
	public String getProgrammingLanguageInfo(String language) {
		if(!mapProgrammingLanguages.containsKey(language)) {
			Locale locale = new Locale("pl", "PL");
			ResourceBundle exampleBundle = ResourceBundle.getBundle("resources", locale);
			String textPattern = exampleBundle.getString("no_programming.languages");
			return  MessageFormat.format(textPattern, language);
			
		}else {
			String result = language.concat(" ").concat(mapProgrammingLanguages.get(language).toString());
			return result;
		}
		
	}
}
