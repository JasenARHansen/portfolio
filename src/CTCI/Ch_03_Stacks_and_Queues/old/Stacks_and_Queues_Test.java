package CTCI.Ch_03_Stacks_and_Queues.old;

import CTCI.Ch_03_Stacks_and_Queues.*;
import CTCI.Ch_03_Stacks_and_Queues.AnimalShelter.Animal;
import CTCI.Ch_03_Stacks_and_Queues.old.Stacks_and_Queues.StackWithMin;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Stacks_and_Queues_Test {

  private final String testSuite = "Stacks and Queues";
  @Rule
  public TestName name = new TestName();

  @Test
  public void AnimalShelter() throws Exception {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

    AnimalShelter animalShelter = new AnimalShelter();
    Animal bandit = new AnimalShelter.Cat("Bandit");
    Animal smokey = new AnimalShelter.Cat("Smokey");
    Animal teddy = new AnimalShelter.Cat("Teddy");
    Animal barney = new AnimalShelter.Dog("Barney");
    Animal robby = new AnimalShelter.Dog("Robby");
    animalShelter.enqueue(barney);
    System.out.format("AnimalShelter:\n%s", animalShelter.toString());
    animalShelter.enqueue(teddy);
    System.out.format("AnimalShelter:\n%s", animalShelter.toString());
    animalShelter.enqueue(robby);
    System.out.format("AnimalShelter:\n%s", animalShelter.toString());
    animalShelter.enqueue(smokey);
    System.out.format("AnimalShelter:\n%s", animalShelter.toString());
    animalShelter.enqueue(bandit);
    System.out.format("AnimalShelter:\n%s", animalShelter.toString());
    System.out.format(
            "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter.toString());
    System.out.format(
            "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter.toString());
    System.out.format(
            "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueDogs(), animalShelter.toString());
    System.out.format(
            "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueAny(), animalShelter.toString());
  }

  @Test
  public void MinStack() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

    MinStack<Integer> minStack = new MinStack<>();

    minStack.push(0);
    System.out.format("Stack '%s'\n", minStack.toString());
    minStack.push(1);
    System.out.format("Stack '%s'\n", minStack.toString());
    minStack.push(2);
    System.out.format("Stack '%s'\n", minStack.toString());
    minStack.push(3);
    System.out.format("Stack '%s'\n", minStack.toString());
    minStack.push(4);
    System.out.format("Stack '%s'\n", minStack.toString());
    minStack.push(5);
    System.out.format("Stack '%s'\n", minStack.toString());
    System.out.format("Peek '%s' on Stack '%s'\n", minStack.peek(), minStack.toString());
    System.out.format("Peek '%s' on Stack '%s'\n", minStack.peek(), minStack.toString());
    System.out.format("Pop '%s' on Stack '%s'\n", minStack.pop(), minStack.toString());
  }

  @Test
  public void MultiStackArray() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

    MultiStackArrayList stacksArray = new MultiStackArrayList(3);

    stacksArray.push(0, 10);
    System.out.println(stacksArray.toString());
    stacksArray.push(1, 20);
    System.out.println(stacksArray.toString());
    stacksArray.push(2, 30);
    System.out.println(stacksArray.toString());

    stacksArray.push(1, 21);
    System.out.println(stacksArray.toString());
    stacksArray.push(0, 11);
    System.out.println(stacksArray.toString());
    stacksArray.push(0, 12);
    System.out.println(stacksArray.toString());

    System.out.println(stacksArray.pop(0));
    System.out.println(stacksArray.toString());

    stacksArray.push(2, 31);
    System.out.println(stacksArray.toString());

    stacksArray.push(0, 13);
    System.out.println(stacksArray.toString());
    stacksArray.push(1, 22);
    System.out.println(stacksArray.toString());

    stacksArray.push(2, 31);
    System.out.println(stacksArray.toString());
    stacksArray.push(2, 32);
    System.out.println(stacksArray.toString());
  }

  @Test
  public void QueueFromStack() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    queueFromStack.add(0);
    System.out.format("Queue '%s'\n", queueFromStack.toString());
    queueFromStack.add(1);
    System.out.format("Queue '%s'\n", queueFromStack.toString());
    queueFromStack.add(2);
    System.out.format("Queue '%s'\n", queueFromStack.toString());
    queueFromStack.add(3);
    System.out.format("Queue '%s'\n", queueFromStack.toString());
    queueFromStack.add(4);
    System.out.format("Queue '%s'\n", queueFromStack.toString());
    queueFromStack.add(5);
    System.out.format("Queue '%s'\n", queueFromStack.toString());
    System.out.format(
            "Peek '%s' on Queue '%s'\n", queueFromStack.peek(), queueFromStack.toString());
    System.out.format(
            "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
    System.out.format(
            "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
    System.out.format(
            "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
    System.out.format(
            "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
    System.out.format(
            "Peek '%s' on Queue '%s'\n", queueFromStack.peek(), queueFromStack.toString());
  }

  @Test
  public void StackOfPlates() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();

    stackOfPlates.push(0);
    System.out.format("Stack '%s'\n", stackOfPlates.toString());
    stackOfPlates.push(1);
    System.out.format("Stack '%s'\n", stackOfPlates.toString());
    stackOfPlates.push(2);
    System.out.format("Stack '%s'\n", stackOfPlates.toString());
    stackOfPlates.push(3);
    System.out.format("Stack '%s'\n", stackOfPlates.toString());
    stackOfPlates.push(4);
    System.out.format("Stack '%s'\n", stackOfPlates.toString());
    stackOfPlates.push(5);
    System.out.format("Stack '%s'\n", stackOfPlates.toString());
    System.out.format("Peek '%s' on Stack '%s'\n", stackOfPlates.peek(), stackOfPlates.toString());
    System.out.format("Peek '%s' on Stack '%s'\n", stackOfPlates.peek(), stackOfPlates.toString());
    System.out.format("Pop '%s' on Stack '%s'\n", stackOfPlates.pop(), stackOfPlates.toString());
    try {
      System.out.format(
              "Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates.toString());
      System.out.format(
              "Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates.toString());
      System.out.format(
              "Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void StackWithMin() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    StackWithMin<Integer> stackWithMin = new StackWithMin<>();

    stackWithMin.push(10);
    System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin.toString());
    stackWithMin.push(20);
    System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin.toString());
    stackWithMin.push(2);
    System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin.toString());
    stackWithMin.pop();
    System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin.toString());
  }
}
