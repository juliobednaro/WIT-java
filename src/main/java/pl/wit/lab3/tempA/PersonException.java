package pl.wit.lab3.tempA;

public class PersonException extends Exception {
    public PersonException(String message) {
        super(message);
    }

    public PersonException(String message, Throwable cause) {
        super(message, cause);
    }
}
