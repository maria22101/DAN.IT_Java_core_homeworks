package homework7;

public class Fish extends Pet {

    public Fish(String nickName, int age, int trickLevel, String[] habits){
        super(nickName, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    void respond() {
        System.out.println("Bul-bul");
    }
}
