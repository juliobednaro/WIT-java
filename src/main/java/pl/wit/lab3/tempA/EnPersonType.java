package pl.wit.lab3.tempA;

public enum EnPersonType {
    student("student"), teacher("nauczyciel");

    private String polish;
    EnPersonType(String polish) {
        this.polish = polish;
    }

    public String getPolish() {
        return polish;
    }
}
