package homework9;

import homework8.Family;
import homework8.Human;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> listFam = new ArrayList<>();

    @Override
    public void createFamily(Human female, Human male) {
        Family fam = new Family(female, male);
        listFam.add(fam);
    }

    @Override
    public List<Family> getAllFamilies() {
        return listFam;
    }

    @Override
    public Family getFamilyByIndex(int familyToGetIndex) {
        if (familyToGetIndex < listFam.size()) {
            return listFam.get(familyToGetIndex);
        } else return null;
    }

    @Override
    public boolean deleteFamily(int familyToDeleteIndex) {
        if (familyToDeleteIndex < listFam.size()) {
            listFam.remove(familyToDeleteIndex);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteFamily(Family familyToDelete) {
        for (Family fam : listFam) {
            if (fam.equals(familyToDelete)) {
                listFam.remove(familyToDelete);
                return true;
            }
        }
        return false;
    }

    @Override
    public void saveFamily(Family familyToSave) {
        if (listFam.contains(familyToSave)) {
            listFam.set(listFam.indexOf(familyToSave), familyToSave);
            return;
        }else listFam.add(familyToSave);
    }
}
