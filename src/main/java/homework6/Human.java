package homework6;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iQ;
    private String[][] schedule;
    private Family family;

    static {
        System.out.println("New class Human being loaded...");
    }

    {
        System.out.println("New object of Human type being created");
    }

    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iQ, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iQ = iQ;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getiQ() {
        return iQ;
    }

    public void setiQ(int iQ) {
        this.iQ = iQ;
    }

    public Family getFamily() {
        return family;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iQ=" + iQ +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }

    void greetPet() {
        System.out.println("Hello, " + family.getPet().getNickName() + "!");
    }

    void describePet() {
        String howSmartIsPet = family.getPet().getTrickLevel() > 50 ? "very smart" : "not as smart";
        System.out.printf("I have a %s, he is %d years old, he is %s", family.getPet(), family.getPet().getAge(), howSmartIsPet);
        System.out.println();
    }

    boolean feedPet(boolean isTimeToEat) {
        boolean flag = false;
        if (isTimeToEat) {
            System.out.printf("Hmm, I think I will feed %s ", family.getPet().getNickName());
            System.out.println();
            flag = true;
        } else {
            Random rand = new Random();
            if (family.getPet().getTrickLevel() > rand.nextInt(100)) {
                System.out.printf("Hmm, I think I will feed %s ", family.getPet().getNickName());
                System.out.println();
                flag = true;
            } else {
                System.out.printf("I think %s is not hungry", family.getPet().getNickName());
                System.out.println();
            }
        }
        return flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString() + "is being deleted...");;
    }
}
