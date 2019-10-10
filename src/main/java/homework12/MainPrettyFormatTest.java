package homework12;

import homework8.Species;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainPrettyFormatTest {
    public static void main(String[] args) {
        Human f1 = new Human("Ann", "Amber", 45);
        Human m1 = new Human("Adam", "Amber", 46);
        Human adopted1 = new Human("Alan", "Davis", 16);

        Human f2 = new Human("Tea", "Taller", 54);
        f2.setSchedule(new HashMap<String, String>(){{
            put("SUNDAY", "Jogging");
            put("MONDAY", "Meditation");
        }});
        Human m2 = new Human("Teodor", "Taller", 56);
        m2.setSchedule(new HashMap<String, String>(){{
            put("SUNDAY", "Gardening");
            put("MONDAY", "Gym");
        }});
        Human adopted2 = new Woman("Tomasa", "McQuinn", 6);
        Set<String> catHabits = new HashSet<>();
        catHabits.add("play");
        catHabits.add("sleep");
        Pet pet2 = new Pet(Species.CAT, "Tigra", 11, 70, catHabits);

        Human f3 = new Human("Nicole", "Nocks", 35);
        Human m3 = new Human("Noa", "Nocks", 36);
        Human adopted3 = new Man("Nill", "Fergus", 17);
        Pet pet31 = new Pet(Species.DOG, "Cake", 2, 55, catHabits);
        Pet pet32 = new Pet(Species.DOG, "Black", 1, 50, catHabits);

        Family family1_1 = new Family(f1, m1);

        Family family_2 = new Family(f2, m2);
        Set<Pet> pets_2 = new HashSet<>();
        pets_2.add(pet2);
        pets_2.add(pet31);
        pets_2.add(pet32);
        family_2.setPet(pets_2);
        family_2.addChild(adopted3);
        family_2.addChild(adopted2);
        System.out.println(family_2.prettyFormat());

        Family family_3 = new Family(f3, m3);
        Set<Pet> pets_3 = new HashSet<>();
        pets_3.add(pet31);
        pets_3.add(pet32);
        family_3.setPet(pets_3);

//        System.out.println(f2.prettyFormat());
    }
}
