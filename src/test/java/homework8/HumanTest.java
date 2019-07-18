package homework8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

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
        pets.add(new RoboCat("RoKet", 8, 20, catHabits));
        humanInTest.getFamily().setPet(pets);
    }

    @Test
    void toString_correctObjectDisplayWithString() {
        assertEquals("Human{name='Morgan', surname='Morris', year=1975, " +
                     "iQ=80, schedule={Tue=Courses, Wed=Homework, Mon=Office}}", humanInTest.toString());
    }

    @Test
    void greetPet_correctOutput() {
        String result = "Hello, Tigra!\n" +
                "Hello, RoKet!\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        humanInTest.greetPet();
        String outputString = new String(output.toByteArray());
        assertEquals(result, outputString);
    }

    @Test
    void describePet() {
        String result = "I have a CAT, he is 11 years old, he is very smart\n" +
                "I have a ROBO_CAT, he is 8 years old, he is not as smart\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        humanInTest.describePet();
        String outputString = new String(output.toByteArray());
        assertEquals(result, outputString);
    }

}