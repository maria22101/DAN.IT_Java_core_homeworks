package homework1;

//Не обязательное задание продвинутой сложности (продолжение ДЗ_1):
//Добавьте игре немного больше смысла: пускай загаданное число будет годом, которому соответствует известное событие.
//Информация о годах хранится в двумерном массиве [год Х событие].
//Программа вначале выбирает случайным образом ячейку в матрице и выводит на экран: When did the World War II begin?.

import java.util.Random;
import java.util.Scanner;

import static homework1.RandomNumbers.*;

public class RandNumAdvanced {

    public static String[][] genrateEventArray() {
        String[][] events = {
                {"1939", "the World War II begin"},
                {"1776", "the USA became independent"},
                {"1991", "Ukraine became independent"},
                {"1945", "the World War II end"},
        };
        return events;
    }

    public static String generateRandomEventYear(String[][] arr) {
        Random rand = new Random();
        String year = arr[rand.nextInt(4)][0];
        return year;
    }

    public static void askEventYear(String st, String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i][0]).equals(st)) {
                System.out.print("When did " + arr[i][1] + "? ");
            }
        }
    }

    public static String giveAnswer() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.print("Your entry is not a year. Enter a year once more, please: ");
            scan = new Scanner(System.in);
        }
        int answer = scan.nextInt();
        return String.valueOf(answer);
    }

    public static void giveIncorrectAnswerMessage(){
        System.out.println("Incorrect answer. Please, try again.");
    }

    public static void sayCongrats(String userName) {
        System.out.println("Congratulations, " + userName + ", you are right!");
    }

    public static void main(String[] args) {

        String name = enterUserName();
        sayIntro();

        String[][] eventArray = genrateEventArray();
        String year = generateRandomEventYear(eventArray);

        askEventYear(year, eventArray);
        String answer = giveAnswer();

        while (!answer.equals(year)) {
            giveIncorrectAnswerMessage();
            askEventYear(year, eventArray);
            answer = giveAnswer();
        }

        sayCongrats(name);
    }
}
