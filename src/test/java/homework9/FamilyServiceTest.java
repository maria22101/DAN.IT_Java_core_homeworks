package homework9;

import homework8.Family;
import homework8.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    private FamilyService famServiceInTest;

    @BeforeEach
    void beforeEach(){
        famServiceInTest = new FamilyService();
    }

    @Test
    void createNewFamily_and_getAllFamilies(){
        Human mother1 = new Human("Inga", "Eton", 45);
        Human father1 = new Human("Igor", "Eton", 46);
        Family f1 = new Family(mother1, father1);

        Human mother2 = new Human("Mia", "Morris", 33);
        Human father2 = new Human("Mark", "Morris", 38);
        Family f2 = new Family(mother2, father2);

        List<Family> listFamilies = new ArrayList<Family>();
        listFamilies.add(f1);
        listFamilies.add(f2);

        famServiceInTest.createNewFamily(mother1, father1);
        famServiceInTest.createNewFamily(mother2, father2);

        assertEquals(listFamilies, famServiceInTest.getAllFamilies());
    }

    @Test
    void displayAllFamilies_storageOfFamiliesDisplayed(){

    }
}