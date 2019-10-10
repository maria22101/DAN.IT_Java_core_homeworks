package homework12;

import homework8.Species;

import java.util.Objects;
import java.util.Set;

public class Pet {
    private Species species = Species.UNKNOWN;
    private String nickName;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public Pet(String nickName) {
        this.nickName = nickName;
    }

    public Pet(Species species, String nickName, int age, int trickLevel, Set<String> habits) {
        this.species = species;
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return species + "{" +
                "nickName='" + nickName +
                "', age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits +
                ", canFly: " + species.isCanFly() +
                ", hasFur:" + species.isHasFur() +
                ", legsNumber:" + species.getNumberOfLegs() +
                '}';
    }

    void eat(){
        System.out.println("I'm eating");
    }

    void respond() {
        System.out.println("Hello, My master!");
    };

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

    public String prettyFormat() {
        return new StringBuilder()
                .append("{")
                .append(species)
                .append(String.format(" %s, age=%d, ", nickName, age))
                .append("habits: " + habits)
                .append("}")
                .toString();
    }
}
