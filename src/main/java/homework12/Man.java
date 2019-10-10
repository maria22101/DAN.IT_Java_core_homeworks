package homework12;

public class Man extends Human{

    public Man() {
    }

    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    void greetPet() {
        System.out.println("Hello, my friend!");
    }

    void repairCar() {
        System.out.println("I am busy, I am reparing a car...");
    }
}
