package homework6;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    private Family familyInTest;

    @BeforeEach
    void beforeEach(){
        Human child1 = new Human();
        Human child2 = new Human();
        Human child3 = new Human();
        familyInTest = new Family(new Human(), new Human());
        familyInTest.setChildren(new Human[]{child1, child2, child3});
    }

    @Test
    void is_given_child_deleted_from_childrenArray() {
        Human ch = familyInTest.getChildren()[1];
        Human[] result = new Human[]{familyInTest.getChildren()[0], familyInTest.getChildren()[2]};
        assertEquals(true, familyInTest.deleteChild(ch));
        assertTrue(Arrays.equals(result, familyInTest.getChildren()));
    }

    @Test
    void is_childrenArray_unchanged_with_wrongChildEntry() {
        Human wrongChild = new Human("Bob", "Black", 1999);
        Human[] result = new Human[]{familyInTest.getChildren()[0], familyInTest.getChildren()[1], familyInTest.getChildren()[2]};
        assertEquals(false, familyInTest.deleteChild(wrongChild));
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void is_childAtGivenIndex_deleted_from_childrenArray() {
        Human[] result = new Human[]{familyInTest.getChildren()[1], familyInTest.getChildren()[2]};
        assertEquals(true, familyInTest.deleteChild(0));
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void is_childrenArray_unchanged_with_wrongIndexEntry() {
        int wrongIndex = 5;
        Human[] result = new Human[]{familyInTest.getChildren()[0], familyInTest.getChildren()[1], familyInTest.getChildren()[2]};
        assertEquals(false, familyInTest.deleteChild(wrongIndex));
        assertThat(familyInTest.getChildren(), is(result));
    }

    @Test
    void is_child_added_to_ChildrenArray() {
        Human newChild = new Human("Eve", "Green", 2011);
        familyInTest.addChild(newChild);
        assertEquals(4, familyInTest.getChildren().length);
        assertEquals(true, familyInTest.getChildren()[3].equals(newChild));
    }

    @Test
    void is_familyMembers_counted_correctly() {
        assertEquals(5, familyInTest.countFamily());
    }

}