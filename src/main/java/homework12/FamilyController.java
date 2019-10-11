package homework12;

import homework12.Family;
import homework12.Human;
import homework12.Pet;
import homework12.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {
    FamilyService famService = new FamilyService();

    public List<Family> getAllFamilies() { //tested in Main
        return famService.getAllFamilies();
    }

    public void displayAllFamilies() { //tested in Main
        famService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int num) {//tested in Main
        famService.getFamiliesBiggerThan(num);
    }

    public void getFamiliesLessThan(int num) {//tested in Main
        famService.getFamiliesLessThan(num);
    }

    public int countFamiliesWithMemberNumber(int num) {//tested in Main
        return famService.countFamiliesWithMemberNumber(num);
    }

    public void createNewFamily(Human f, Human m) { //tested in Main
        famService.createNewFamily(f, m);
    }

    public boolean deleteFamilyByIndex(int index) {//tested in Main
        return famService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family f, String femName, String maleName) { //tested in Main
        famService.bornChild(f, femName, maleName);
        return f;
    }

    public Family adoptChild(Family f, Human h) { //tested in Main
        famService.adoptChild(f, h);
        return f;
    }

    public void deleteAllChildrenOlderThan(int age) { //tested in Main
        famService.deleteAllChildrenOlderThan(age);
    }

    public int count() {//tested in Main
        return famService.count();
    }

    public Family getFamilyById(int index) { //tested in Main
        return famService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) { //tested in Main
        return famService.getPets(index);
    }

    public void addPet(int index, Pet pet) { //tested in Main
        famService.addPet(index, pet);
    }
}
