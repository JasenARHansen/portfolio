package Test.Java.CTCI.other.Ch_03_Stacks_and_Queues;

import Java.Code.CTCI.CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_02_Stack_Min.StackWithMin;
import Java.Code.CTCI.CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_02_Stack_Min.StackWithMin2;
import Java.Code.CTCI.other.Ch_03_Stacks_and_Queues.MinStack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_02_Stack_Min_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void MinStack() {

    System.out.format("%s: \n", name.getMethodName());
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    System.out.format("Stack '%s'\n", minStack);
    minStack.push(1);
    System.out.format("Stack '%s'\n", minStack);
    minStack.push(4);
    System.out.format("Stack '%s'\n", minStack);
    minStack.push(0);
    System.out.format("Stack '%s'\n", minStack);
    minStack.push(2);
    System.out.format("Stack '%s'\n", minStack);
    minStack.push(3);
    System.out.format("Stack '%s'\n", minStack);
    System.out.format("Peek '%s' on Stack '%s'\n", minStack.peek(), minStack);
    System.out.format("Min '%s' on Stack '%s'\n", minStack.min(), minStack);
    System.out.format("Pop '%s' on Stack '%s'\n", minStack.pop(), minStack);
    System.out.format("Min '%s' on Stack '%s'\n", minStack.min(), minStack);
    System.out.format("Pop '%s' on Stack '%s'\n", minStack.pop(), minStack);
    System.out.format("Min '%s' on Stack '%s'\n", minStack.min(), minStack);
    System.out.format("Pop '%s' on Stack '%s'\n", minStack.pop(), minStack);
    System.out.format("Min '%s' on Stack '%s'\n", minStack.min(), minStack);
    System.out.format("Pop '%s' on Stack '%s'\n", minStack.pop(), minStack);
  }

  @Test
  public void StackWithMin_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    StackWithMin stack = new StackWithMin();
    StackWithMin2 stack2 = new StackWithMin2();
    int[] array = {2, 1, 3, 1};
    for (int value : array) {
      stack.push(value);
      stack2.push(value);
      System.out.print(value + ", ");
    }
    System.out.println('\n');
    for (int i = 0; i < array.length; i++) {
      System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
      System.out.println("New min is " + stack.min() + ", " + stack2.min());
    }
  }
}
