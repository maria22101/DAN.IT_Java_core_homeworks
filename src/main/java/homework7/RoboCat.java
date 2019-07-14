package homework7;

public class RoboCat extends Pet implements Foulable{

    public RoboCat(String nickName, int age, int trickLevel, String[] habits){
        super(nickName, age, trickLevel, habits);
        this.setSpecies(Species.ROBO_CAT);
    }

    @Override
    void respond() {
        System.out.println("H-E-L-L-O");
    }

    @Override
    public void foul() {
        System.out.println("I have destroyed the kitchen. I am a RoboCat!");
    }
}
