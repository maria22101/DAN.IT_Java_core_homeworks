package homework3;

//Не обязательное задание продвинутой сложности - продолжение ДЗ_3:
//Доработайте программу так, чтобы при вводе пользователем фразы change [day of the week] или reschedule [day of the week],
// программа предложила ввести новые задания для данного дня недели и сохранила их в соответствующей ячейке массива,
// удалив при этом старые задания. После чего программа идет на следующую итерацию до ввода exit.

import java.util.Scanner;

import static homework3.Planner.*;

public class PlannerAdvanced {

    public static void getDayTask(String str, String ar[][]) {
        switch (str) {
            case "Sunday":
                System.out.println("Your task for Sunday: " + ar[0][1]);
                break;
            case "Monday":
                System.out.println("Your task for Monday: " + ar[1][1]);
                break;
            case "Tuesday":
                System.out.println("Your task for Thursday: " + ar[2][1]);
                break;
            case "Wednesday":
                System.out.println("Your task for Wednesday: " + ar[3][1]);
                break;
            case "Thursday":
                System.out.println("Your task for Thursday: " + ar[4][1]);
                break;
            case "Friday":
                System.out.println("Your task for Friday: " + ar[5][1]);
                break;
            case "Saturday":
                System.out.println("Your task for Saturday: " + ar[6][1]);
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again.");
        }
    }

    public static String[][] updateSchedule(String userChange, String userSchedule[][]) {
        Scanner scan = new Scanner(System.in);

        switch (userChange) {
            case "change Sunday":
                System.out.print("Please, input new task for Sunday: ");
                userSchedule[0][1] = scan.nextLine();
                break;
            case "change Monday":
                System.out.print("Please, input new task for Monday: ");
                userSchedule[1][1] = scan.nextLine();
                break;
            case "change Tuesday":
                System.out.print("Please, input new task for Tuesday: ");
                userSchedule[2][1] = scan.nextLine();
                break;
            case "change Wednesday":
                System.out.print("Please, input new task for Wednesday: ");
                userSchedule[3][1] = scan.nextLine();
                break;
            case "change Thursday":
                System.out.print("Please, input new task for Thursday: ");
                userSchedule[4][1] = scan.nextLine();
                break;
            case "change Friday":
                System.out.print("Please, input new task for Friday: ");
                userSchedule[5][1] = scan.nextLine();
                break;
            case "change Saturday":
                System.out.print("Please, input new task for Saturday: ");
                userSchedule[6][1] = scan.nextLine();
                break;
            default:
                System.out.print("Input not recognized");
        }
        return userSchedule;
    }

    public static void main(String[] args) {
        String[][] schedule = createArray();
        String day = enterDay();
        String dayUnified = unifyDayEntry(day);

        do {
            if (day.length() <= 9) {
                getDayTask(dayUnified, schedule);
            } else {
                schedule = updateSchedule(day, schedule);
            }

            day = enterDay();
            dayUnified = unifyDayEntry(day);

        } while (!day.equals("exit"));
    }
}
