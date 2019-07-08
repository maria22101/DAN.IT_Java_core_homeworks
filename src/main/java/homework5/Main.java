package homework5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) { //some methods of class Family check

        Family fam = new Family(new Human(), new Human());
        Human ch1 = new Human("Ann", "Brett", 20);
        Human ch2 = new Human("Alice", "Brett", 30);
        Human ch3 = new Human("Alex", "Brett", 1);
        System.out.println(Arrays.toString(fam.getChildren()));

        fam.setChildren(new Human[]{ch1, ch2});
        System.out.println(Arrays.toString(fam.getChildren()));

        fam.addChild(ch3);
        System.out.println(Arrays.toString(fam.getChildren()));

        fam.deleteChild(1);
        System.out.println(Arrays.toString(fam.getChildren()));

        fam.deleteChild(ch1);
        System.out.println(Arrays.toString(fam.getChildren()));

        System.out.println(fam.countFamily());

    }
}
