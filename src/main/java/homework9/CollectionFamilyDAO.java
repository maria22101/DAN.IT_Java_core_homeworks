package homework9;

import homework8.Family;
import homework8.Human;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> listFam = new ArrayList<>();

    @Override
    public void createFamily(Human m, Human f) {
        Family fam = new Family(m, f);
        listFam.add(fam);
    }

    @Override
    public List<Family> getAllFamilies() {
        return listFam;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < listFam.size()) {
            return listFam.get(index);
        } else return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < listFam.size()) {
            listFam.remove(index);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteFamily(Family f) {
        for (Family fam : listFam) {
            if (fam.equals(f)) {
                listFam.remove(f);
                return true;
            }
        }
        return false;
    }

    @Override
    public void saveFamily(Family f) {
        if (listFam.contains(f)) {
            listFam.set(listFam.indexOf(f), f);
            return;
        }else listFam.add(f);
    }
}
