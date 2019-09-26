package homework9;

import homework8.Family;
import homework8.Human;

import java.util.List;

public interface FamilyDAO {
    void createFamily(Human female, Human male);
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int familyToGetIndex);
    boolean deleteFamily(int familyToDeleteIndex);
    boolean deleteFamily(Family familyToDelete);
    void saveFamily(Family familyToSave);
}
