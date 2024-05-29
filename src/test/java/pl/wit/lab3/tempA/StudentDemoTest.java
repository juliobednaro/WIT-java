package pl.wit.lab3.tempA;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentDemoTest {
    StudentDemo studentDemo = null;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        LoggerConfig loggerConfig =
                config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        loggerConfig.setLevel(Level.TRACE);
        ctx.updateLoggers();
    }

    @BeforeEach
    void setUp() {
        this.studentDemo = new StudentDemo("Jan", "Pawel");
    }

    @Test
    void addPoints() throws PersonException {
        this.studentDemo.addPoints("A", (byte) 1);

        Assertions.assertEquals((byte) 1, this.studentDemo.getMapPoints().get("A"));
    }

    @Test
    void addPointsNullString() throws PersonException {
        try{
            this.studentDemo.addPoints(null, (byte) 1);
            Assertions.assertTrue(false);
        } catch (PersonException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void addPointsEmptyString() {
        try{
            this.studentDemo.addPoints("", (byte) 1);
            Assertions.assertTrue(false);
        } catch (PersonException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void addPointsNegativeBytes() {
        try{
            this.studentDemo.addPoints("A", (byte) -1);
            Assertions.assertTrue(false);
        } catch (PersonException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void getMapPoints() throws PersonException {
        this.studentDemo.addPoints("A", (byte) 1);
        this.studentDemo.addPoints("B", (byte) 2);
        this.studentDemo.addPoints("C", (byte) 3);

        Assertions.assertEquals((byte) 1, this.studentDemo.getMapPoints().get("A"));
        Assertions.assertEquals((byte) 2, this.studentDemo.getMapPoints().get("B"));
        Assertions.assertEquals((byte) 3, this.studentDemo.getMapPoints().get("C"));
    }

    @Test
    void getPersonType() {
        Assertions.assertEquals("student", this.studentDemo.getPersonType());
    }
}