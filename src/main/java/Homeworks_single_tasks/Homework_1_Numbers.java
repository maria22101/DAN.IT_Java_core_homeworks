package Homeworks_single_tasks;

//Написать программу "числа", которая загадывает случайное число и предлагает игроку его угадать.
//С помощью java.util.Random программа загадывает случайное число в диапазоне [0-100] и предлагает игроку через консоль
//ввести свое имя, которое сохраняется в переменной name.
//Перед началом на экран выводится текст: Let the game begin!.
//Сам процесс игры обрабатывается в бесконечном цикле.
//Игроку предлагается ввести число в консоль, после чего программа сравнивает загаданное число с тем, что ввел пользователь.
//Если введенное число меньше загаданного, то программа выводит на экран текст:
//Your number is too small. Please, try again..
//Если введенное число больше загаданного, то программа выводит на экран текст: c.
//Если введенное число соответствуют загаданному, то программа выводит текст: Congratulations, {name}!.
//Задание должно быть выполнено ипспользуя массивы (НЕ используйте интерфейсы List, Set, Map).

//Не обязательное задание продвинутой сложности:
//
//Перед переходом на следующую итерацию, программа сохраняет введенное пользователем число в массив.
//После того как игрок угадал загаданное число, перед выходом программа выводит на экран текст:
//Your numbers: и показывает все введенные игроком числа, отсортированные от большего к меньшему.
//После ввода чисел пользователем добавить проверку их корректности. Если пользователь ввел не число - спросить заново.

//(даное задание будет реализовано в отдельном классе позже):
//Добавьте игре немного больше смысла: пускай загаданное число будет годом, которому соответствует известное событие.
//Информация о годах хранится в двумерном массиве [год Х событие].
//Программа вначале выбирает случайным образом ячейку в матрице и выводит на экран: When did the World War II begin?.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework_1_Numbers {

    public static int geterateRandomNum() {
        Random rand = new Random();
        int randomNum = rand.nextInt(101);
        return randomNum;
    }

    public static String enterUserName() {
        System.out.print("Enter your name: ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        return userName;
    }

    public static void sayIntro() {
        System.out.println("Let the game begin!");
    }

    public static int enterFirstNumber() {
        System.out.print("Guess an integer number from 0 to 100: ");
        return checkedEntry();
    }

    public static int checkedEntry() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.print("Your entry is not a number. Enter a number from 0 to 100, please: ");
            scan = new Scanner(System.in);
        }
        int userNum = scan.nextInt();
        return userNum;
    }

    public static int enterMoreNumber(int randomNum, int userNum) {
        if (userNum > randomNum) {
            System.out.print("Your number is too big. Please, try again: ");
        } else if (userNum < randomNum) {
            System.out.print("Your number is too small. Please, try again: ");
        }
        return checkedEntry();
    }

    public static void sayCongratulations(String userName) {
        System.out.println("Congratulations, " + userName + " !");
    }

    public static void showUserNumArray(int[] userNumArr) {
        Arrays.sort(userNumArr);
        int[] reverseSortedArr = new int[userNumArr.length];
        for (int i = 0; i < userNumArr.length; i++) {
            reverseSortedArr[i] = userNumArr[userNumArr.length - i - 1];
        }
        System.out.println("Your numbers: " + Arrays.toString(reverseSortedArr));
    }

    public static void main(String[] args) {
        int number = geterateRandomNum();
        String name = enterUserName();

        sayIntro();

        int userNumber = enterFirstNumber();
        int[] arr = new int[100];
        int numCounter = 0;

        while (userNumber != number) {
            userNumber = enterMoreNumber(number, userNumber);
            arr[numCounter++] = userNumber;
        }

        sayCongratulations(name);
        showUserNumArray(Arrays.copyOf(arr, numCounter));
    }
}
