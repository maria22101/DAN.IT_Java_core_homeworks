package homework9;

import homework8.Family;
import homework8.Human;

import java.util.List;

public interface FamilyDAO {
    void createFamily(Human m, Human f);
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family f);
    void saveFamily(Family f);
}
