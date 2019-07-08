package homework4;

public class Main {

    public static void main(String[] args) {
        Human mother1 = new Human("Elise", "Johns", 1970);
        Human grandMa1 = new Human("Ema", "Roberts", 1952);
        Human father1 = new Human("Brian", "Johns", 1971, grandMa1, new Human("Ben", "Johns", 1950));
        Pet cat1 = new Pet("Cat", "Joy");
        Pet dog1 = new Pet("Dog", "Jupiter", 5, 70, new String[]{"chew furniture", "play with children", "eat much"});
        Pet fish1 = new Pet();
        Human child1 = new Human("El", "Johns", 12, 55, dog1, mother1, father1
                , new String[][]{{"Sat", "Swimming"}, {"Sun", "Football"}});

        Human mother2 = new Human("Mia", "Morris", 1980);
        Pet dog2 = new Pet("Dog", "Maestro", 14, 52, new String[]{"sleep all day", "bark loudly"});
        Human grandMa2 = new Human("Mary", "Manson", 1955);
        Human grandPa2 = new Human("Martin", "Morris", 1954);
        Human father2 = new Human("Morgan", "Morris", 1975, 80, dog2, grandMa2, grandPa2
                , new String[][]{
                {"Mo", "Gym"},
                {"Tue", "Theater"},
                {"Wed", "Home work"},
                {"Thu", "Courses"},
                {"Fri", "Party"},
                {"Sat", "Yoga"},
                {"Sun", "Cooking"},
        });
        Human child2 = new Human();
        child2.mother = mother2;
        child2.father = father2;
        child2.pet = dog2;
        child2.describePet();
        child2.greetPet();
        child2.feedPet(false);
        dog2.eat();
        dog2.respond();
        dog2.foul();

        System.out.println();
        System.out.println("======= Family Johns =======");
        System.out.println();
        System.out.println(mother1.toString());
        System.out.println(grandMa1.toString());
        System.out.println(father1.toString());
        System.out.println(cat1.toString());
        System.out.println(dog1.toString());
        System.out.println(fish1.toString());
        System.out.println(child1.toString());

        System.out.println();
        System.out.println("======= Family Morris =======");
        System.out.println();
        System.out.println(mother2.toString());
        System.out.println(dog2.toString());
        System.out.println(grandMa2.toString());
        System.out.println(grandPa2.toString());
        System.out.println(father2.toString());
    }
}
