package Test.CTCI.Ch_03_Stacks_and_Queues;

import CTCI.Ch_03_Stacks_and_Queues.StackOfPlates;
import CTCI_SOURCE.Ch_03_Stacks_and_Queues.Q3_03_Stack_of_Plates.SetOfStacks;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.EmptyStackException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_03_Stack_of_Plates_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void StackOfPlates() {
    System.out.format("%s: \n", name.getMethodName());
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

  @Test(expected = EmptyStackException.class)
  public void StackWithMin_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    int capacity_per_sub_stack = 5;
    SetOfStacks set = new SetOfStacks(capacity_per_sub_stack);
    for (int i = 0; i < 34; i++) {
      set.push(i);
    }
    int index = 1;
    System.out.format("%s: Popped %d at index %d\n", name.getMethodName(), set.popAt(index), index);

    for (int i = 0; i < 35; i++) {
      System.out.println("Popped " + set.pop());
    }
  }
}
