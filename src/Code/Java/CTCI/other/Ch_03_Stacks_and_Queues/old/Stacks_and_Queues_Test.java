package Code.Java.CTCI.other.Ch_03_Stacks_and_Queues.old;

import Code.Java.CTCI.other.Ch_03_Stacks_and_Queues.*;
import Code.Java.CTCI.other.Ch_03_Stacks_and_Queues.AnimalShelter.Animal;
import Code.Java.CTCI.other.Ch_03_Stacks_and_Queues.old.Stacks_and_Queues.StackWithMin;
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
        System.out.format("AnimalShelter:\n%s", animalShelter);
        animalShelter.enqueue(teddy);
        System.out.format("AnimalShelter:\n%s", animalShelter);
        animalShelter.enqueue(robby);
        System.out.format("AnimalShelter:\n%s", animalShelter);
        animalShelter.enqueue(smokey);
        System.out.format("AnimalShelter:\n%s", animalShelter);
        animalShelter.enqueue(bandit);
        System.out.format("AnimalShelter:\n%s", animalShelter);
        System.out.format(
                "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter);
        System.out.format(
                "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueCats(), animalShelter);
        System.out.format(
                "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueDogs(), animalShelter);
        System.out.format(
                "AnimalShelter: dequeue '%s'\n%s", animalShelter.dequeueAny(), animalShelter);
    }

    @Test
    public void MinStack() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

        MinStack<Integer> minStack = new MinStack<>();

        minStack.push(0);
        System.out.format("Stack '%s'\n", minStack);
        minStack.push(1);
        System.out.format("Stack '%s'\n", minStack);
        minStack.push(2);
        System.out.format("Stack '%s'\n", minStack);
        minStack.push(3);
        System.out.format("Stack '%s'\n", minStack);
        minStack.push(4);
        System.out.format("Stack '%s'\n", minStack);
        minStack.push(5);
        System.out.format("Stack '%s'\n", minStack);
        System.out.format("Peek '%s' on Stack '%s'\n", minStack.peek(), minStack);
        System.out.format("Peek '%s' on Stack '%s'\n", minStack.peek(), minStack);
        System.out.format("Pop '%s' on Stack '%s'\n", minStack.pop(), minStack);
    }

    @Test
    public void MultiStackArray() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

        MultiStackArrayList stacksArray = new MultiStackArrayList(3);

        stacksArray.push(0, 10);
        System.out.println(stacksArray);
        stacksArray.push(1, 20);
        System.out.println(stacksArray);
        stacksArray.push(2, 30);
        System.out.println(stacksArray);

        stacksArray.push(1, 21);
        System.out.println(stacksArray);
        stacksArray.push(0, 11);
        System.out.println(stacksArray);
        stacksArray.push(0, 12);
        System.out.println(stacksArray);

        System.out.println(stacksArray.pop(0));
        System.out.println(stacksArray);

        stacksArray.push(2, 31);
        System.out.println(stacksArray);

        stacksArray.push(0, 13);
        System.out.println(stacksArray);
        stacksArray.push(1, 22);
        System.out.println(stacksArray);

        stacksArray.push(2, 31);
        System.out.println(stacksArray);
        stacksArray.push(2, 32);
        System.out.println(stacksArray);
    }

    @Test
    public void QueueFromStack() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
        QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
        queueFromStack.add(0);
        System.out.format("Queue '%s'\n", queueFromStack);
        queueFromStack.add(1);
        System.out.format("Queue '%s'\n", queueFromStack);
        queueFromStack.add(2);
        System.out.format("Queue '%s'\n", queueFromStack);
        queueFromStack.add(3);
        System.out.format("Queue '%s'\n", queueFromStack);
        queueFromStack.add(4);
        System.out.format("Queue '%s'\n", queueFromStack);
        queueFromStack.add(5);
        System.out.format("Queue '%s'\n", queueFromStack);
        System.out.format(
                "Peek '%s' on Queue '%s'\n", queueFromStack.peek(), queueFromStack);
        System.out.format(
                "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack);
        System.out.format(
                "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack);
        System.out.format(
                "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack);
        System.out.format(
                "Remove '%s' on Queue '%s'\n", queueFromStack.remove(), queueFromStack);
        System.out.format(
                "Peek '%s' on Queue '%s'\n", queueFromStack.peek(), queueFromStack);
    }

    @Test
    public void StackOfPlates() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
        StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();

        stackOfPlates.push(0);
        System.out.format("Stack '%s'\n", stackOfPlates);
        stackOfPlates.push(1);
        System.out.format("Stack '%s'\n", stackOfPlates);
        stackOfPlates.push(2);
        System.out.format("Stack '%s'\n", stackOfPlates);
        stackOfPlates.push(3);
        System.out.format("Stack '%s'\n", stackOfPlates);
        stackOfPlates.push(4);
        System.out.format("Stack '%s'\n", stackOfPlates);
        stackOfPlates.push(5);
        System.out.format("Stack '%s'\n", stackOfPlates);
        System.out.format("Peek '%s' on Stack '%s'\n", stackOfPlates.peek(), stackOfPlates);
        System.out.format("Peek '%s' on Stack '%s'\n", stackOfPlates.peek(), stackOfPlates);
        System.out.format("Pop '%s' on Stack '%s'\n", stackOfPlates.pop(), stackOfPlates);
        try {
            System.out.format(
                    "Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates);
            System.out.format(
                    "Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates);
            System.out.format(
                    "Pop at 0 '%s' on Stack '%s'\n", stackOfPlates.popAt(0), stackOfPlates);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void StackWithMin() {
        System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
        StackWithMin<Integer> stackWithMin = new StackWithMin<>();

        stackWithMin.push(10);
        System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin);
        stackWithMin.push(20);
        System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin);
        stackWithMin.push(2);
        System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin);
        stackWithMin.pop();
        System.out.format("Min '%s' Stack '%s'\n", stackWithMin.min(), stackWithMin);
    }
}
