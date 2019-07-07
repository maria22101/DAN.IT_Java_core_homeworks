package homework2;

//Не обязательное задание продвинутой сложности - продолжение ДЗ_2://
//Доработайте "стрельбу по площади" так, чтобы "цель" занимала 3 клетки (по горизонтали или вертикали),
//а пораженные отсеки отмечались x.

import java.util.Arrays;
import java.util.Random;

import static homework2.AreaShooting.*;

public class AreaShootingAdvanced {

    public static int[][] generateTargetCoordinatesArray() {
        int[][] targetCoordinates = new int[3][2];
        Random rand = new Random();
        int r = rand.nextInt(2); //if 0 - we are setting horizontal target, if 1 - vertical target

        if (r == 0) {
            int horizontal_y = rand.nextInt(5) + 1;
            int horizontal_x = rand.nextInt(5) + 1;
            if (horizontal_x <= 3) {
                targetCoordinates[0][0] = horizontal_y;
                targetCoordinates[0][1] = horizontal_x;

                targetCoordinates[1][0] = horizontal_y;
                targetCoordinates[1][1] = horizontal_x + 1;
                targetCoordinates[2][0] = horizontal_y;
                targetCoordinates[2][1] = horizontal_x + 2;
            } else {
                targetCoordinates[0][0] = horizontal_y;
                targetCoordinates[0][1] = horizontal_x;
                targetCoordinates[1][0] = horizontal_y;
                targetCoordinates[1][1] = horizontal_x - 1;
                targetCoordinates[2][0] = horizontal_y;
                targetCoordinates[2][1] = horizontal_x - 2;
            }
        } else {
            int vertical_x = rand.nextInt(5) + 1;
            int vertical_y = rand.nextInt(5) + 1;
            if (vertical_y <= 3) {
                targetCoordinates[0][0] = vertical_y;
                targetCoordinates[0][1] = vertical_x;
                targetCoordinates[1][0] = vertical_y + 1;
                targetCoordinates[1][1] = vertical_x;
                targetCoordinates[2][0] = vertical_y + 2;
                targetCoordinates[2][1] = vertical_x;
            } else {
                targetCoordinates[0][0] = vertical_y;
                targetCoordinates[0][1] = vertical_x;
                targetCoordinates[1][0] = vertical_y - 1;
                targetCoordinates[1][1] = vertical_x;
                targetCoordinates[2][0] = vertical_y - 2;
                targetCoordinates[2][1] = vertical_x;
            }
        }
        return targetCoordinates;
    }

    private static boolean isGoodShot(int x, int y, int[][] target, int[][] userShots) {
        boolean isHit = false;
        for (int t = 0; t < 3; t++) {
            if (x == target[t][0] && y == target[t][1]) {
                isHit = true;
                break;
            }
        }
        return isHit;
    }

    private static void updateGoodShotsArray(int x, int y, int[][] arr) {
        for (int i = 0; i < 3; i++) {
            if (x == arr[i][0] && y == arr[i][1]) {
                break;
            }
            if (arr[i][0] == 0) {
                arr[i][0] = x;
                arr[i][1] = y;
                break;
            }
        }
    }

    private static boolean isTargetHit(int[][] arr) {
        boolean hit = false;
        if (arr[0][0] != 0 && arr[1][0] != 0 && arr[2][0] != 0) {
            hit = true;
        }
        return hit;
    }

    private static void updateShootingAreaWithMissedShot(int x, int y, String[][] area) {
        area[x][y] = " * |";
    }

    private static void updateShootingAreaWithGoodShot(int x, int y, String[][] area) {
        area[x][y] = " x |";
    }

    public static void printTargetCoordinates(int[][] arr) {
        System.out.println("The target's coordinates are: " + Arrays.deepToString(arr));
    }

    public static void main(String[] args) {
        intro();
        String[][] shootingArea = generateShootingArea();
        printShootingArea(shootingArea);
        int[][] targetArray = generateTargetCoordinatesArray();

        int[][] userGoodShotsArray = new int[3][2];
        int x = 0;
        int y = 0;

        while (!isTargetHit(userGoodShotsArray)) {
            x = chooseShootingLine();
            y = chooseShootingRow();

            while (!isGoodShot(x, y, targetArray, userGoodShotsArray)) {
                updateShootingAreaWithMissedShot(x, y, shootingArea);
                printShootingArea(shootingArea);
                x = chooseShootingLine();
                y = chooseShootingRow();
            }

            updateGoodShotsArray(x, y, userGoodShotsArray);
            updateShootingAreaWithGoodShot(x, y, shootingArea);
            printShootingArea(shootingArea);
        }

        congrats();
        printTargetCoordinates(targetArray);
    }
}
