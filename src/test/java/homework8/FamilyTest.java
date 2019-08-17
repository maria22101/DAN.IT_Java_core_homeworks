package homework8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    private Family familyInTest;

    @BeforeEach
    void beforeEach(){
        Human child1 = new Human("Iv", "Eton", 12);
        Human child2 = new Human("Ivo", "Eton", 14);
        Human child3 = new Human("Ivan", "Eton", 23);
        List<Human> childrenList = new ArrayList<>();
        childrenList.add(child1);
        childrenList.add(child2);
        childrenList.add(child3);

        Human mother = new Human("Inga", "Eton", 45);
        Human father = new Human("Igor", "Eton", 46);
        familyInTest = new Family(mother, father);
        familyInTest.setChildren(childrenList);
    }

    @Test
    void deleteChild_givenChildDeletedFromChildrenArray() {
        Human ch = familyInTest.getChildren().get(1);

        List<Human> result = new ArrayList<>();
        result.add(familyInTest.getChildren().get(0));
        result.add(familyInTest.getChildren().get(2));

        assertTrue(familyInTest.deleteChild(ch));
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void deleteChild_wrongChildEntry_falseAndChildrenArrayUnchanged() {
        Human ch = new Human("Bob", "Black", 1999);

        List<Human> result = new ArrayList<>();
        result.add(familyInTest.getChildren().get(0));
        result.add(familyInTest.getChildren().get(1));
        result.add(familyInTest.getChildren().get(2));

        assertFalse(familyInTest.deleteChild(ch));
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void deleteChild_childWithGivenIndexDeletedFromChildrenArray() {
        int index = 1;

        List<Human> result = new ArrayList<>();
        result.add(familyInTest.getChildren().get(0));
        result.add(familyInTest.getChildren().get(2));

        assertTrue(familyInTest.deleteChild(index));
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void deleteChild_wrongIndexEntry_falseAndChildrenArrayUnchanged() {
        int index = 3;

        List<Human> result = new ArrayList<>();
        result.add(familyInTest.getChildren().get(0));
        result.add(familyInTest.getChildren().get(1));
        result.add(familyInTest.getChildren().get(2));

        assertFalse(familyInTest.deleteChild(index));
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void addChild_childAddedToChildrenArray() {
        Human newChild = new Human("Eve", "Green", 2011);

        List<Human> result = new ArrayList<>();
        result.add(familyInTest.getChildren().get(0));
        result.add(familyInTest.getChildren().get(1));
        result.add(familyInTest.getChildren().get(2));
        result.add(newChild);

        familyInTest.addChild(newChild);

        assertEquals(4, familyInTest.getChildren().size());
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void countFamily() {
        assertEquals(5, familyInTest.countFamily());
    }

    @Test
    void equalsAppliedToFamily(){
        Human m1 = new Human("Inga", "Eton", 45);
        Human f1 = new Human("Igor", "Eton", 46);
        Family firstFamilyForEquals = new Family(m1, f1);

        Human m2 = new Human("Inga", "Eton", 55);
        Human f2 = new Human("Igor", "Eton", 56);
        Family secondFamilyForEquals = new Family(m2, f2);

        Human m3 = new Human("Inga", "Etoning", 45);
        Human f3 = new Human("Igor", "Etoning", 46);
        Family thirdFamilyForEquals = new Family(m3, f3);

        Human h = new Human();

        assertTrue(familyInTest.equals(familyInTest));
        assertFalse(familyInTest.equals(null));
        assertFalse(familyInTest.equals(h));
        assertTrue(familyInTest.equals(firstFamilyForEquals));
        assertFalse(familyInTest.equals(secondFamilyForEquals));
        assertFalse(familyInTest.equals(thirdFamilyForEquals));
    }
}