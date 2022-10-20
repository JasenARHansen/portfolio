package Code.Java.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_12_Hash_Table;

public class Dummy {
    private final String name;
    private final int age;

    public Dummy(String n, int a) {
        name = n;
        age = a;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
