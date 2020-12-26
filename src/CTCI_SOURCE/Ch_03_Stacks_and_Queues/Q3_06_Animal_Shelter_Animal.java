package CTCI_SOURCE.Ch_03_Stacks_and_Queues;

public abstract class Q3_06_Animal_Shelter_Animal {
    protected String name;
    private int order;

    public Q3_06_Animal_Shelter_Animal(String n) {
        name = n;
    }

    public abstract String name();

    public int getOrder() {
        return order;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public boolean isOlderThan(Q3_06_Animal_Shelter_Animal a) {
        return this.order < a.getOrder();
    }
}
