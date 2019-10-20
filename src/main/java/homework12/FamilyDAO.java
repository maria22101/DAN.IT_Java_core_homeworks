package homework12;

import java.util.List;

public interface FamilyDAO {
    void createFamily(Human female, Human male);
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int familyToGetIndex);
    boolean deleteFamily(int familyToDeleteIndex);
    boolean deleteFamily(Family familyToDelete);
    void saveFamily(Family familyToSave);
    void loadData(List<Family> families);
}
