package homework6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    private Pet petInTest;

    @BeforeEach
    void beforeEach(){
        petInTest = new Pet(Species.CAT, "Tigra", 11, 95, new String[]{"play", "scratch"});
    }

    @Test
    void is_toString_correct() {
        assertEquals("CAT{nickName='Tigra', age=11, trickLevel=95, habits=[play, scratch], canFly: false, hasFur:true, legsNumber:4}"
                , petInTest.toString());
    }

    @Test
    void is_equals_correct_when_same_object() {
        Pet samePet = petInTest;
        assertEquals(true, petInTest.equals(samePet));
    }

    @Test
    void is_equals_correct_whith_null() {
        Pet nullPet = null;
        assertEquals(false, petInTest.equals(nullPet));
    }

    @Test
    void is_equals_correct_whith_different_class() {
        Human diffClass = new Human();
        assertEquals(false, petInTest.equals(diffClass));
    }

    @Test
    void is_equals_correct_with_same_class_and_equalFields(){
        Pet pet = new Pet(Species.CAT, "Tigra", 11, 45, new String[]{"sleep", "play"});
        assertEquals(true, petInTest.equals(pet));
    }

    @Test
    void is_equals_correct_with_same_class_and_differentField_1(){
        Pet pet = new Pet(Species.CAT, "Tigra", 2, 45, new String[]{"sleep", "play"});
        assertEquals(false, petInTest.equals(pet));
    }

    @Test
    void is_equals_correct_with_same_class_and_differentField_2(){
        Pet pet = new Pet(Species.DOG, "Tigra", 11, 45, new String[]{"sleep", "play"});
        assertEquals(false, petInTest.equals(pet));
    }

    @Test
    void is_equals_correct_with_same_class_and_differentField_3(){
        Pet pet = new Pet(Species.CAT, "Tom", 11, 45, new String[]{"sleep", "play"});
        assertEquals(false, petInTest.equals(pet));
    }

    @Test
    void equals_and_hashcode_contract_check(){
        Pet pet = new Pet(Species.CAT, "Tigra", 11, 45, new String[]{"sleep", "play"});
        boolean isEqual = petInTest.equals(pet);
        boolean isHashEqual = petInTest.hashCode() == pet.hashCode() ? true : false;
        assertEquals(true, isEqual);
        assertEquals(true, isHashEqual);
    }
}