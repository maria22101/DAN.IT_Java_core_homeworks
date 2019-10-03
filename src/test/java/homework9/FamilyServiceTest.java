package homework9;

import homework8.DomesticCat;
import homework8.Family;
import homework8.Human;
import homework8.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    private FamilyService familyService = new FamilyService();
    private List<Family> listFamilies = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        Human mother1 = new Human("Eva", "Eton", 45);
        Human father1 = new Human("El", "Eton", 46);
        Family f1 = new Family(mother1, father1);
        Human mother2 = new Human("Mia", "Morris", 33);
        Human father2 = new Human("Mark", "Morris", 38);
        Family f2 = new Family(mother2, father2);
        listFamilies.add(f1);
        listFamilies.add(f2);
        familyService.createNewFamily(mother1, father1);
        familyService.createNewFamily(mother2, father2);
    }

    @Test
    void createNewFamily_and_getAllFamilies () {
        Human mother3 = new Human("Nika", "Nike", 45);
        Human father3 = new Human("Noel", "Nike", 46);
        Family f3 = new Family(mother3, father3);
        listFamilies.add(f3);
        familyService.createNewFamily(mother3, father3);

        assertEquals(listFamilies, familyService.getAllFamilies());
    }

    @Test
    void displayAllFamilies_storageOfFamiliesDisplayed () {
        String result = "Family{mother=Human{name='Eva', surname='Eton', year=45}, " +
                "father=Human{name='El', surname='Eton', year=46}, children=[], pet=[]}\r\n" +
                "Family{mother=Human{name='Mia', surname='Morris', year=33}, " +
                "father=Human{name='Mark', surname='Morris', year=38}, children=[], pet=[]}\r\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        familyService.displayAllFamilies();
        String outputString = new String(output.toByteArray());

        assertEquals(result, outputString);
    }

    @Test
    void getFamiliesBiggerThan_biggerThanRequestedFamilyReturned (){
        Human mother3 = new Human("Kate", "Kean", 23);
        Human father3 = new Human("Klive", "Kean", 24);
        familyService.createNewFamily(mother3, father3);

        familyService.adoptChild(familyService.getFamilyById(0), new Human("Emi", "Young", 6));
        familyService.adoptChild(familyService.getFamilyById(0), new Human("Elizabeth", "Young", 8));
        familyService.bornChild(familyService.getFamilyById(2), "Kendra", "Kolin");

        String expectedResult1 = "Family{mother=Human{name='Eva', surname='Eton', year=45}, " +
                "father=Human{name='El', surname='Eton', year=46}, children=[Human{name='Emi', surname='Eton', year=6}," +
                " Human{name='Elizabeth', surname='Eton', year=8}], pet=[]}\r\n" +
                "Family{mother=Human{name='Kate', surname='Kean', year=23}, " +
                "father=Human{name='Klive', surname='Kean', year=24}, " +
                "children=[Human{name='Kendra', surname='Kean', year=0}], pet=[]}\r\n";

        String expectedResult2 = "Family{mother=Human{name='Eva', surname='Eton', year=45}, " +
                "father=Human{name='El', surname='Eton', year=46}, children=[Human{name='Emi', surname='Eton', year=6}," +
                " Human{name='Elizabeth', surname='Eton', year=8}], pet=[]}\r\n" +
                "Family{mother=Human{name='Kate', surname='Kean', year=23}, " +
                "father=Human{name='Klive', surname='Kean', year=24}, " +
                "children=[Human{name='Kolin', surname='Kean', year=0}], pet=[]}\r\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        familyService.getFamiliesBiggerThan(2);
        String result = new String(output.toByteArray());

        assertTrue(expectedResult1.equals(result) || expectedResult2.equals(result));
    }

    @Test
    void getFamiliesLessThan_lessThanRequestedFamilyReturned (){
        familyService.adoptChild(familyService.getFamilyById(1), new Human("Emi", "Young", 6));

        String expectedResult = "Family{mother=Human{name='Eva', surname='Eton', year=45}, " +
                "father=Human{name='El', surname='Eton', year=46}, children=[], pet=[]}\r\n";

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        familyService.getFamiliesLessThan(3);
        String result = new String(output.toByteArray());

        assertEquals(expectedResult, result);
    }

    @Test
    void countFamiliesWithMemberNumber_numberOfFamiliesOfRequestedSizeReturned (){
        Human mother3 = new Human("Kate", "Kean", 23);
        Human father3 = new Human("Klive", "Kean", 24);
        familyService.createNewFamily(mother3, father3);

        familyService.adoptChild(familyService.getFamilyById(0), new Human("Emi", "Young", 6));
        familyService.adoptChild(familyService.getFamilyById(0), new Human("Elizabeth", "Young", 8));
        familyService.bornChild(familyService.getFamilyById(1), "Maya", "Mike");
        familyService.bornChild(familyService.getFamilyById(2), "Kendra", "Kolin");

        int familySize = 3;
        int expectedNumberOfFamilies = 2;
        int returnedNumberOfFamilies = familyService.countFamiliesWithMemberNumber(familySize);

        assertEquals(expectedNumberOfFamilies, returnedNumberOfFamilies);
    }

    @Test
    void getFamilyById_correctFamilyReturned_nullIfIndexNotFound () {
        Family expectedFamily = new Family(new Human("Mia", "Morris", 33), new Human("Mark", "Morris", 38));
        Family returnedFamily = familyService.getFamilyById(1);

        assertEquals(expectedFamily, returnedFamily);

        int notExistingFamilyIndex = 3;

        assertNull(familyService.getFamilyById(notExistingFamilyIndex));
    }

    @Test
    void deleteFamilyByIndex_trueOrFalseReturned_correctListOfFamiliesRemained () {
        assertTrue(familyService.deleteFamilyByIndex(0));
        listFamilies.remove(0);

        assertEquals(listFamilies, familyService.getAllFamilies());
        assertFalse(familyService.deleteFamilyByIndex(4));
    }

    @Test
    void bornChild_familyWithBornChildReturned () {
        Family familyToBornChild = familyService.getFamilyById(1);
        Family returnedFamilyWithChild = familyService.bornChild(familyToBornChild, "Mari", "Mike");

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
    void adoptChild_familyWithAdoptedChildReturned () {
        Family familyToAdoptChild = familyService.getFamilyById(0);
        Human childToBeAdopted = new Human("Elise", "Cooper", 5);
        childToBeAdopted.setFamily(familyToAdoptChild);
        childToBeAdopted.setSurname(familyToAdoptChild.getFather().getSurname());
        familyToAdoptChild.getChildren().add(childToBeAdopted);
        Family returnedFamilyWithAdoptedChild = familyService.adoptChild(familyToAdoptChild, childToBeAdopted);

        assertEquals(familyToAdoptChild, returnedFamilyWithAdoptedChild);
    }

    @Test
    void deleteAllChildrenOlderThan_childrenWithRequestedAgeRemovedFromFamily (){
        Human childToBeAdopted1 = new Human("Elise", "Cooper", 5);
        Human childToBeAdopted2 = new Human("Frank", "Cooper", 14);
        Human childToBeAdopted3 = new Human("Gemma", "Cooper", 19);
        Human childToBeAdopted4 = new Human("Hank", "Cooper", 21);

        Family exampleFamily = new Family(new Human(), new Human());
        exampleFamily.addChild(childToBeAdopted1);
        exampleFamily.addChild(childToBeAdopted2);
        exampleFamily.addChild(childToBeAdopted3);
        exampleFamily.addChild(childToBeAdopted4);
        exampleFamily.deleteChild(childToBeAdopted3);
        exampleFamily.deleteChild(childToBeAdopted4);
        List<Human> expectedChildrenList = exampleFamily.getChildren();

        Family familyTested = familyService.getFamilyById(1);
        familyService.adoptChild(familyTested, childToBeAdopted1);
        familyService.adoptChild(familyTested, childToBeAdopted2);
        familyService.adoptChild(familyTested, childToBeAdopted3);
        familyService.adoptChild(familyTested, childToBeAdopted4);
        familyService.deleteAllChildrenOlderThan(18);
        List<Human> returnedChildrenList = familyService.getFamilyById(1).getChildren();

        assertEquals(expectedChildrenList, returnedChildrenList);
    }

    @Test
    void count_returnNumberOfFamilies () {
        assertEquals(listFamilies.size(), familyService.count());
    }

    @Test
    void addPet_petAddedToFamilyWithGivenIndex (){
        Set<String> catHabits = new HashSet<>();
        catHabits.add("play");
        catHabits.add("sleep");
        Pet pet = new DomesticCat("Cake", 2, 55, catHabits);

        Family familyToTakePet = familyService.getFamilyById(1);
        familyToTakePet.getPet().add(pet);
        listFamilies.set(1, familyToTakePet);
        familyService.addPet(1, pet);

        assertEquals(listFamilies, familyService.getAllFamilies());
    }

    @Test
    void getPets_returnPetsOfTheFamilyWithGivenIndex () {
        Set<String> catHabits1 = new HashSet<>();
        catHabits1.add("play");
        catHabits1.add("sleep");
        Pet pet1 = new DomesticCat("Whity", 3, 55, catHabits1);

        Set<String> catHabits2 = new HashSet<>();
        catHabits2.add("eat");
        catHabits2.add("hide");
        Pet pet2 = new DomesticCat("Blacky", 2, 75, catHabits2);

        familyService.addPet(1, pet1);
        familyService.addPet(1, pet2);

        Set<Pet> expectedPets = familyService.getFamilyById(1).getPet();
        Set<Pet> returnedPets = familyService.getPets(1);

        assertEquals(expectedPets, returnedPets);

        Set<Pet> expectedEmptyPetsSet = familyService.getFamilyById(0).getPet();
        Set<Pet> returnedEmptyPetsSet = familyService.getPets(0);

        assertEquals(expectedEmptyPetsSet, returnedEmptyPetsSet);
    }
}