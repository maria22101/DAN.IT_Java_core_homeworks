package homework12;

import homework12.Family;
import homework12.Human;

import java.util.List;

public interface FamilyDAO {
    void createFamily(Human female, Human male);
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int familyToGetIndex);
    boolean deleteFamily(int familyToDeleteIndex);
    boolean deleteFamily(Family familyToDelete);
    void saveFamily(Family familyToSave);
}
