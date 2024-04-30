package pl.wit.lab3;

public enum EnWeekdays2 {
    MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7), SUNDAY(1);

    private int id;

    private EnWeekdays2(int id) {
        this.id = id;
    }

    public int getId(int id) {
        return this.id;
    }

    public static EnWeekdays2 getById(int id) {
        for (EnWeekdays2 en : values()) {
            if (en.getId(id) == id)
                return en;
        }
        return null;
    }

}
