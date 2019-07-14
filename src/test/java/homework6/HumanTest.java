package homework6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
    void toString_correctObjectDisplayWithString() {
        assertEquals("Human{name='Morgan', surname='Morris', year=1975, iQ=80, schedule=[[Mon, Gym], " +
                "[Tue, Theater], [Wed, Homework], [Thu, Courses], [Fri, Party], [Sat, Yoga], [Sun, Cooking]]}"
                , humanInTest.toString());
    }

    @Test
    void equals_withSameObjects_true() {
        Human sameHuman = humanInTest;
        assertThat(humanInTest.equals(sameHuman), is(true));
    }

    @Test
    void equals_withNull_false() {
        Human nullHuman = null;
        assertThat(humanInTest.equals(nullHuman), is(false));
    }

    @Test
    void equals_differentClasses_false() {
        Pet diffClass = new Pet();
        assertThat(humanInTest.equals(diffClass), is(false));
    }

    @Test
    void equals_sameClassAndSameFields_true(){
        Human human = new Human("Morgan", "Morris", 1975);
        assertThat(humanInTest.equals(human), is(true));
    }

    @Test
    void equals_sameClassAndDifferentFieldYear_false(){
        Human human = new Human("Morgan", "Morris", 1976);;
        assertThat(humanInTest.equals(human), is(false));
    }

    @Test
    void equals_sameClassAndDifferentFieldName_false(){
        Human human = new Human("Mary", "Morris", 1975);;
        assertThat(humanInTest.equals(human), is(false));
    }

    @Test
    void equals_sameClassAndDifferentFieldSurname_false(){
        Human human = new Human("Morgan", "Mors", 1975);;
        assertThat(humanInTest.equals(human), is(false));
    }

    @Test
    void equals_equalAndHashcodeContract_true(){
        Human human = new Human("Morgan", "Morris", 1975);
        boolean isEqual = humanInTest.equals(human);
        boolean isHashEqual = humanInTest.hashCode() == human.hashCode();
        assertThat(isEqual, is(true));
        assertThat(isHashEqual, is(true));
    }

    @Test
    void hashCode_true(){
        Object[] arr = new Object[]{humanInTest.getName(), humanInTest.getSurname(), humanInTest.getYear()};
        int result = Arrays.hashCode(arr);
        assertEquals(result, humanInTest.hashCode());
    }
}