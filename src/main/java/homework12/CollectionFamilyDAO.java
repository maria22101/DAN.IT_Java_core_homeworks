package homework12;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> listFamily = new ArrayList<>();

    @Override
    public void createFamily(Human female, Human male) {
        Family fam = new Family(female, male);
        listFamily.add(fam);
    }

    @Override
    public List<Family> getAllFamilies() {
        return listFamily;
    }

    @Override
    public Family getFamilyByIndex(int familyToGetIndex) {
        if (familyToGetIndex < listFamily.size()) {
            return listFamily.get(familyToGetIndex);
        } else return null;
    }

    @Override
    public boolean deleteFamily(int familyToDeleteIndex) {
        if (familyToDeleteIndex < listFamily.size()) {
            listFamily.remove(familyToDeleteIndex);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteFamily(Family familyToDelete) {
        for (Family fam : listFamily) {
            if (fam.equals(familyToDelete)) {
                listFamily.remove(familyToDelete);
                return true;
            }
        }
        return false;
    }

    @Override
    public void saveFamily(Family familyToSave) {
        if (listFamily.contains(familyToSave)) {
            listFamily.set(listFamily.indexOf(familyToSave), familyToSave);
            return;
        }else listFamily.add(familyToSave);
    }

    @Override
    public void loadData(List<Family> families) {
        Path path = Paths.get("C:/Users/HP/IdeaProjects/Java Core/DAN.IT_Java_core_homeworks/src/main/java/homework13/families_list.txt");
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.out.println("Запись в созданный файл");
        }
         catch (IOException e) {
             System.out.println("Создание файла не удалось");;
         }

        for (Family family : listFamily) {
            try{
                Files.write(path, family.prettyFormat().getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e){
                System.out.println("Запись не удалась");
            }
        }
    }
}
