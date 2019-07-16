package homework8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    private Human humanInTest;

    @BeforeEach
    void beforeEach() {
        humanInTest = new Human("Morgan", "Morris", 1975, 80, new Family(new Human(), new Human()));

        Map<String, String> schedule = new HashMap<>();
        schedule.put("Mon", "Office");
        schedule.put("Tue", "Courses");
        schedule.put("Wed", "Homework");
        humanInTest.setSchedule(schedule);

        Set<String> catHabits = new HashSet<>();
        catHabits.add("play");
        catHabits.add("sleep");
        Set<Pet> pets = new HashSet<>();
        pets.add(new DomesticCat("Tigra", 11, 95, catHabits));
        pets.add(new DomesticCat("Murzik", 8, 55, catHabits));

        humanInTest.getFamily().setPet(pets);
    }


    @Test
    void toString_correctObjectDisplayWithString() {
        assertEquals("Human{name='Morgan', surname='Morris', year=1975, " +
                     "iQ=80, schedule={Tue=Courses, Wed=Homework, Mon=Office}}", humanInTest.toString());
    }

//    @Test
//    void greetPet_correctOutput() {
//        System.out.println("Hello, Tigra!");
//        assertEquals("Hello, Tigra! \n ", g);
//    }

    @Test
    void describePet() {
    }

    @Test
    void feedPet() {
    }
}