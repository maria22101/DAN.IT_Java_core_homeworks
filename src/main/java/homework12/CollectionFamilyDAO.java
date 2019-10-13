package homework12;

import homework12.Family;
import homework12.Human;
import homework12.FamilyDAO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    @Override
    public void loadData(List<Family> families) {
        Path path = Paths.get("C:/Users/HP/IdeaProjects/Java Core/DAN.IT_Java_core_homeworks/src/main/java/homework13/families.txt");
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Family family : listFam) {
            try{
                Files.write(path, family.prettyFormat().getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
