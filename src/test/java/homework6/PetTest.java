package homework6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    private Pet petInTest;

    @BeforeEach
    void beforeEach(){
        petInTest = new Pet(Species.CAT, "Tigra", 11, 95, new String[]{"play", "scratch"});
    }

    @Test
    void toString_correctObjectDisplayWithString() {
        assertEquals("CAT{nickName='Tigra', age=11, trickLevel=95, habits=[play, scratch], canFly: false, hasFur:true, legsNumber:4}"
                , petInTest.toString());
    }

    @Test
    void equals_withSameObjects_true() {
        Pet samePet = petInTest;
        assertEquals(true, petInTest.equals(samePet));
    }

    @Test
    void equals_withNull_false() {
        Pet nullPet = null;
        assertEquals(false, petInTest.equals(nullPet));
    }

    @Test
    void equals_differentClasses_false() {
        Human diffClass = new Human();
        assertEquals(false, petInTest.equals(diffClass));
    }

    @Test
    void equals_sameClassAndSameFields_true(){
        Pet pet = new Pet(Species.CAT, "Tigra", 11, 45, new String[]{"sleep", "play"});
        assertEquals(true, petInTest.equals(pet));
    }

    @Test
    void equals_sameClassAndDifferentFieldAge_false(){
        Pet pet = new Pet(Species.CAT, "Tigra", 2, 45, new String[]{"sleep", "play"});
        assertEquals(false, petInTest.equals(pet));
    }

    @Test
    void equals_sameClassAndDifferentFieldSpecies_false(){
        Pet pet = new Pet(Species.DOG, "Tigra", 11, 45, new String[]{"sleep", "play"});
        assertEquals(false, petInTest.equals(pet));
    }

    @Test
    void equals_sameClassAndDifferentFieldNickName_false(){
        Pet pet = new Pet(Species.CAT, "Tom", 11, 45, new String[]{"sleep", "play"});
        assertEquals(false, petInTest.equals(pet));
    }

    @Test
    void equals_equalAndHashcodeContract_true(){
        Pet pet = new Pet(Species.CAT, "Tigra", 11, 45, new String[]{"sleep", "play"});
        boolean isEqual = petInTest.equals(pet);
        boolean isHashEqual = petInTest.hashCode() == pet.hashCode() ? true : false;
        assertEquals(true, isEqual);
        assertEquals(true, isHashEqual);
    }

    @Test
    void hashCode_true(){
        Object[] arr = new Object[]{petInTest.getSpecies(), petInTest.getNickName(), petInTest.getAge()};
        int result = Arrays.hashCode(arr);
        assertEquals(result, petInTest.hashCode());
    }
}