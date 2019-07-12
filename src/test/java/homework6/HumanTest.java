package homework6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    private Human humanInTest;

    @BeforeEach
    void beforeEach() {
        humanInTest = new Human("Morgan", "Morris", 1975, 80, new Family(new Human(), new Human()));
        String[][] schedule = new String[][]{
                {"Mon", "Gym"},
                {"Tue", "Theater"},
                {"Wed", "Homework"},
                {"Thu", "Courses"},
                {"Fri", "Party"},
                {"Sat", "Yoga"},
                {"Sun", "Cooking"}
        };
        humanInTest.setSchedule(schedule);
    }

    @Test
    void isToStringCorrect() {
        assertEquals("Human{name='Morgan', surname='Morris', year=1975, iQ=80, schedule=[[Mon, Gym], " +
                "[Tue, Theater], [Wed, Homework], [Thu, Courses], [Fri, Party], [Sat, Yoga], [Sun, Cooking]]}"
                , humanInTest.toString());
    }

    @Test
    void is_equals_correct_when_same_object() {
        Human sameHuman = humanInTest;
        assertEquals(true, humanInTest.equals(sameHuman));
    }

    @Test
    void is_equals_correct_whith_null() {
        Human nullHuman = null;
        assertEquals(false, humanInTest.equals(nullHuman));
    }

    @Test
    void is_equals_correct_whith_different_class() {
        Pet diffClass = new Pet();
        assertEquals(false, humanInTest.equals(diffClass));
    }

    @Test
    void is_equals_correct_with_same_class_and_equalFields(){
        Human human = new Human("Morgan", "Morris", 1975);
        assertEquals(true, humanInTest.equals(human));
    }

    @Test
    void is_equals_correct_with_same_class_and_differentField_1(){
        Human human = new Human("Morgan", "Morris", 1976);;
        assertEquals(false, humanInTest.equals(human));
    }

    @Test
    void is_equals_correct_with_same_class_and_differentField_2(){
        Human human = new Human("Mary", "Morris", 1975);;
        assertEquals(false, humanInTest.equals(human));
    }

    @Test
    void is_equals_correct_with_same_class_and_differentField_3(){
        Human human = new Human("Morgan", "Mors", 1975);;
        assertEquals(false, humanInTest.equals(human));
    }

    @Test
    void equals_and_hashcode_contract_check(){
        Human human = new Human("Morgan", "Morris", 1975);
        boolean isEqual = humanInTest.equals(human);
        boolean isHashEqual = humanInTest.hashCode() == human.hashCode() ? true : false;
        assertTrue(isEqual);
        assertTrue(isHashEqual);
    }
}