package homework9;

import homework8.Family;
import homework8.Human;
import homework8.Pet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyController {
    FamilyService famService = new FamilyService();

    public List<Family> getAllFamilies() {
        return famService.getAllFamilies();
    }

    public void displayAllFamilies() {
        famService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int num) {
        return famService.getFamiliesBiggerThan(num);
    }

    public List<Family> getFamiliesLessThan(int num) {
        return famService.getFamiliesLessThan(num);
    }

    public int countFamiliesWithMemberNumber(int num) {
        return famService.countFamiliesWithMemberNumber(num);
    }

    public void createNewFamily(Human m, Human f) {
        famService.createNewFamily(m, f);
    }

    public boolean deleteFamilyByIndex(int index) {
        return famService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family f, String femName, String maleName) {
        famService.bornChild(f, femName, maleName);
        return f;
    }

    public Family adoptChild(Family f, Human h) {
        famService.adoptChild(f, h);
        return f;
    }

    public void deleteAllChildrenOlderThen(int age) {
        famService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return famService.count();
    }

    public Family getFamilyById(int index) {
        return famService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        return famService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        famService.addPet(index, pet);
    }
}
