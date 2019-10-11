package homework12;

public class MaximumFamilySize extends RuntimeException {
    Family family;
    private final int MEMBERS = 4;

    public MaximumFamilySize(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Максимальное количество членов семьи - " + MEMBERS + " - достигнуто";
    }
}
