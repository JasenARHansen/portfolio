package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter.Animal;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter.Cat;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.AnimalShelter.Dog;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnimalShelterTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void AnimalShelter() {
    AnimalShelter result = new AnimalShelter();
    assertNotNull(result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void enqueue() throws Exception {
    int expected = 1;
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog("Barney");
    animalShelter.enqueue(barney);
    int result = animalShelter.size();
    assertEquals(expected, result);
    System.out.format("%s: '%s'\n", name.getMethodName(), animalShelter);
  }

  @Test
  public void peekDogs() throws Exception {
    String expected = "Barney";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog(expected);
    animalShelter.enqueue(barney);
    Animal animal = animalShelter.peekDogs();
    String result = animal.getName();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), animal);
  }

  @Test
  public void peekCats() throws Exception {
    String expected = "Smokey";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat(expected);
    animalShelter.enqueue(Smokey);
    Animal animal = animalShelter.peekCats();
    String result = animal.getName();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), animal);
  }

  @Test
  public void dequeueAny() throws Exception {
    String expected = "Barney";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog(expected);
    animalShelter.enqueue(barney);
    Animal animal = animalShelter.dequeueAny();
    String result = animal.getName();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), animal);
  }

  @Test
  public void peek() throws Exception {
    String expected = "Barney";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog(expected);
    animalShelter.enqueue(barney);
    Animal animal = animalShelter.peek();
    String result = animal.getName();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), animal);
  }

  @Test
  public void dequeueDogs() throws Exception {
    String expected = "Barney";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal barney = new Dog(expected);
    animalShelter.enqueue(barney);
    Animal animal = animalShelter.dequeueDogs();
    String result = animal.getName();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), animal);
  }

  @Test
  public void dequeueCats() throws Exception {
    String expected = "Smokey";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat(expected);
    animalShelter.enqueue(Smokey);
    Animal animal = animalShelter.dequeueCats();
    String result = animal.getName();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), animal);
  }

  @Test
  public void printChoice() throws Exception {
    String expected = "\tDog: none\n\tCat: Smokey\n";
    String cat = "Smokey";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat(cat);
    animalShelter.enqueue(Smokey);
    String result = animalShelter.printChoice();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }

  @Test
  public void getName() throws Exception {
    String expected = "Smokey";
    AnimalShelter animalShelter = new AnimalShelter();
    Animal Smokey = new Cat(expected);
    animalShelter.enqueue(Smokey);
    String result = Smokey.getName();
    assertEquals(expected, result);
    System.out.format("%s: %s\n", name.getMethodName(), result);
  }
}
