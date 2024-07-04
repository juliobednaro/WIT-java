import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main {
    public static void main(String[] args) {
        Locale locale = new Locale("PL");
        ResourceBundle rb = ResourceBundle.getBundle("Message", locale);

        Object[] messageArguments = {
                rb.getString("planet"),
                new Integer(7),
                new Date()
        };

        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(locale);
        formatter.applyPattern(rb.getString("template"));

        String output = formatter.format(messageArguments);
        System.out.println(output);
    }
}
