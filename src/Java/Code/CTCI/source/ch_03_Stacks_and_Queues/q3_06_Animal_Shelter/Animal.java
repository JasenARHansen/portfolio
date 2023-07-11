package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_06_Animal_Shelter;

public abstract class Animal {
  protected final String name;
  private int order;

  public Animal(String n) {
    name = n;
  }

  public abstract String name();

  public boolean isOlderThan(Animal a) {
    return this.order < a.getOrder();
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int ord) {
    order = ord;
  }
}
