package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_06_Animal_Shelter;

public class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }

    public String name() {
        return "Dog: " + name;
    }

    @Override
    public String toString() {
        return String.format("(Dog: %s)", this.name);
    }
}
