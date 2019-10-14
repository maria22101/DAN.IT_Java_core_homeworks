package homework12;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDAO familyDao = new CollectionFamilyDAO();

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
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
        familyDao.createFamily(female, male);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String femaleName, String maleName) throws FamilyOverflowException {
        if (family.countFamily() < FamilyOverflowException.MEMBERS) {
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
            familyDao.saveFamily(family);
            return family;
        } else throw new FamilyOverflowException(family);
    }

    public Family adoptChild(Family family, Human newChild) throws FamilyOverflowException {
        if (family.countFamily() < FamilyOverflowException.MEMBERS) {
            newChild.setFamily(family);
            newChild.setSurname(family.getFather().getSurname());
            family.getChildren().add(newChild);
            familyDao.saveFamily(family);
            return family;
        } else throw new FamilyOverflowException(family);
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
                    familyDao.saveFamily(family);
                });
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        return familyDao.getFamilyByIndex(index).getPet();
    }

    public void addPet(int index, Pet pet) {
        Family fam = familyDao.getFamilyByIndex(index);
        fam.getPet().add(pet);
        familyDao.saveFamily(fam);
    }

    public void loadData() {
        familyDao.loadData(familyDao.getAllFamilies());
    }
}
