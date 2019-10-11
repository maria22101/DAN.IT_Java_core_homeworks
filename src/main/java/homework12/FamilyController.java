package homework12;

import homework12.Family;
import homework12.Human;
import homework12.Pet;
import homework12.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {
    FamilyService famService = new FamilyService();

    public List<Family> getAllFamilies() {
        return famService.getAllFamilies();
    }

    public void displayAllFamilies() {
        famService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int num) {
        famService.getFamiliesBiggerThan(num);
    }

    public void getFamiliesLessThan(int num) {
        famService.getFamiliesLessThan(num);
    }

    public int countFamiliesWithMemberNumber(int num) {
        return famService.countFamiliesWithMemberNumber(num);
    }

    public void createNewFamily(Human f, Human m) {
        famService.createNewFamily(f, m);
    }

    public boolean deleteFamilyByIndex(int index) {
        return famService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family f, String femName, String maleName) {
        if (f.countFamily() >= 4) {
            throw new MaximumFamilySize(f);
        } else {
            famService.bornChild(f, femName, maleName);
        }
        return f;
    }

    public Family adoptChild(Family f, Human h) {
        famService.adoptChild(f, h);
        return f;
    }

    public void deleteAllChildrenOlderThan(int age) {
        famService.deleteAllChildrenOlderThan(age);
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
