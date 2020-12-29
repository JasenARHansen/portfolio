package CTCI.Ch_03_Stacks_and_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
  private final Queue<Animal> catQueue;
  private final Queue<Animal> dogQueue;
  private int idCounter = 0;

  public AnimalShelter() {
    this.catQueue = new LinkedList<>();
    this.dogQueue = new LinkedList<>();
  }

  public Animal dequeueAny() {
    if (this.dogQueue.isEmpty() && this.catQueue.isEmpty()) {
      return null;
    } else if (this.dogQueue.isEmpty()) {
      return this.dequeueCats();
    } else if (this.catQueue.isEmpty()) {
      return this.dequeueDogs();
    } else {
      if (this.dogQueue.peek().compareInputID(this.catQueue.peek())) {
        return this.dequeueDogs();
      } else {
        return this.dequeueCats();
      }
    }
  }

  public Animal dequeueCats() {
    return this.catQueue.remove();
  }

  public Animal dequeueDogs() {
    return this.dogQueue.remove();
  }

  public void enqueue(Animal animal) throws Exception {
    animal.setInoutID(this.idCounter);
    this.idCounter++;

    if (animal instanceof Dog) {
      this.dogQueue.add(animal);
    } else if (animal instanceof Cat) {
      this.catQueue.add(animal);
    } else {
      throw new Exception();
    }
  }

  public Animal peek() {
    if (this.dogQueue.isEmpty() && this.catQueue.isEmpty()) {
      return null;
    } else if (this.dogQueue.isEmpty()) {
      return this.catQueue.peek();
    } else if (this.catQueue.isEmpty()) {
      return this.dogQueue.peek();
    } else {
      if (this.dogQueue.peek().compareInputID(this.catQueue.peek())) {
        return this.dogQueue.peek();
      } else {
        return this.catQueue.peek();
      }
    }
  }

  public Animal peekCats() {
    return this.catQueue.peek();
  }

  public Animal peekDogs() {
    return this.dogQueue.peek();
  }

  public int size() {
    return this.catQueue.size() + this.dogQueue.size();
  }

  public String printChoice() {

    StringBuilder returnString = new StringBuilder();

    returnString.append("\tDog: ");
    if (this.dogQueue.isEmpty()) {
      returnString.append("none\n");
    } else {
      returnString.append(this.peekDogs().toString()).append("\n");
    }
    returnString.append("\tCat: ");
    if (this.catQueue.isEmpty()) {
      returnString.append("none\n");
    } else {
      returnString.append(this.peekCats().toString()).append("\n");
    }
    return returnString.toString();
  }

  @Override
  public String toString() {
    return "Dogs: " + this.dogQueue.toString() + "\n" + "Cats: " + this.catQueue.toString() + "\n";
  }

  public abstract static class Animal {

    protected String name;
    private int inputID;

    public Animal(String name) {
      this.name = name;
    }

    public boolean compareInputID(Animal a) {
      return this.inputID < a.getInputID();
    }

    public int getInputID() {
      return this.inputID;
    }

    public String getName() {
      return this.name;
    }

    public void setInoutID(int inputID) {
      this.inputID = inputID;
    }

    @Override
    public String toString() {
      return this.name;
    }
  }

  public static class Cat extends Animal {
    public Cat(String n) {
      super(n);
    }
  }

  public static class Dog extends Animal {
    public Dog(String n) {
      super(n);
    }
  }
}
