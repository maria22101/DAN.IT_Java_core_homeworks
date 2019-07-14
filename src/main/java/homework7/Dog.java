package homework7;

public class Dog extends Pet implements Foulable{

    public Dog(String nickName, int age, int trickLevel, String[] habits){
        super(nickName, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }

    @Override
    void respond() {
        System.out.println("Woof!");
    }

    @Override
    public void foul() {
        System.out.println("Oops, I have bitten the slippers. I need to hide this mess...");
    }
}
