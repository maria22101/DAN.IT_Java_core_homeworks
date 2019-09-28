package homework9;

import homework8.Family;
import homework8.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    private FamilyService famServiceInTest = new FamilyService();
    private List<Family> listFamilies = new ArrayList<>();

    @BeforeEach
    void beforeEach(){
        Human mother1 = new Human("Eva", "Eton", 45);
        Human father1 = new Human("El", "Eton", 46);
        Family f1 = new Family(mother1, father1);
        Human mother2 = new Human("Mia", "Morris", 33);
        Human father2 = new Human("Mark", "Morris", 38);
        Family f2 = new Family(mother2, father2);
        listFamilies.add(f1);
        listFamilies.add(f2);
        famServiceInTest.createNewFamily(mother1, father1);
        famServiceInTest.createNewFamily(mother2, father2);
    }

    @Test
    void createNewFamily_and_getAllFamilies(){
        Human mother3 = new Human("Nika", "Nike", 45);
        Human father3 = new Human("Noel", "Nike", 46);
        Family f3 = new Family(mother3, father3);
        listFamilies.add(f3);

        famServiceInTest.createNewFamily(mother3, father3);
        assertEquals(listFamilies, famServiceInTest.getAllFamilies());
    }

    @Test
    void displayAllFamilies_storageOfFamiliesDisplayed(){
        String result = "Family{mother=Human{name='Eva', surname='Eton', year=45}, " +
                "father=Human{name='El', surname='Eton', year=46}, children=[], pet=[]}\r\n" +
                "Family{mother=Human{name='Mia', surname='Morris', year=33}, " +
                "father=Human{name='Mark', surname='Morris', year=38}, children=[], pet=[]}\r\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        famServiceInTest.displayAllFamilies();
        String outputString = new String(output.toByteArray());
        assertEquals(result, outputString);
    }

    @Test
    void getFamilyById(){
        Family expectedFamily = new Family(new Human("Mia", "Morris", 33), new Human("Mark", "Morris", 38));
        Family returnedFamily = famServiceInTest.getFamilyById(1);
        assertEquals(expectedFamily, returnedFamily);

        int notExistingFamilyIndex = 3;
        assertEquals(null, famServiceInTest.getFamilyById(notExistingFamilyIndex));
    }

    @Test
    void deleteFamilyByIndex(){
        assertTrue(famServiceInTest.deleteFamilyByIndex(0));
        listFamilies.remove(0);
        assertEquals(listFamilies, famServiceInTest.getAllFamilies());
    }
}