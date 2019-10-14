package homework12;

import java.util.*;
import java.util.stream.Collectors;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        pet = new HashSet<>();
    }

    public void addChild(Human newChild) {
        children.add(newChild);
        newChild.setFamily(this);
    }

    public boolean deleteChild(int index) {
        boolean flag = false;
        if (index < children.size()) {
            children.remove(index);
            flag = true;
        }
        return flag;
    }

    public boolean deleteChild(Human ch) {
        boolean flag = false;

        if (children.contains(ch)) {
            children.remove(ch);
            flag = true;
        }

        return flag;
    }

    public int countFamily() {
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return family.getMother().equals(mother) &&
                family.getFather().equals(father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, pet);
    }

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

    public String prettyFormat() {
        String parentsInPrettyFormat = new StringJoiner("\n")
                .add("family:")
                .add("        mother: " + mother.prettyFormat())
                .add("        father: " + father.prettyFormat())
                .toString();

        StringJoiner sj1 = new StringJoiner("\n").add("        children: ");
        for (Human ch : children) {
            if (ch instanceof Man) {
                sj1 = sj1.add("                boy: " + ch.prettyFormat());
            } else if (ch instanceof Woman){
                sj1 = sj1.add("                girl: " + ch.prettyFormat());
            } else {
                sj1 = sj1.add("                child: " + ch.prettyFormat());
            }
        }
        String childrenInPrettyFormat = sj1.toString();

        StringJoiner sj2 = new StringJoiner("").add("        pets:   ");
            String petString = pet
                    .stream()
                    .map(Pet::prettyFormat)
                    .collect(Collectors.joining(", ","[","]"));
        String petsInPrettyFormat = sj2.add(petString).toString();

        if (!children.isEmpty() && !pet.isEmpty()) {
            return "----------------------------" + "\n" + parentsInPrettyFormat + "\n" + childrenInPrettyFormat +
                    "\n" + petsInPrettyFormat + "\n";
        } else if (!children.isEmpty()) {
            return "----------------------------" + "\n" + parentsInPrettyFormat + "\n" + childrenInPrettyFormat + "\n";
        } else if (!pet.isEmpty()) {
            return "----------------------------" + "\n" + parentsInPrettyFormat + "\n" + petsInPrettyFormat + "\n";
        } else return "----------------------------" + "\n" + parentsInPrettyFormat + "\n";
    }
}
