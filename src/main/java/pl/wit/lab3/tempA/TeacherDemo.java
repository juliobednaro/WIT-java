package pl.wit.lab3.tempA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Klasa pochodna - nauczyciel
 * @author Łukasz
 *
 */
public class TeacherDemo extends AbstractDemo {
	protected static final Logger log = LogManager.getLogger(TeacherDemo.class.getName());


	public TeacherDemo(String firstName, String lastName) {
		super(firstName, lastName);
	}
	@Override
	protected String getPersonType() {
		return EnPersonType.teacher.getPolish();
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
