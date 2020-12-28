package CTCI_SOURCE.other.Introduction.Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter;

public abstract class Animal {
    protected String name;
    private int order;

    public Animal(String n) {
        name = n;
    }

    public abstract String name();

    public int getOrder() {
        return order;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}
