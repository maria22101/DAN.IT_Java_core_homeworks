package homework12;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public Human() {
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, long birthDate, int iQ, Family family) {
        this(name, surname, birthDate);
        this.iq = iQ;
        this.family = family;
    }

    public Human(String name, String surname, String birthDateInString, int iQ) {
        this(name, surname, LocalDate
                .parse(birthDateInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()
        );
        this.iq = iQ;
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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public int getiQ() {
        return iq;
    }

    public void setiQ(int iQ) {
        this.iq = iQ;
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
                ", birthDate=" + DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate())
                + ", iQ=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    void greetPet() {
        for (Pet petMember : family.getPet()) {
            System.out.print("Hello, " + petMember.getNickName() + "!\n");
        }
    }

    void describePet() {
        for (Pet petMember : family.getPet()) {
            String howSmartIsPet = petMember.getTrickLevel() > 50 ? "very smart" : "not as smart";
            System.out.printf("I have a %s, he is %d years old, he is %s\n", petMember.getSpecies(), petMember.getAge(), howSmartIsPet);
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

    String describeAge() {
        StringBuilder result = new StringBuilder();
        LocalDate birthDateLocal = Instant
                .ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return result
                .append("Years: " + Period.between(birthDateLocal, LocalDate.now()).getYears())
                .append(", month: " + Period.between(birthDateLocal, LocalDate.now()).getMonths())
                .append(", days: " + Period.between(birthDateLocal, LocalDate.now()).getDays())
                .toString();
    }

    int getYears() {
        LocalDate birthDateLocal = Instant
                .ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(birthDateLocal, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString() + "is being deleted...");
    }

    public String prettyFormat() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = Instant
                .ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        String result = new StringBuilder()
                .append("{")
                .append(String.format("name=%s, surname=%s, iq=%d, ", name, surname, iq))
                .append(f.format(date) + ", " + schedule)
                .append("}")
                .toString();
        return result;
    }

}
