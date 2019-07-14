package homework7;

import java.sql.SQLOutput;

public final class Man extends Human {
    @Override
    void greetPet() {
        System.out.println("Hello, my friend!");
    }

    void repairCar() {
        System.out.println("I am busy, I am reparing a car...");
    }

}
