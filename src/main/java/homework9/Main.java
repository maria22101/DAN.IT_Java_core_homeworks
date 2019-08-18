package homework9;

import homework8.DomesticCat;
import homework8.Family;
import homework8.Human;
import homework8.Pet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Human f1 = new Human("Ann", "Amber", 45);
        Human m1 = new Human("Adam", "Amber", 46);
        Human adopted1 = new Human("Alan", "Davis", 16);

        Human f2 = new Human("Tea", "Taller", 54);
        Human m2 = new Human("Teodor", "Taller", 56);
        Human adopted2 = new Human("Tom", "McQuinn", 6);
        Set<String> catHabits = new HashSet<>();
        catHabits.add("play");
        catHabits.add("sleep");
        Pet pet2 = new DomesticCat("Tigra", 11, 70, catHabits);

        Human f3 = new Human("Nicole", "Nocks", 35);
        Human m3 = new Human("Noa", "Nocks", 36);
        Human adopted3 = new Human("Nill", "Fergus", 17);
        Pet pet31 = new DomesticCat("Cake", 2, 55, catHabits);
        Pet pet32 = new DomesticCat("Black", 1, 50, catHabits);

        FamilyController famController = new FamilyController();

        famController.createNewFamily(f1, m1);
        famController.createNewFamily(f2, m2);
        famController.createNewFamily(f3, m3);

        System.out.println("====all families====");
        System.out.println(famController.getAllFamilies());
        System.out.println();

        System.out.println("====families listed====");
        famController.displayAllFamilies();
        System.out.println();

        System.out.println("====families got by id from families' list====");
        Family fam1 = famController.getFamilyById(0);
        Family fam2 = famController.getFamilyById(1);
        Family fam3 = famController.getFamilyById(2);
        System.out.println(fam1.toString());
        System.out.println(fam2.toString());
        System.out.println(fam3.toString());
        System.out.println();

        System.out.println("====families after children birth====");
        famController.bornChild(fam1, "Alice", "Alex");
        famController.bornChild(fam1, "Ann", "Alexander");
        famController.bornChild(fam2, "Tais", "Tim");
        famController.bornChild(fam3, "Nea", "Nick");
        System.out.println(fam1.toString());
        System.out.println(fam2.toString());
        System.out.println(fam3.toString());
        System.out.println();

        System.out.println("====families after children adoption====");
        famController.adoptChild(fam1, adopted1);
        famController.adoptChild(fam2, adopted2);
        famController.adoptChild(fam3, adopted3);
        System.out.println(fam1.toString());
        System.out.println(fam2.toString());
        System.out.println(fam3.toString());
        System.out.println();

        System.out.println("====families with more than 4 members====");
        famController.getFamiliesBiggerThan(4);
        System.out.println();

        System.out.println("====families with less than 5 members====");
        famController.getFamiliesLessThan(5);
        System.out.println();

        System.out.println("====number of families with 4 members====");
        System.out.println(famController.countFamiliesWithMemberNumber(4) + " families");
        System.out.println();

        System.out.println("====children older than 16 left their families====");
        famController.deleteAllChildrenOlderThen(16);
        famController.displayAllFamilies();
        System.out.println();

        System.out.println("====number of families in the list====");
        System.out.println(famController.count() + " families in the list");
        System.out.println();

        System.out.println("====families after pets are taken====");
        famController.addPet(1, pet2);
        famController.addPet(2, pet31);
        famController.addPet(2, pet32);
        famController.displayAllFamilies();
        System.out.println();

        System.out.println("====pets of the families====");
        System.out.println(famController.getPets(0));
        System.out.println(famController.getPets(1));
        System.out.println(famController.getPets(2));
        System.out.println();

        System.out.println("====a family deleted====");
        famController.deleteFamilyByIndex(1);
        famController.displayAllFamilies();
        System.out.println();
    }
}
