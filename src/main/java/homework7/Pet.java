package homework7;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private Species species = Species.UNKNOWN;
    private String nickName;
    private int age;
    private int trickLevel;
    private String[] habits;

    static {
        System.out.println("New class Pet being loaded...");
    }

    {
        System.out.println("New object of Pet type being created");
    }

    public Pet(String nickName) {
        this.nickName = nickName;
    }

    public Pet(String nickName, int age, int trickLevel, String[] habits) {
        this.nickName = nickName;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return species + "{" +
                "nickName='" + nickName +
                "', age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                ", canFly: " + species.isCanFly() +
                ", hasFur:" + species.isHasFur() +
                ", legsNumber:" + species.getNumberOfLegs() +
                '}';
    }

    void eat(){
        System.out.println("I'm eating");
    }

    abstract void respond();

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString() + "is being deleted...");;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                species == pet.species &&
                Objects.equals(nickName, pet.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickName, age);
    }
}
