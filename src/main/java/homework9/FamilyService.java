package homework9;

import homework8.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDAO fDao = new CollectionFamilyDAO();

    public List<Family> getAllFamilies() {
        return fDao.getAllFamilies();
    };

    public void displayAllFamilies(){
        getAllFamilies().stream().forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int num){
        List<Family> list = getAllFamilies().stream().filter(f -> f.countFamily() > num).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        return list;
    }

    public List<Family> getFamiliesLessThan(int num){
        List<Family> list = getAllFamilies().stream().filter(f -> f.countFamily() < num).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        return list;
    }

    public int countFamiliesWithMemberNumber(int num){
        List<Family> list = getAllFamilies().stream().filter(f -> f.countFamily() == num).collect(Collectors.toList());
        return list.size();
    }

    public void createNewFamily(Human m, Human f){
        fDao.createFamily(m, f);
    }

    public boolean deleteFamilyByIndex(int index){
        return fDao.deleteFamily(index);
    }

    public Family bornChild(Family f, String femName, String maleName){
        Human newChild;
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            newChild = new Woman();
            newChild.setName(femName);
        }else {
            newChild = new Man();
            newChild.setName(maleName);
        }
        newChild.setFamily(f);
        newChild.setSurname(f.getFather().getSurname());
        f.getChildren().add(newChild);
        fDao.saveFamily(f);
        return f;
    }

    public Family adoptChild(Family f, Human h) {
        throw new IllegalArgumentException("not implemented yet");
    }

    public void deleteAllChildrenOlderThen(int age){

    }

    public int count(){
        throw new IllegalArgumentException("not implemented yet");
    }

    public Family getFamilyById(int index) {
        throw new IllegalArgumentException("not implemented yet");
    }

    public Set<Pet> getPets(Family f){
        throw new IllegalArgumentException("not implemented yet");
    }

    public void addPet(int index, Pet pet){

    }


}
