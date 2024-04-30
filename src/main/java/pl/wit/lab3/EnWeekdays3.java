package pl.wit.lab3;

import java.util.Locale;
import java.util.ResourceBundle;


public enum EnWeekdays3 {
    MONDAY(2, "key.monday"),
    TUESDAY(3, "key.tuesday"),
    WEDNESDAY(4, "key.wednesday"),
    THURSDAY(5, "key.thursday"),
    FRIDAY(6, "key.friday"),
    SATURDAY(7, "key.saturday"),
    SUNDAY(1, "key.sunday");

    private int id;
    private String key;

    private  EnWeekdays3(int id, String key) {
        this.id = id;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getWeekdayName(Locale loc) {
        ResourceBundle resBundle = ResourceBundle.getBundle("weekdays", loc);
        return resBundle.getString(getKey());
    }

}
