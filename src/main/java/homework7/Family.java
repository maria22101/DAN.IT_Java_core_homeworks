package homework7;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    static {
        System.out.println("New class Family being loaded...");
    }

    {
        System.out.println("New object of Family type being created");
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
        Human[] children = new Human[0];
    }

    void addChild(Human newChild) {
        Human[] newArray;

        if (children != null) {
            newArray = new Human[children.length + 1];
            for (int i = 0; i < children.length; i++) {
                newArray[i] = children[i];
            }
            newArray[children.length] = newChild;
        } else {
            newArray = new Human[]{newChild};
        }

        children = newArray;
        newChild.setFamily(this);
    }

    boolean deleteChild(int index) {
        boolean flag = false;

        for (int i = 0; i < children.length; i++) {
            if (i == index) {
                flag = true;
                break;
            }
        }

        if (flag == true) {
            boolean isRemoved = false;
            Human[] newArray = new Human[children.length - 1];

            for (int i = 0; i < children.length - 1; i++) {
                if (i != index && isRemoved == false) {
                    newArray[i] = children[i];
                } else if (i == index && isRemoved == false) {
                    newArray[i] = children[i + 1];
                    children[i].setFamily(null);
                    isRemoved = true;
                } else {
                    newArray[i] = children[i + 1];
                }
            }

            children = newArray;
        }
        return flag;
    }

    boolean deleteChild(Human ch) {
        boolean flag = false;

        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(ch)) {
                flag = true;
                break;
            }
        }

        if (flag == true) {
            boolean isRemoved = false;
            Human[] newArray = new Human[children.length - 1];

            for (int i = 0; i < children.length - 1; i++) {
                if (!children[i].equals(ch) && isRemoved == false) {
                    newArray[i] = children[i];
                } else if (children[i].equals(ch) && isRemoved == false) {
                    newArray[i] = children[i + 1];
                    children[i].setFamily(null);
                    isRemoved = true;
                } else {
                    newArray[i] = children[i + 1];
                }
            }

            children = newArray;
        }

        return flag;
    }

    int countFamily() {
        int count = 2;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                count++;
            }
        }
        return count;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString() + "is being deleted...");
        ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return (children.length == family.children.length) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public Human bornChild() {
        String[] maleNames = new String[]{"Alex", "John", "Tom", "Adam", "Juan", "Leon"};
        String[] femaleNames = new String[]{"Ann", "Joy", "Tea", "Alice", "Jess", "Lea"};
        Human newChild;
        String name;

        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            newChild = new Man();
            name = maleNames[rand.nextInt(6)];
        } else {
            newChild = new Woman();
            name = femaleNames[rand.nextInt(6)];
        }

        newChild.setName(name);
        newChild.setFamily(this);
        newChild.setSurname(this.getFather().getSurname());
        newChild.setiQ((this.getFather().getiQ() + this.getMother().getiQ()) / 2);

        return newChild;
    }
}
