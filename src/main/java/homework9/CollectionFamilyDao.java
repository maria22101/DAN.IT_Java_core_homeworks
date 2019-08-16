package homework9;

import homework8.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> listFam = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return null;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        return false;
    }

    @Override
    public boolean deleteFamily(Family f) {
        return false;
    }

    @Override
    public void saveFamily(Family f) {

    }
}
