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
        familyInTest = new Family(new Human(), new Human());
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
}