package homework2;

//Дан квадрат 5х5, где программа случайным образом ставит цель.
//Перед началом игры на экран выводится текст: All set. Get ready to rumble!.
//Сам процесс игры обрабатывается в бесконечном цикле.
//Игроку предлагается ввести линию для стрельбы; программа проверяет что бьло введено число,
// и введенная линия находится в границах игрового поля (1-5). В случае, если игрок ошибся предлагает ввести число еще раз.
//Игроку предлагается ввести столбик для стрельбы (должен проходить аналогичную проверку).
//После каждого выстрела необходимо отображать обновленное игровое поле в консоли.
// Клетки, куда игрок уже стрелял, необходимо отметить как *.
//Игра заканчивается при поражении цели. В конце игры вывести в консоль фразу You have won!, а также игровое поле.
// Пораженную цель отметить как x.
//Задание должно быть выполнено ипспользуя массивы (НЕ используйте интерфейсы List, Set, Map).

//Не обязательное задание продвинутой сложности:
//
//        Доработайте "стрельбу по площади" так, чтобы "цель" занимала 3 клетки (по горизонтали или вертикали),
//        а пораженные отсеки отмечались x.

import java.util.Random;
import java.util.Scanner;

public class AreaShooting {

    public static void intro() {
        System.out.println("All set. Get ready to rumble!");
    }

    public static String[][] generateShootingArea() {
        String[][] area = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0) {
                    area[i][j] = j + " | ";
                } else if (j == 0) {
                    area[i][j] = i + " |";
                } else {
                    area[i][j] = " - |";
                }
            }
        }
        return area;
    }

    public static void printShootingArea(String[][] area) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j != 5) {
                    System.out.print(area[i][j]);
                } else {
                    System.out.println(area[i][j]);
                }
            }
        }
    }

    public static int setTargetLine() {
        Random rand = new Random();
        return rand.nextInt(4) + 1;
    }

    public static int setTargetRow() {
        Random rand = new Random();
        return rand.nextInt(4) + 1;
    }

    public static int chooseShootingLine() {
        System.out.print("Enter a number for the shooting line from 1 to 5: ");
        return checkedEntry();
    }

    public static int chooseShootingRow() {
        System.out.print("Enter a number for the shooting row from 1 to 5: ");
        return checkedEntry();
    }

    public static int checkedEntry() {
        Scanner scan = new Scanner(System.in);
        int entry;

        if (!scan.hasNextInt()) {
            System.out.print("Your entry is invalid. Enter a number from 1 to 5 once more, this is your LAST try: ");
            scan = new Scanner(System.in);
            entry = scan.nextInt();
        } else {
            entry = scan.nextInt();
            if (entry < 1 || entry > 5) {
                System.out.print("Your entry is invalid. Enter a number from 1 to 5 once more, this is your LAST try: ");
                scan = new Scanner(System.in);
                entry = scan.nextInt();
            }
        }
        return entry;
    }

    public static void displayMissedShot(int missedX, int missedY, String[][] area) {
        area[missedX][missedY] = " * |";
        printShootingArea(area);
    }

    public static void displayTarget(int targetX, int targetY, String[][] area) {
        area[targetX][targetY] = " x |";
        printShootingArea(area);
    }

    public static void congrats() {
        System.out.println("You have won!");
    }

    public static void main(String[] args) {
        intro();
        String[][] shootingArea = generateShootingArea();
        printShootingArea(shootingArea);

        int x = setTargetLine();
        int y = setTargetRow();
        int userX = chooseShootingLine();
        int userY = chooseShootingRow();

        while (userX != x || userY != y) {
            displayMissedShot(userX, userY, shootingArea);
            userX = chooseShootingLine();
            userY = chooseShootingRow();
        }

        congrats();
        displayTarget(userX, userY, shootingArea);
    }
}
