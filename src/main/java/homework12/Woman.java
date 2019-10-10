package homework12;

public class Woman extends Human{
    public Woman() {
    }

    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    void greetPet() {
        System.out.println("Hello, my dear!");
    }

    void makeUp(){
        System.out.println("Do not disturb! I am doing my make-up..");
    }
}
