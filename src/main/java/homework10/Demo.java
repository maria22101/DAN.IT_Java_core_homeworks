package homework10;

public class Demo {
    public static void main(String[] args) {

        Human h = new Human("Mari", "Clair", 1103760000000L);
        System.out.println(h);
        System.out.println(h.describeAge());

        Human adoptedChild = new Human("Lu", "Yong", "20/03/2016", 95);
        System.out.println(adoptedChild);

    }
}
