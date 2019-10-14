package homework12;

import java.util.List;
import java.util.Set;

public class FamilyController {
    FamilyService familyService = new FamilyService();

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int num) {
        familyService.getFamiliesBiggerThan(num);
    }

    public void getFamiliesLessThan(int num) {
        familyService.getFamiliesLessThan(num);
    }

    public int countFamiliesWithMemberNumber(int num) {
        return familyService.countFamiliesWithMemberNumber(num);
    }

    public void createNewFamily(Human female, Human male) {
        familyService.createNewFamily(female, male);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String femaleName, String maleName) {
        try {
            familyService.bornChild(family, femaleName, maleName);
        } catch (FamilyOverflowException ex) {
            System.out.println("Максимальный допустимый размер семьи превышен");
        }
        return family;
    }

    public Family adoptChild(Family family, Human human) {
        try {
            familyService.adoptChild(family, human);
        } catch (FamilyOverflowException ex) {
            System.out.println("Максимальный допустимый размер семьи превышен");
        }
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }

    public void loadData() {
        familyService.loadData();
    }
}
