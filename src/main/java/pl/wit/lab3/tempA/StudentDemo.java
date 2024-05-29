package pl.wit.lab3.tempA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Klasa pochodna - Student
 * @author Łukasz
 *
 */
public class StudentDemo extends AbstractDemo {
	private Map<String, Byte> mapPoints = null;
	protected static final Logger log = LogManager.getLogger(StudentDemo.class.getName());

	public StudentDemo(String firstName, String lastName) {
		super(firstName, lastName);
		this.mapPoints = new LinkedHashMap<>();
	}

	void addPoints(String name, byte points) throws PersonException {
		if (name == null || name.isEmpty()) throw new PersonException("Name cannot be null nor empty");
		if (points < 0) throw new PersonException("Points cannot be negative");
		mapPoints.put(name, points);
		logDebug("Added some more points!");
		logTrace("Key: " + name + " Val: " + points);
	}

	public Map<String, Byte> getMapPoints() {
		return mapPoints;
	}

	@Override
	protected String getPersonType() {
		return EnPersonType.student.getPolish();
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
