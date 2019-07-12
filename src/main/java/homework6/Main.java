package homework6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100_000; i++) {
            Human human = new Human();
        }

        Human h = new Human("Leon", "Collins", 43);
        String[][] sch = new String[][]{
                {DayOfWeek.SUNDAY.name(), "Sport"},
                {DayOfWeek.MONDAY.name(), "Office"},
                {DayOfWeek.TUESDAY.name(), "Trip"},
                {DayOfWeek.WEDNESDAY.name(), "Courses"},
                {DayOfWeek.THURSDAY.name(), "Homework"},
                {DayOfWeek.FRIDAY.name(), "Friends"},
                {DayOfWeek.SATURDAY.name(), "Relax"},

        };
    }
}
