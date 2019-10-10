package homework12;

import java.util.Scanner;

public class Main {
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
                        "Если да - введите номер вопроса, exit для выхода: ");
    }

    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int choice1 = scanner.nextInt();
        int choice2;
        String motherName, motherSurname, fatherName, fatherSurname, boyName, girlName, adoptedName, adoptedSurname;
        int motherBirthYear, motherBirthMonth, motherBirthDay, motherIQ, fatherBirthYear, fatherBirthMonth, fatherBirthDay, fatherIQ;
        int familyID, adoptedBirthYear, adoptedIQ;

        if (choice1 == 3 || choice1 == 4 || choice1 == 5 || choice1 == 6 || choice1 == 7 || choice1 == 8 || choice1 == 9) {
            switch (choice1) {
                case 3:
                    System.out.print("Задайте число: ");
                    choice2 = scanner.nextInt();
                    break;
                case 4:
                    System.out.print("Задайте число: ");
                    choice2 = scanner.nextInt();
                    break;
                case 5:
                    System.out.print("Задайте число: ");
                    choice2 = scanner.nextInt();
                    break;
                case 6:
                    System.out.print("Введите имя матери: ");
                    motherName = scanner.next();
                    System.out.print("Введите фамилию матери: ");
                    motherSurname = scanner.next();
                    System.out.print("Введите год рождения матери: ");
                    motherBirthYear = scanner.nextInt();
                    System.out.print("Введите месяц рождения матери: ");
                    motherBirthMonth = scanner.nextInt();
                    System.out.print("Введите день рождения матери: ");
                    motherBirthDay = scanner.nextInt();
                    System.out.print("Введите iq матери: ");
                    motherIQ = scanner.nextInt();

                    System.out.print("Введите имя отца: ");
                    fatherName = scanner.next();
                    System.out.print("Введите фамилию отца: ");
                    fatherSurname = scanner.next();
                    System.out.print("Введите год рождения отца: ");
                    fatherBirthYear = scanner.nextInt();
                    System.out.print("Введите месяц рождения отца: ");
                    fatherBirthMonth = scanner.nextInt();
                    System.out.print("Введите день рождения отца: ");
                    fatherBirthDay = scanner.nextInt();
                    System.out.print("Введите iq отца: ");
                    fatherIQ = scanner.nextInt();
                case 7:
                    System.out.print("Задайте порядковый номер семьи: ");
                    choice2 = scanner.nextInt();
                    break;
                case 8:
                    System.out.print("Введите номер запроса из приведенных ниже:\n" +
                            "1. Родить ребенка\n" +
                            "2. Усыновить ребенка\n" +
                            "3. Вернуться в главное меню\n");
                    choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.print("Введите порядковый номер семьи: ");
                            familyID = scanner.nextInt();
                            System.out.print("Введите имя мальчика: ");
                            boyName = scanner.next();
                            System.out.print("Введите имя девочки: ");
                            girlName = scanner.next();
                            break;
                        case 2:
                            System.out.print("Введите порядковый номер семьи: ");
                            familyID = scanner.nextInt();
                            System.out.print("Введите имя ребенка которого принимает семья: ");
                            adoptedName = scanner.next();
                            System.out.print("Введите фамилию ребенка которого принимает семья: ");
                            adoptedSurname = scanner.next();
                            System.out.print("Введите год рождения ребенка которого принимает семья: ");
                            adoptedBirthYear = scanner.nextInt();
                            System.out.print("Введите IQ ребенка которого принимает семья: ");
                            adoptedIQ = scanner.nextInt();
                            break;
                        case 3:
                            printMenu();
                            break;
                        default:
                            System.out.print("Неверный ввод");
                    }
                    break;
                case 9:
                    System.out.print("Задайте число: ");
                    choice2 = scanner.nextInt();
                    break;
                default:
                    System.out.print("Неверный ввод");
            }
        }
    }
}
