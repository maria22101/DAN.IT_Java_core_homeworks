package homework12;

import homework8.Species;

import java.io.IOException;
import java.util.*;

public class Main {
    static FamilyController famController = new FamilyController();

    static void printMenu() {
        System.out.print(
                "Интересует ли Вас что-либо из нижеперечисленного: \n" +
                        "1. Заполнить тестовыми данными\n" +
                        "2. Отобразить весь список семей\n" +
                        "3. Отобразить список семей, где количество людей больше заданного\n" +
                        "4. Отобразить список семей, где количество людей меньше заданного\n" +
                        "5. Подсчитать количество семей, где количество членов равно заданному\n" +
                        "6. Создать новую семью\n" +
                        "7. Удалить семью по индексу семьи в общем списке\n" +
                        "8. Редактировать семью по индексу семьи в общем списке\n" +
                        "9. Удалить всех детей старше возраста\n" +
                        "Если да - введите номер вопроса от 1 до 9, exit для выхода: ");
    }

    static void generateTestFamilies() {
        Human f1 = new Human("Ann", "Amber", 45);
        Human m1 = new Human("Adam", "Amber", 46);
        famController.createNewFamily(f1, m1);

        Human f2 = new Human("Tea", "Taller", 54);
        f2.setSchedule(new HashMap<String, String>() {{
            put("SUNDAY", "Jogging");
            put("MONDAY", "Meditation");
        }});
        Human m2 = new Human("Teodor", "Taller", 56);
        m2.setSchedule(new HashMap<String, String>() {{
            put("SUNDAY", "Gardening");
            put("MONDAY", "Gym");
        }});
        Set<String> catHabits = new HashSet<>();
        catHabits.add("play");
        catHabits.add("sleep");
        Pet pet2 = new Pet(Species.CAT, "Tigra", 11, 70, catHabits);
        famController.createNewFamily(f2, m2);
        famController.addPet(1, pet2);

        Human f3 = new Human("Nicole", "Nocks", 35);
        Human m3 = new Human("Noa", "Nocks", 36);
        Set<String> dogHabits = new HashSet<>();
        dogHabits.add("run");
        dogHabits.add("bark");
        Pet pet31 = new Pet(Species.DOG, "Cake", 2, 55, dogHabits);
        Pet pet32 = new Pet(Species.DOG, "Black", 1, 50, dogHabits);
        famController.createNewFamily(f3, m3);
        famController.addPet(2, pet31);
        famController.addPet(2, pet32);
    }

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int choiceNumber = 0;
        int choiceNumberSubmenu = 0;
        String choiceExit = "programm running";

        String motherName, motherSurname, motherBirthDate, motherBirthYear, motherBirthMonth, motherBirthDay;
        String fatherName, fatherSurname, fatherBirthDate, fatherBirthYear, fatherBirthMonth, fatherBirthDay;
        String boyName, girlName, adoptedName, adoptedSurname, adoptedBirthYear;
        int motherIQ, fatherIQ, familyID, adoptedIQ;

        try {
            choiceNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            try {
                choiceExit = scanner.nextLine();
            } catch (InputMismatchException ex) {
                if (!choiceExit.equals("exit")) {
                    System.out.println("Ввод должен быть число от 1 до 9 или exit");
                }
            }
            System.out.println("Ввод должен быть число от 1 до 9 или exit");
        }

