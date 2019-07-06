package homework3;

import java.util.Scanner;

public class Planner {

    private static String[][] createArray() {
        String[][] weekSchedule = new String[7][2];

        weekSchedule[0][0] = "Sunday";
        weekSchedule[0][1] = "Family Day";

        weekSchedule[1][0] = "Monday";
        weekSchedule[1][1] = "Office work";

        weekSchedule[2][0] = "Tuesday";
        weekSchedule[2][1] = "Trip to Lviv";

        weekSchedule[3][0] = "Wednesday";
        weekSchedule[3][1] = "Teem Meeting Lviv";

        weekSchedule[4][0] = "Thursday";
        weekSchedule[4][1] = "Gym";

        weekSchedule[5][0] = "Friday";
        weekSchedule[5][1] = "Meet Friends";

        weekSchedule[6][0] = "Saturday";
        weekSchedule[6][1] = "Programming course, Homework";

        return weekSchedule;
    }

    private static String enterDay() {
        System.out.print("Enter a day of week: ");
        Scanner scan = new Scanner(System.in);
        String userEntry = scan.nextLine();
        return userEntry;
    }

    private static String dayBeautified(String userEntry) {
        return userEntry.trim().substring(0, 1).toUpperCase() + userEntry.trim().substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        String[][] arr = createArray();
        String day;

        do {
            day = dayBeautified(enterDay());
            switch (day) {
                case "Sunday":
                    System.out.println(arr[0][1]);
                    break;
                case "Monday":
                    System.out.println(arr[1][1]);
                    break;
                case "Tuesday":
                    System.out.println(arr[2][1]);
                    break;
                case "Wednesday":
                    System.out.println(arr[3][1]);
                    break;
                case "Thursday":
                    System.out.println(arr[4][1]);
                    break;
                case "Friday":
                    System.out.println(arr[5][1]);
                    break;
                case "Saturday":
                    System.out.println(arr[6][1]);
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }
        } while (day.equals("exit"));
    }

}
