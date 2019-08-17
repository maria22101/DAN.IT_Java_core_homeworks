package homework9;

import homework8.Family;
import homework8.Human;
import homework8.Pet;

import java.util.List;
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
        return getAllFamilies().stream().filter(f -> f.countFamily() > num).collect(Collectors.toList());
    }

    public void getFamiliesLessThan(int num){

    }

    public int countFamiliesWithMemberNumber(int num){
        throw new IllegalArgumentException("not implemented yet");
    }

    public void createNewFamily(Human m, Human f){

    }

    public boolean deleteFamilyByIndex(int index){
        throw new IllegalArgumentException("not implemented yet");
    }

    public Family bornChild(Family f, String femName, String maleName){
        throw new IllegalArgumentException("not implemented yet");
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
