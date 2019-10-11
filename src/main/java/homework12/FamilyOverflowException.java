package homework12;

public class FamilyOverflowException extends RuntimeException {
    Family family;
    static final int MEMBERS = 4;

    public FamilyOverflowException(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Максимальное количество членов семьи - " + MEMBERS + " - достигнуто";
    }
}
