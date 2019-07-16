package homework8;

import java.util.*;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iQ;
    private Map<String, String> schedule;
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

    public void setFamily(Family family) {
        this.family = family;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iQ=" + iQ +
                ", schedule=" + schedule +
                '}';
    }

    void greetPet() {
        for (Pet petMember : family.getPet()) {
            System.out.println("Hello, " + petMember + "!");
        }
    }

    void describePet() {
        for (Pet petMember : family.getPet()) {
            String howSmartIsPet = petMember.getTrickLevel() > 50 ? "very smart" : "not as smart";
            System.out.printf("I have a %s, he is %d years old, he is %s", petMember, petMember.getAge(), howSmartIsPet);
            System.out.println();
        }

    }

    boolean feedPet(boolean isTimeToEat) {
        boolean flag = false;

        for (Pet petMember : family.getPet()) {
            if (isTimeToEat) {
                System.out.printf("Hmm, I think I will feed %s ", petMember.getNickName());
                System.out.println();
                flag = true;
            } else {
                Random rand = new Random();
                if (petMember.getTrickLevel() > rand.nextInt(100)) {
                    System.out.printf("Hmm, I think I will feed %s ", petMember.getNickName());
                    System.out.println();
                    flag = true;
                } else {
                    System.out.printf("I think %s is not hungry", petMember.getNickName());
                    System.out.println();
                }
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
        System.out.println(this.toString() + "is being deleted...");
        ;
    }

}
