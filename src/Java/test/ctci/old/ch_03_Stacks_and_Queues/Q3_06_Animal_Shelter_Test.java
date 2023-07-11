package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_06_Animal_Shelter.AnimalQueue;
import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_06_Animal_Shelter.Cat;
import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_06_Animal_Shelter.Dog;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"SpellCheckingInspection", "NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_06_Animal_Shelter_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void sort_stack_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
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
