package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter.Animal;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter.Cat;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter.Dog;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnimalShelterTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void AnimalShelter() {
    new AnimalShelter();
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void enqueue() throws Exception {
    System.out.format("%s:\n", name.getMethodName());
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog("Barney");
    animalShelter.enqueue(barney);
    assertEquals(1, animalShelter.size());
  }

  @Test
  public void peekDogs() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog("Barney");
    animalShelter.enqueue(barney);
    Animal result = animalShelter.peekDogs();
    assertEquals(barney, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void peekCats() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat("Smokey");
    animalShelter.enqueue(Smokey);
    Animal result = animalShelter.peekCats();
    assertEquals(Smokey, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void dequeueAny() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog("Smokey");
    animalShelter.enqueue(barney);
    Animal result = animalShelter.dequeueAny();
    assertEquals(barney, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void peek() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog("Smokey");
    animalShelter.enqueue(barney);
    Animal result = animalShelter.peek();
    assertEquals(barney, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void dequeueDogs() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog("Barney");
    animalShelter.enqueue(barney);
    Animal result = animalShelter.dequeueDogs();
    assertEquals(barney, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void dequeueCats() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat("Smokey");
    animalShelter.enqueue(Smokey);
    Animal result = animalShelter.dequeueCats();
    assertEquals(Smokey, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void printChoice() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat("Smokey");
    animalShelter.enqueue(Smokey);
    String result = animalShelter.printChoice();
    assertEquals("""
            \tDog: none
            \tCat: Smokey
            """, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void getName() throws Exception {
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat("Smokey");
    animalShelter.enqueue(Smokey);
    String result = Smokey.getName();
    assertEquals("Smokey", result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }
}
