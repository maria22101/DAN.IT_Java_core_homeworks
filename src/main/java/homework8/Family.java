package homework8;

import java.util.*;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

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
        List<Human> children = new ArrayList<>();
    }

    void addChild(Human newChild) {
        children.add(newChild);
        newChild.setFamily(this);
    }

    boolean deleteChild(int index) {
        boolean flag = false;
        if(index < children.size()) {
            children.remove(index);
            flag = true;
        }
        return flag;
    }

    boolean deleteChild(Human ch) {
        boolean flag = false;

        if (children.contains(ch)) {
            children.remove(ch);
            flag = true;
        }

//        for (Human elem : children) { // why this code is not working?
//            if (elem.equals(ch)){
//                children.remove(ch);
//                flag = true;
//            }
//        }

        return flag;
    }

    int countFamily() {
        return 2 + children.size();
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children +
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
        return (children.size() == family.children.size()) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, pet);
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