package homework9;

import homework8.Family;
import homework8.Human;
import homework8.Pet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public void createNewFamily(Human m, Human f) { //tested in Main
        famService.createNewFamily(m, f);
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

    public void deleteAllChildrenOlderThen(int age) { //tested in Main
        famService.deleteAllChildrenOlderThen(age);
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
