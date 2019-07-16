package homework8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    private Pet petInTest;

    @BeforeEach
    void beforeEach(){
        Set<String> catHabits = new HashSet<>();
        catHabits.add("play");
        catHabits.add("sleep");
        petInTest = new DomesticCat("Tigra", 11, 95, catHabits);
    }

    @Test
    void toString_correctObjectDisplayWithString() {
        assertEquals("CAT{nickName='Tigra', age=11, trickLevel=95, habits=[play, sleep], " +
                "canFly: false, hasFur:true, legsNumber:4}", petInTest.toString());
    }

}