        while (!choiceExit.equals("exit")) {
            if (choiceNumber == 1) {
                generateTestFamilies();

            } else if (choiceNumber == 2) {
                famController.displayAllFamilies();

            } else if (choiceNumber == 3) {
                System.out.print("Задайте число: ");
                choiceNumberSubmenu = scanner.nextInt();
                famController.getFamiliesBiggerThan(choiceNumberSubmenu);

            } else if (choiceNumber == 4) {
                System.out.print("Задайте число: ");
                choiceNumberSubmenu = scanner.nextInt();
                famController.getFamiliesLessThan(choiceNumberSubmenu);

            } else if (choiceNumber == 5) {
                System.out.print("Задайте число: ");
                choiceNumberSubmenu = scanner.nextInt();
                famController.countFamiliesWithMemberNumber(choiceNumber);

            } else if (choiceNumber == 6) {
                System.out.print("Введите имя матери: ");
                motherName = scanner.next();
                System.out.print("Введите фамилию матери: ");
                motherSurname = scanner.next();
                System.out.print("Введите год рождения матери: ");
                motherBirthYear = scanner.next();
                System.out.print("Введите месяц рождения матери: ");
                motherBirthMonth = scanner.next();
                System.out.print("Введите день рождения матери: ");
                motherBirthDay = scanner.next();
                System.out.print("Введите iq матери: ");
                motherIQ = scanner.nextInt();

                System.out.print("Введите имя отца: ");
                fatherName = scanner.next();
                System.out.print("Введите фамилию отца: ");
                fatherSurname = scanner.next();
                System.out.print("Введите год рождения отца: ");
                fatherBirthYear = scanner.next();
                System.out.print("Введите месяц рождения отца: ");
                fatherBirthMonth = scanner.next();
                System.out.print("Введите день рождения отца: ");
                fatherBirthDay = scanner.next();
                System.out.print("Введите iq отца: ");
                fatherIQ = scanner.nextInt();

                motherBirthDate = motherBirthDay + "/" + motherBirthMonth + "/" + motherBirthYear;
                fatherBirthDate = fatherBirthDay + "/" + fatherBirthMonth + "/" + fatherBirthYear;
                Human newMother = new Human(motherName, motherSurname, motherBirthDate, motherIQ);
                Human newFather = new Human(fatherName, fatherSurname, fatherBirthDate, fatherIQ);
                famController.createNewFamily(newMother, newFather);

            } else if (choiceNumber == 7) {
                System.out.print("Задайте порядковый номер семьи: ");
                choiceNumberSubmenu = scanner.nextInt();
                famController.deleteFamilyByIndex(choiceNumberSubmenu);

            } else if (choiceNumber == 8) {
                System.out.println("***************");
                System.out.print("Введите номер запроса из приведенных ниже:\n" +
                        "1. Родить ребенка\n" +
                        "2. Усыновить ребенка\n" +
                        "3. Вернуться в главное меню\n");
                choiceNumberSubmenu = scanner.nextInt();

                if (choiceNumberSubmenu == 1) {
                    System.out.print("Введите порядковый номер семьи: ");
                    familyID = scanner.nextInt();
                    Family familyBorningChild = famController.getFamilyById(familyID);
                    System.out.print("Введите имя мальчика: ");
                    boyName = scanner.next();
                    System.out.print("Введите имя девочки: ");
                    girlName = scanner.next();
                    famController.bornChild(familyBorningChild, girlName, boyName);

                } else if (choiceNumberSubmenu == 2) {
                    System.out.print("Введите порядковый номер семьи: ");
                    familyID = scanner.nextInt();
                    System.out.print("Введите имя ребенка которого принимает семья: ");
                    adoptedName = scanner.next();
                    System.out.print("Введите фамилию ребенка которого принимает семья: ");
                    adoptedSurname = scanner.next();
                    System.out.print("Введите год рождения ребенка которого принимает семья: ");
                    adoptedBirthYear = scanner.next();
                    System.out.print("Введите IQ ребенка которого принимает семья: ");
                    adoptedIQ = scanner.nextInt();
                    Family familyAdoptingChild = famController.getFamilyById(familyID);
                    Human adoptedChild = new Human(adoptedName, adoptedSurname, "01/01/" + adoptedBirthYear, adoptedIQ);
                    famController.adoptChild(familyAdoptingChild, adoptedChild);

                } else if (choiceNumberSubmenu == 3) {
                    System.out.println("***********************************************************************");

                    printMenu();

                    try {
                        choiceNumber = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        try {
                            choiceExit = scanner.nextLine();
                        } catch (InputMismatchException ex) {
                            if (!choiceExit.equals("exit")) {
                                System.out.println("Ввод должен быть число от 1 до 9 или exit");
                            }
                        }
                        System.out.println("Ввод должен быть число от 1 до 9 или exit");
                    }
                    continue;
                }
            } else if (choiceNumber == 9) {
                System.out.print("Задайте число: ");
                choiceNumberSubmenu = scanner.nextInt();
                famController.deleteAllChildrenOlderThan(choiceNumberSubmenu);
            }

            System.out.println("***********************************************************************");

            printMenu();

            try {
                choiceNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                try {
                    choiceExit = scanner.nextLine();
                } catch (InputMismatchException ex) {
                    if (!choiceExit.equals("exit")) {
                        System.out.println("Ввод должен быть число от 1 до 9 или exit");
                    }
                }
                System.out.println("Ввод должен быть число от 1 до 9 или exit");
            }
        }
    }
}
