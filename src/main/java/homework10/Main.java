package homework10;

public class Main {
    public static void main(String[] args) {

        Human h = new Human("Mari", "Clair", 1103760000000L);
        System.out.println(h);
        System.out.println(h.describeAge());

        Human adoptedChild = new Human("Lu", "Yong", "02/03/2016", 95);
        System.out.println(adoptedChild);
    }
}
