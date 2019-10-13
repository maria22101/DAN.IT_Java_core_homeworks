package homework12;

import homework8.Species;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

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
        Human f1 = new Human("Ann", "Amber", "01/02/1980", 90);
        Human m1 = new Human("Adam", "Amber", "13/03/1978", 89);
        famController.createNewFamily(f1, m1);

        Human f2 = new Human("Tea", "Taller", "01/02/1990", 80);
        f2.setSchedule(new HashMap<String, String>() {{
            put("SUNDAY", "Jogging");
            put("MONDAY", "Meditation");
        }});
        Human m2 = new Human("Teodor", "Taller", "13/05/1985", 79);
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

        Human f3 = new Human("Nicole", "Nocks", "01/06/1970", 70);
        Human m3 = new Human("Noa", "Nocks", "14/07/1967", 69);
        Set<String> dogHabits = new HashSet<>();
        dogHabits.add("run");
        dogHabits.add("bark");
        Pet pet31 = new Pet(Species.DOG, "Cake", 2, 55, dogHabits);
        Pet pet32 = new Pet(Species.DOG, "Black", 1, 50, dogHabits);
        famController.createNewFamily(f3, m3);
        famController.addPet(2, pet31);
        famController.addPet(2, pet32);
    }

    static Human getValidHuman

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int choiceNumber = 0;
        int choiceNumberSubmenu = 0;
        int number = 0;
        String choiceExit = "programm running";

        String boyName, girlName, adoptedName, adoptedSurname, adoptedBirthYear;
        int familyID, adoptedIQ;

        try {
            choiceNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            try {
                choiceExit = scanner.nextLine();
                if (!choiceExit.equals("exit")) {
                    System.out.println("!!!!! Ввод должен быть число от 1 до 9 или exit");
                }
            } catch (InputMismatchException ex) {
                System.out.println("!!!!! Ввод должен быть число от 1 до 9 или exit");
            }
        }

        while (!choiceExit.equals("exit")) {
            if (choiceNumber == 1) {
                generateTestFamilies();

            } else if (choiceNumber == 2) {
                famController.displayAllFamilies();

            } else if (choiceNumber == 3) {
                System.out.print("Задайте число: ");
                try {
                    number = scanner.nextInt();
                    famController.getFamiliesBiggerThan(number);
                } catch (InputMismatchException e) {
                    try {
                        choiceExit = scanner.nextLine();
                        if (!choiceExit.equals("exit")) {
                            System.out.println("!!!!! Ввод должен быть целое число или exit");
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("!!!!! Ввод должен быть целое число или exit");
                    }
                }

            } else if (choiceNumber == 4) {
                System.out.print("Задайте число: ");
                try {
                    number = scanner.nextInt();
                    famController.getFamiliesLessThan(number);
                } catch (InputMismatchException e) {
                    try {
                        choiceExit = scanner.nextLine();
                        if (!choiceExit.equals("exit")) {
                            System.out.println("!!!!! Ввод должен быть целое число или exit");
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("!!!!! Ввод должен быть целое число или exit");
                    }
                }

            } else if (choiceNumber == 5) {
                System.out.print("Задайте число: ");
                try {
                    number = scanner.nextInt();
                    System.out.println(famController.countFamiliesWithMemberNumber(number));
                } catch (InputMismatchException e) {
                    try {
                        choiceExit = scanner.nextLine();
                        if (!choiceExit.equals("exit")) {
                            System.out.println("!!!!! Ввод должен быть целое число или exit");
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("!!!!! Ввод должен быть целое число или exit");
                    }
                }

            } else if (choiceNumber == 6) {
                try {
                    System.out.print("Введите имя матери (строка): ");
                    if (scanner.nextLine().chars().anyMatch(Character::isDigit))
                        throw new Exception("!!! Введите имя строкой");
                    String motherName = scanner.next();

                    System.out.print("Введите фамилию матери (строка): ");
                    if (scanner.nextLine().chars().anyMatch(Character::isDigit))
                        throw new Exception("!!! Введите фамилию строкой");
                    String motherSurname = scanner.next();

                    System.out.print("Введите год рождения матери (число - четыре цифры): ");
                    String s = scanner.next();
                    if ((!(s.chars().allMatch(Character::isDigit))) || (!(s.chars().count() == 4))) {
                        throw new Exception("Введите год рождения четырьмя цифрами");
                    }
                    String motherBirthYear = s;

                    System.out.print("Введите месяц рождения матери (число от 01 до 12): ");
                    s = scanner.next();
                    if (!(s.chars().allMatch(Character::isDigit)) || !(Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 12)) {
                        throw new Exception("Введите месяц рождения числом от 01 до 12");
                    }
                    String motherBirthMonth = s;

                    System.out.print("Введите день рождения матери (число от 01 до последнего дня месяца): ");
                    s = scanner.next();
                    if (!(s.chars().allMatch(Character::isDigit)) || !(Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 31)) {
                        throw new Exception("Введите день рождения числом от 01 до последнего дня месяца");
                    }
                    String motherBirthDay = s;

                    System.out.print("Введите iq матери (число): ");
                    int motherIQ = scanner.nextInt();

                    System.out.print("Введите имя отца (строка): ");
                    if (scanner.nextLine().chars().anyMatch(Character::isDigit))
                        throw new Exception("!!! Введите имя строкой");
                    String fatherName = scanner.next();

                    System.out.print("Введите фамилию отца (строка): ");
                    if (scanner.nextLine().chars().anyMatch(Character::isDigit))
                        throw new Exception("!!! Введите фамилию строкой");
                    String fatherSurname = scanner.next();

                    System.out.print("Введите год рождения отца (число - четыре цифры): ");
                    s = scanner.next();
                    if ((!(s.chars().allMatch(Character::isDigit))) || (!(s.chars().count() == 4))) {
                        throw new Exception("Введите год рождения четырьмя цифрами");
                    }
                    String fatherBirthYear = s;

                    System.out.print("Введите месяц рождения отца (число от 01 до 12): ");
                    s = scanner.next();
                    if (!(s.chars().allMatch(Character::isDigit)) || !(Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 12)) {
                        throw new Exception("Введите месяц рождения числом от 01 до 12");
                    }
                    String fatherBirthMonth = s;

                    System.out.print("Введите день рождения отца (число от 01 до последнего дня месяца): ");
                    s = scanner.next();
                    if (!(s.chars().allMatch(Character::isDigit)) || !(Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 31)) {
                        throw new Exception("Введите день рождения числом от 01 до последнего дня месяца");
                    }
                    String fatherBirthDay = s;

                    System.out.print("Введите iq отца (число): ");
                    int fatherIQ = scanner.nextInt();

                    String motherBirthDate = motherBirthDay + "/" + motherBirthMonth + "/" + motherBirthYear;
                    String fatherBirthDate = fatherBirthDay + "/" + fatherBirthMonth + "/" + fatherBirthYear;

                    Human newMother = new Human(motherName, motherSurname, motherBirthDate, motherIQ);
                    Human newFather = new Human(fatherName, fatherSurname, fatherBirthDate, fatherIQ);
                    famController.createNewFamily(newMother, newFather);

                } catch (InputMismatchException e) {
                    System.out.println("!!!!! Ввод должен быть целое число");
                } catch (DateTimeParseException e) {
                    System.out.println("!!!!! Проверьте соответствие полей даты рождения запрашиваемым форматам года, месяца, дня");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (choiceNumber == 7) {
                System.out.print("Задайте порядковый номер семьи - целое число больше нуля: ");
                try {
                    familyID = scanner.nextInt();
                    famController.deleteFamilyByIndex(familyID - 1);
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("!!!!! Ввод должен быть целое число больше нуля");
                }

            } else if (choiceNumber == 8) {
                System.out.println("***************");
                System.out.print("Введите номер запроса из приведенных ниже:\n" +
                        "1. Родить ребенка\n" +
                        "2. Усыновить ребенка\n" +
                        "3. Вернуться в главное меню\n");
                try {
                    choiceNumberSubmenu = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("!!!!! Ввод должен быть целое число от 1 до 3");
                }

                if (choiceNumberSubmenu == 1) {
                    Family familyBorningChild = null;
                    System.out.print("Введите порядковый номер семьи: ");
                    try {
                        familyID = scanner.nextInt();
                        familyBorningChild = famController.getFamilyById(familyID - 1);
                        System.out.print("Введите имя мальчика: ");
                        boyName = scanner.next();
                        System.out.print("Введите имя девочки: ");
                        girlName = scanner.next();

                        famController.bornChild(familyBorningChild, girlName, boyName);

                    } catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println("!!!!! Ввод должен быть целое число больше нуля");
                    }

                } else if (choiceNumberSubmenu == 2) {
                    Family familyAdoptingChild = null;
                    Human adoptedChild = null;
                    System.out.print("Введите порядковый номер семьи: ");
                    try {
                        familyID = scanner.nextInt();
                        familyAdoptingChild = famController.getFamilyById(familyID - 1);
                        System.out.print("Введите имя ребенка которого принимает семья - строка: ");
                        adoptedName = scanner.next();
                        System.out.print("Введите фамилию ребенка которого принимает семья - строка: ");
                        adoptedSurname = scanner.next();
                        System.out.print("Введите год рождения ребенка которого принимает семья (число - четыре цифры): ");
                        adoptedBirthYear = scanner.next();
                        System.out.print("Введите IQ ребенка которого принимает семья - целое число больше нуля: ");
                        adoptedIQ = scanner.nextInt();
                        adoptedChild = new Human(adoptedName, adoptedSurname, "01/01/" + adoptedBirthYear, adoptedIQ);

                        famController.adoptChild(familyAdoptingChild, adoptedChild);

                    } catch (InputMismatchException | IndexOutOfBoundsException | DateTimeParseException e) {
                        System.out.println("!!!!! Введите поля для Ребенка следуя запрашиваемым форматам");
                    }
                }

            } else if (choiceNumber == 9) {
                System.out.print("Задайте число: ");
                try {
                    number = scanner.nextInt();
                    famController.deleteAllChildrenOlderThan(number);
                } catch (InputMismatchException e) {
                    System.out.println("!!!!! Ввод должен быть целое число");
                }
            }

            System.out.println("***********************************************************************");

            scanner = new Scanner(System.in);
            printMenu();

            try {
                choiceNumber = scanner.nextInt();
            } catch (InputMismatchException exept) {
                try {
                    choiceExit = scanner.nextLine();
                    if (!choiceExit.equals("exit")) {
                        System.out.println("!!!!! Ввод должен быть число от 1 до 9 или exit !!!!!");
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("!!!!! Ввод должен быть число от 1 до 9 или exit !!!!!");
                }
            }
        }
    }
}

