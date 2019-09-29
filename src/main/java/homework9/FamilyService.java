package homework9;

import homework8.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDAO fDao = new CollectionFamilyDAO();

    public List<Family> getAllFamilies() {//added in test - tested (together with createNewFamily)
        return fDao.getAllFamilies();
    }

    public void displayAllFamilies() {//added in test - tested
        getAllFamilies().stream().forEach(System.out::println);
    }

    public void getFamiliesBiggerThan(int familySize) {// added in test - tested
        List<Family> list = getAllFamilies().stream().filter(f -> f.countFamily() > familySize).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    public void getFamiliesLessThan(int familySize) {// added in test - tested
        List<Family> list = getAllFamilies().stream().filter(f -> f.countFamily() < familySize).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    public int countFamiliesWithMemberNumber(int familySize) {
        List<Family> list = getAllFamilies().stream().filter(f -> f.countFamily() == familySize).collect(Collectors.toList());
        return list.size();
    }

    public void createNewFamily(Human female, Human male) { //added in test -> tested (together with getAllFamilies)
        fDao.createFamily(female, male);
    }

    public boolean deleteFamilyByIndex(int familyToDeleteIndex) { //added in test - tested
        return fDao.deleteFamily(familyToDeleteIndex);
    }

    public Family bornChild(Family family, String femaleName, String maleName) { //added in test - tested
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

    public Family adoptChild(Family family, Human newChild) { //added in test - tested
        newChild.setFamily(family);
        newChild.setSurname(family.getFather().getSurname());
        family.getChildren().add(newChild);
        fDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int ageToCompareWith) {//added in test - tested

        for (Family fam : getAllFamilies()) {
            if (fam.getChildren().stream().filter(ch -> ch.getYear() > ageToCompareWith).collect(Collectors.toList()).size() > 0) {
                List<Human> newChildrenList = fam.getChildren()
                        .stream()
                        .filter(ch -> ch.getYear() <= ageToCompareWith)
                        .collect(Collectors.toList());
                fam.setChildren(newChildrenList);
                fDao.saveFamily(fam);
            }
        }
    }

    public int count() {//added to test - tested
        return getAllFamilies().size();
    }

    public Family getFamilyById(int familyToGetIndex) { //added to test - tested
        return fDao.getFamilyByIndex(familyToGetIndex);
    }

    public Set<Pet> getPets(int familyWhichPetsRequestedIndex) {//added to test - tested
        return fDao.getFamilyByIndex(familyWhichPetsRequestedIndex).getPet();
    }

    public void addPet(int familyWhichTakesPetIndex, Pet pet) {//added to test - tested
        Family fam = fDao.getFamilyByIndex(familyWhichTakesPetIndex);
        fam.getPet().add(pet);
        fDao.saveFamily(fam);
    }

}
