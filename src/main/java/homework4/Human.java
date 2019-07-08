package homework4;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Human {
    String name;
    String surname;
    int year;
    int iQ;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, int iQ, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iQ = iQ;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public Human() {
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name +
                "', surname='" + surname +
                "', year=" + year +
                ", iQ=" + iQ +
                ", mother=" + (mother != null ? mother.name + " " + mother.surname : null) +
                ", father=" + (father != null ? father.name + " " + father.surname : null) +
                ", pet=" + this.pet + "}";
    }

    void greetPet() {
        System.out.println("Hello, " + pet.nickName + "!");
    }

    void describePet() {
        String howSmartIsPet = pet.trickLevel > 50 ? "very smart" : "not as smart";
        System.out.printf("I have a %s, he is %d years old, he is %s", pet, pet.age, howSmartIsPet);
        System.out.println();
    }

    boolean feedPet(boolean isTimeToEat) {
        boolean flag = false;
        if (isTimeToEat) {
            System.out.printf("Hmm, I think I will feed %s ", this.pet.nickName);
            System.out.println();
            flag = true;
        } else {
            Random rand = new Random();
            if (this.pet.trickLevel > rand.nextInt(100)) {
                System.out.printf("Hmm, I think I will feed %s ", this.pet.nickName);
                System.out.println();
                flag = true;
            } else {
                System.out.printf("I think %s is not hungry", this.pet.nickName);
                System.out.println();
            }
        }
        return flag;
    }
}
