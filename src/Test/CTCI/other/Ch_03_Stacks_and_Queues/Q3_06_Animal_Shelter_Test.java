package Test.CTCI.other.Ch_03_Stacks_and_Queues;

import CTCI.other.Ch_03_Stacks_and_Queues.AnimalShelter;
import CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter.AnimalQueue;
import CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter.Cat;
import CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_06_Animal_Shelter.Dog;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_06_Animal_Shelter_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void AnimalShelter() throws Exception {
    System.out.format("%s: \n", name.getMethodName());

    AnimalShelter animalShelter = new AnimalShelter();
    AnimalShelter.Animal bandit = new AnimalShelter.Cat("Bandit");
    AnimalShelter.Animal smokey = new AnimalShelter.Cat("Smokey");
    AnimalShelter.Animal teddy = new AnimalShelter.Cat("Teddy");
    AnimalShelter.Animal barney = new AnimalShelter.Dog("Barney");
    AnimalShelter.Animal robby = new AnimalShelter.Dog("Robby");
    animalShelter.enqueue(barney);
    System.out.format("AnimalShelter:\n%s", animalShelter.toString());
    System.out.format("Current Choices:\n%s", animalShelter.printChoice());
    animalShelter.enqueue(teddy);
      System.out.format("AnimalShelter:\n%s", animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
      animalShelter.enqueue(robby);
      System.out.format("AnimalShelter:\n%s", animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
      animalShelter.enqueue(smokey);
      System.out.format("AnimalShelter:\n%s", animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
      animalShelter.enqueue(bandit);
      System.out.format("AnimalShelter:\n%s", animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
      System.out.format(
              "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
      System.out.format(
              "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
      System.out.format(
              "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueDogs(), animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
      System.out.format(
              "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueAny(), animalShelter.toString());
      System.out.format("Current Choices:\n%s", animalShelter.printChoice());
  }

  @Test
  public void sort_stack_solution_1() {
    System.out.format("%s: \n", name.getMethodName());

    AnimalQueue animals = new AnimalQueue();
    animals.enqueue(new Cat("Callie"));
    animals.enqueue(new Cat("Kiki"));
    animals.enqueue(new Dog("Fido"));
    animals.enqueue(new Dog("Dora"));
    animals.enqueue(new Cat("Kari"));
    animals.enqueue(new Dog("Dexter"));
    animals.enqueue(new Dog("Dobo"));
    animals.enqueue(new Cat("Copa"));

    System.out.println(animals.dequeueAny().name());
    System.out.println(animals.dequeueAny().name());
    System.out.println(animals.dequeueAny().name());

    animals.enqueue(new Dog("Dapa"));
    animals.enqueue(new Cat("Kilo"));

    while (animals.size() != 0) {
      System.out.println(animals.dequeueAny().name());
    }
  }
}
