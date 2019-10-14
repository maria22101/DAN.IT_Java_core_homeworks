package homework12;

import homework8.Species;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    static FamilyController familyController = new FamilyController();

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
                        "10. Записать список семей на диск\n" +
                        "11. Загрузить список ранее записанных семей с диска в консоль\n" +
                        "Если да - введите номер вопроса от 1 до 9, exit для выхода: ");
    }

    static void generateTestFamilies() {
        Human female1 = new Human("Ann", "Amber", "01/02/1980", 90);
        Human male1 = new Human("Adam", "Amber", "13/03/1978", 89);
        familyController.createNewFamily(female1, male1);

        Human female2 = new Human("Tea", "Taller", "01/02/1990", 80);
        female2.setSchedule(new HashMap<String, String>() {{
            put("SUNDAY", "Jogging");
            put("MONDAY", "Meditation");
        }});
        Human male2 = new Human("Teodor", "Taller", "13/05/1985", 79);
        male2.setSchedule(new HashMap<String, String>() {{
            put("SUNDAY", "Gardening");
            put("MONDAY", "Gym");
        }});
        Set<String> catHabits = new HashSet<>();
        catHabits.add("play");
        catHabits.add("sleep");
        Pet pet2 = new Pet(Species.CAT, "Tigra", 11, 70, catHabits);
        familyController.createNewFamily(female2, male2);
        familyController.addPet(1, pet2);

        Human female3 = new Human("Nicole", "Nocks", "01/06/1970", 70);
        Human male3 = new Human("Noa", "Nocks", "14/07/1967", 69);
        Set<String> dogHabits = new HashSet<>();
        dogHabits.add("run");
        dogHabits.add("bark");
        Pet pet31 = new Pet(Species.DOG, "Cake", 2, 55, dogHabits);
        Pet pet32 = new Pet(Species.DOG, "Black", 1, 50, dogHabits);
        familyController.createNewFamily(female3, male3);
        familyController.addPet(2, pet31);
        familyController.addPet(2, pet32);
    }

    static Human getValidHuman(String familyMember) {
        Human validHuman = null;
        Scanner scanner = new Scanner(System.in);
        String input;

        try {
            System.out.printf("Введите имя для члена семьи %s (строка): ", familyMember);
            input = scanner.next();
            if (input.chars().anyMatch(Character::isDigit))
                throw new Exception("!!! Введите имя строкой");
            String name = input;

            System.out.printf("Введите фамилию для члена семьи %s (строка): ", familyMember);
            input = scanner.next();
            if (input.chars().anyMatch(Character::isDigit))
                throw new Exception("!!! Введите фамилию строкой");
            String surname = input;

            System.out.printf("Введите год рождения для члена семьи %s (число - четыре цифры): ", familyMember);
            input = scanner.next();
            if ((!(input.chars().allMatch(Character::isDigit))) || (!(input.chars().count() == 4))) {
                throw new Exception("Введите год рождения четырьмя цифрами");
            }
            String birthYear = input;

            System.out.printf("Введите месяц рождения для члена семьи %s (число от 01 до 12): ", familyMember);
            input = scanner.next();
            if (!(input.chars().allMatch(Character::isDigit)) || !(Integer.valueOf(input) > 0 && Integer.valueOf(input) <= 12)) {
                throw new Exception("Введите месяц рождения числом от 01 до 12");
            }
            String birthMonth = input;

            System.out.printf("Введите день рождения для члена семьи %s (число от 01 до последнего дня месяца): ", familyMember);
            input = scanner.next();
            if (!(input.chars().allMatch(Character::isDigit)) || !(Integer.valueOf(input) > 0 && Integer.valueOf(input) <= 31)) {
                throw new Exception("Введите день рождения числом от 01 до последнего дня месяца");
            }
            String birthDay = input;

            System.out.printf("Введите iq для члена семьи %s (число): ", familyMember);
            int iQ = scanner.nextInt();

            String fullBirthDate = birthDay + "/" + birthMonth + "/" + birthYear;

            validHuman = new Human(name, surname, fullBirthDate, iQ);

        } catch (InputMismatchException e) {
            System.out.println("!!! Ввод должен быть целое число");
        } catch (DateTimeParseException e) {
            System.out.println("!!! Проверьте соответствие полей даты рождения запрашиваемым форматам");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return validHuman;
    }

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int choiceNumber = 0;
        int choiceNumberSubmenu = 0;
        int number;
        String choiceExit = "program running";

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
                familyController.displayAllFamilies();

            } else if (choiceNumber == 3) {
                System.out.print("Задайте число: ");
                try {
                    number = scanner.nextInt();
                    familyController.getFamiliesBiggerThan(number);
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
                    familyController.getFamiliesLessThan(number);
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
                    System.out.println(familyController.countFamiliesWithMemberNumber(number));
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
                    Human newMother = getValidHuman("мать");
                    if (newMother == null)
                        throw new Exception("!!! Создание члена семьи не удалось. Повторите попытку следуя инструкциям ввода");
                    Human newFather = getValidHuman("отец");
                    if (newFather == null)
                        throw new Exception("!!! Создание члена семьи не удалось. Повторите попытку следуя инструкциям ввода");
                    familyController.createNewFamily(newMother, newFather);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (choiceNumber == 7) {
                System.out.print("Задайте порядковый номер семьи - целое число больше нуля: ");
                try {
                    int familyID = scanner.nextInt();
                    familyController.deleteFamilyByIndex(familyID - 1);
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
                        int familyID = scanner.nextInt();
                        familyBorningChild = familyController.getFamilyById(familyID - 1);
                        System.out.print("Введите имя мальчика: ");
                        String boyName = scanner.next();
                        System.out.print("Введите имя девочки: ");
                        String girlName = scanner.next();

                        familyController.bornChild(familyBorningChild, girlName, boyName);

                    } catch (InputMismatchException | IndexOutOfBoundsException e) {
                        System.out.println("!!!!! Ввод должен быть целое число больше нуля");
                    }

                } else if (choiceNumberSubmenu == 2) {
                    Family familyAdoptingChild = null;
                    Human adoptedChild = null;
                    System.out.print("Введите порядковый номер семьи: ");
                    try {
                        int familyID = scanner.nextInt();
                        familyAdoptingChild = familyController.getFamilyById(familyID - 1);
                        adoptedChild = getValidHuman("приемный ребенок");

                        familyController.adoptChild(familyAdoptingChild, adoptedChild);

                    } catch (InputMismatchException | IndexOutOfBoundsException |
                            DateTimeParseException | NullPointerException e) {
                        System.out.println("!!!!! Введите поля для ребенка следуя запрашиваемым форматам");
                    }
                }

            } else if (choiceNumber == 9) {
                System.out.print("Задайте число: ");
                try {
                    number = scanner.nextInt();
                    familyController.deleteAllChildrenOlderThan(number);
                } catch (InputMismatchException e) {
                    System.out.println("!!!!! Ввод должен быть целое число");
                }

            } else if (choiceNumber == 10) {
                familyController.loadData();

            } else if (choiceNumber == 11) {
                Path path = Paths.get("C:/Users/HP/IdeaProjects/Java Core/DAN.IT_Java_core_homeworks/src/main/java/homework13/families_list.txt");

                try {
                    System.out.println(new String(Files.readAllBytes(path)));
                } catch (IOException e) {
                    System.out.println("Ошибка вывода");
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

