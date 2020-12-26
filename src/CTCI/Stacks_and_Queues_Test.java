package CTCI;

import CTCI.Stacks_and_Queues.*;
import CTCI.Stacks_and_Queues.AnimalShelter.Animal;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Stacks_and_Queues_Test {

    @Rule
    public TestName name = new TestName();
    private String testSuite = "Stacks and Queues";

    @Test
    public void AnimalShelter() throws Exception {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

        Stacks_and_Queues container = new Stacks_and_Queues();
        AnimalShelter animalShelter = container.new AnimalShelter();
        Animal bandit = animalShelter.new Cat("Bandit");
        Animal smokey = animalShelter.new Cat("Smokey");
        Animal teddy = animalShelter.new Cat("Teddy");
        Animal barney = animalShelter.new Dog("Barney");
        Animal robby = animalShelter.new Dog("Robby");
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
        System.out.format("AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter.toString());
        System.out.format("AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter.toString());
        System.out.format("AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueDogs(), animalShelter.toString());
        System.out.format("AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueAny(), animalShelter.toString());
    }

    @Test
    public void MinStack() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

        Stacks_and_Queues container = new Stacks_and_Queues();
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

        Stacks_and_Queues container = new Stacks_and_Queues();
        MultiStackArray stacksArray = container.new MultiStackArray(3);

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
        Stacks_and_Queues container = new Stacks_and_Queues();
        QueueFromStack<Integer> queueFromStack = container.new QueueFromStack<>();
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
        System.out.format("Peek '%s' on Queue '%s'\n", queueFromStack.peek(), queueFromStack.toString());
        System.out.format("Pop '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
        System.out.format("Pop '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
        System.out.format("Pop '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
        System.out.format("Pop '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack.toString());
        System.out.format("Peek '%s' on Queue '%s'\n", queueFromStack.peek(), queueFromStack.toString());
    }

    @Test
    public void StackOfPlates() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
        Stacks_and_Queues container = new Stacks_and_Queues();
        StackOfPlates<Integer> stackOfPlates = container.new StackOfPlates<>();

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
            System.out.format("Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates.toString());
            System.out.format("Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates.toString());
            System.out.format("Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void StackWithMin() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
        Stacks_and_Queues container = new Stacks_and_Queues();
        StackWithMin<Integer> stackWithMin = container.new StackWithMin<>();

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
