package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_06_Animal_Shelter;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class AnimalQueue {
  final LinkedList<Dog> dogs = new LinkedList<>();
  final LinkedList<Cat> cats = new LinkedList<>();
  private int order = 0;

  public void enqueue(Animal a) {
    a.setOrder(order);
    order++;
    if (a instanceof Dog) {
      dogs.addLast((Dog) a);
    } else if (a instanceof Cat) {
      cats.addLast((Cat) a);
    }
  }

  public Animal dequeueAny() {
    if (dogs.size() == 0) {
      return dequeueCats();
    } else if (cats.size() == 0) {
      return dequeueDogs();
    }
    Dog dog = dogs.peek();
    Cat cat = cats.peek();
    if (dog.isOlderThan(cat)) {
      return dogs.poll();
    } else {
      return cats.poll();
    }
  }

  public Dog dequeueDogs() {
    return dogs.poll();
  }

  public Cat dequeueCats() {
    return cats.poll();
  }

  public Animal peek() {
    if (dogs.size() == 0) {
      return cats.peek();
    } else if (cats.size() == 0) {
      return dogs.peek();
    }
    Dog dog = dogs.peek();
    Cat cat = cats.peek();
    if (dog.isOlderThan(cat)) {
      return dog;
    } else {
      return cat;
    }
  }

  public int size() {
    return dogs.size() + cats.size();
  }

  public Dog peekDogs() {
    return dogs.peek();
  }

  public Cat peekCats() {
    return cats.peek();
  }

  @Override
  public String toString() {
    return "Dogs: " + this.dogs + ", " + "Cats: " + this.cats;
  }
}
