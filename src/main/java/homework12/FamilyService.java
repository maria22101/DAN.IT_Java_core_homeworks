package homework12;

import homework12.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDAO fDao = new CollectionFamilyDAO();

    public List<Family> getAllFamilies() {
        return fDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        getAllFamilies().stream().forEach((f) -> System.out.println(f.prettyFormat()));
    }

    public void getFamiliesBiggerThan(int familySize) {
        getAllFamilies()
                .stream()
                .filter(f -> f.countFamily() > familySize)
                .forEach((f) -> System.out.println(f.prettyFormat()));
    }

    public void getFamiliesLessThan(int familySize) {
        getAllFamilies()
                .stream()
                .filter(f -> f.countFamily() < familySize)
                .forEach((f) -> System.out.println(f.prettyFormat()));
    }

    public int countFamiliesWithMemberNumber(int familySize) {
        return getAllFamilies()
                .stream()
                .filter(f -> f.countFamily() == familySize)
                .collect(Collectors.toList())
                .size();
    }

    public void createNewFamily(Human female, Human male) {
        fDao.createFamily(female, male);
    }

    public boolean deleteFamilyByIndex(int familyToDeleteIndex) {
        return fDao.deleteFamily(familyToDeleteIndex);
    }

    public Family bornChild(Family family, String femaleName, String maleName) {
        Human newChild;
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            newChild = new Woman();
            newChild.setName(femaleName);
        } else {
            newChild = new Man();
            newChild.setName(maleName);
        }
        newChild.setFamily(family);
        newChild.setSurname(family.getFather().getSurname());
        family.getChildren().add(newChild);
        fDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human newChild) {
        newChild.setFamily(family);
        newChild.setSurname(family.getFather().getSurname());
        family.getChildren().add(newChild);
        fDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int ageToCompareWith) {
        getAllFamilies()
                .stream()
                .forEach((family) -> {
                    List<Human> newChildrenList = family.getChildren()
                            .stream()
                            .filter((child) -> child.getYears() <= ageToCompareWith)
                            .collect(Collectors.toList());
                    family.setChildren(newChildrenList);
                    fDao.saveFamily(family);
                });
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int familyToGetIndex) {
        return fDao.getFamilyByIndex(familyToGetIndex);
    }

    public Set<Pet> getPets(int familyWhichPetsRequestedIndex) {
        return fDao.getFamilyByIndex(familyWhichPetsRequestedIndex).getPet();
    }

    public void addPet(int familyWhichTakesPetIndex, Pet pet) {
        Family fam = fDao.getFamilyByIndex(familyWhichTakesPetIndex);
        fam.getPet().add(pet);
        fDao.saveFamily(fam);
    }
}
