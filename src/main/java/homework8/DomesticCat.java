package homework8;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable{

    public DomesticCat(String nickName, int age, int trickLevel, Set<String> habits){
        super(nickName, age, trickLevel, habits);
        this.setSpecies(Species.CAT);
    }

    @Override
    void respond() {
        System.out.println("Meow");
    }

    @Override
    public void foul() {
        System.out.println("Oops, I have scratched the sofa. I need to hide this mess...");
    }
}
