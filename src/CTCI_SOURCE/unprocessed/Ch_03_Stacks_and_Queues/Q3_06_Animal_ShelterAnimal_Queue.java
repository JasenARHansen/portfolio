package CTCI_SOURCE.unprocessed.Ch_03_Stacks_and_Queues;

import java.util.LinkedList;

public class Q3_06_Animal_ShelterAnimal_Queue {
    LinkedList<Q3_06_Animal_Shelter_Dog> dogs = new LinkedList<>();
    LinkedList<Q3_06_Animal_Shelter_Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Q3_06_Animal_Shelter_Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Q3_06_Animal_Shelter_Dog) {
            dogs.addLast((Q3_06_Animal_Shelter_Dog) a);
        } else if (a instanceof Q3_06_Animal_Shelter_Cat) {
            cats.addLast((Q3_06_Animal_Shelter_Cat) a);
        }
    }

    public Q3_06_Animal_Shelter_Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
        Q3_06_Animal_Shelter_Dog dog = dogs.peek();
        Q3_06_Animal_Shelter_Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public Q3_06_Animal_Shelter_Animal peek() {
        if (dogs.size() == 0) {
            return cats.peek();
        } else if (cats.size() == 0) {
            return dogs.peek();
        }
        Q3_06_Animal_Shelter_Dog dog = dogs.peek();
        Q3_06_Animal_Shelter_Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dog;
        } else {
            return cat;
        }
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public Q3_06_Animal_Shelter_Dog dequeueDogs() {
        return dogs.poll();
    }

    public Q3_06_Animal_Shelter_Dog peekDogs() {
        return dogs.peek();
    }

    public Q3_06_Animal_Shelter_Cat dequeueCats() {
        return cats.poll();
    }

    public Q3_06_Animal_Shelter_Cat peekCats() {
        return cats.peek();
    }
}
