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
    void getFamilyById_correctFamilyReturned_nullIfIndexNotFound(){
        Family expectedFamily = new Family(new Human("Mia", "Morris", 33), new Human("Mark", "Morris", 38));
        Family returnedFamily = famServiceInTest.getFamilyById(1);
        assertEquals(expectedFamily, returnedFamily);

        int notExistingFamilyIndex = 3;
        assertEquals(null, famServiceInTest.getFamilyById(notExistingFamilyIndex));
    }

    @Test
    void deleteFamilyByIndex_trueOrFalseReturned_correctListOfFamiliesRemained(){
        assertTrue(famServiceInTest.deleteFamilyByIndex(0));
        listFamilies.remove(0);
        assertEquals(listFamilies, famServiceInTest.getAllFamilies());
        assertFalse(famServiceInTest.deleteFamilyByIndex(4));
    }

    @Test
    void bornChild_familyWithBornChildReturned(){
        Family familyToBornChild = famServiceInTest.getFamilyById(1);
        Family returnedFamilyWithChild = famServiceInTest.bornChild(familyToBornChild, "Mari", "Mike");

        Family expectedFamilyWithChild1 = new Family(new Human("Mia", "Morris", 33), new Human("Mark", "Morris", 38));
        Family expectedFamilyWithChild2 = new Family(new Human("Mia", "Morris", 33), new Human("Mark", "Morris", 38));
        List<Human> childrenList1 = new ArrayList<>();
        List<Human> childrenList2 = new ArrayList<>();

        Human child1 = new Human();
        child1.setName("Mari");
        child1.setSurname(expectedFamilyWithChild1.getFather().getSurname());
        child1.setFamily(expectedFamilyWithChild1);

        Human child2 = new Human();
        child2.setName("Mike");
        child2.setSurname(expectedFamilyWithChild2.getFather().getSurname());
        child2.setFamily(expectedFamilyWithChild2);

        childrenList1.add(child1);
        childrenList2.add(child2);
        expectedFamilyWithChild1.setChildren(childrenList1);
        expectedFamilyWithChild2.setChildren(childrenList2);

        boolean expectedResult1 = expectedFamilyWithChild1.equals(returnedFamilyWithChild);
        boolean expectedResult2 = expectedFamilyWithChild2.equals(returnedFamilyWithChild);
        assertTrue(expectedResult1 || expectedResult2);
    }

    @Test
    void adoptChild_familyWithAdoptedChildReturned(){
        Family familyToAdoptChild = famServiceInTest.getFamilyById(0);
        Human childToBeAdopted = new Human("Elise", "Cooper", 5);
        childToBeAdopted.setFamily(familyToAdoptChild);
        childToBeAdopted.setSurname(familyToAdoptChild.getFather().getSurname());
        familyToAdoptChild.getChildren().add(childToBeAdopted);

        Family returnedFamilyWithAdoptedChild = famServiceInTest.adoptChild(familyToAdoptChild, childToBeAdopted);
        assertTrue(familyToAdoptChild.equals(returnedFamilyWithAdoptedChild));
    }

    @Test
    void count_returnNumberOfFamilies(){
        int expectedResult = listFamilies.size();
        int returnedResult = famServiceInTest.count();
        assertEquals(expectedResult, returnedResult);
    }
}