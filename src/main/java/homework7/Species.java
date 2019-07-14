package homework7;

import org.omg.CORBA.UNKNOWN;

public enum Species {
    CAT(false, 4, true),
    DOG(false, 4, true),
    FISH(false, 0, false),
    FROG(false, 4, false),
    PERROT(true, 2, true),
    DOMESTIC_CAT(false, 4, true),
    ROBO_CAT(true, 2, false),
    UNKNOWN(false, 0, false);

    private final boolean canFly;
    private final int numberOfLegs;
    private final boolean hasFur;

    private Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }
}
