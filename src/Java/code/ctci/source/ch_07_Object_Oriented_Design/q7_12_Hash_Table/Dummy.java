package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_12_Hash_Table;

@SuppressWarnings("unused")
public class Dummy {
    private final int age;
    private final String name;

    public Dummy(String n, int a) {
        name = n;
        age = a;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }
}
