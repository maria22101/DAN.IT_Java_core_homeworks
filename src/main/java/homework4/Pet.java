package homework4;

import java.util.Arrays;

public class Pet {
    String species;
    String nickName;
    int age;
    int trickLevel;
    String[] habits;

    public Pet(String species, String nickName) {
        this.species = species;
        this.nickName = nickName;
    }

    public Pet(String species, String nickName, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickName = nickName;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return species + "{" +
                "nickName='" + nickName +
                "', age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    void eat(){
        System.out.println("I'm eating");
    }

    void respond(){
        System.out.println("Hello, Master. I'm " + nickName + ". I've been missing you!");
    }

    void foul(){
        System.out.println("Oops! I need to hide this mess...");
    }

}
