package Test.CTCI.other.Ch_03_Stacks_and_Queues;

import Code.CTCI.CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_01_Three_in_One.FixedMultiStack;
import Code.CTCI.CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_01_Three_in_One.FullStackException;
import Code.CTCI.CTCI_SOURCE.other.Ch_03_Stacks_and_Queues.Q3_01_Three_in_One.MultiStack;
import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Code.CTCI.other.Ch_03_Stacks_and_Queues.MultiStackArray;
import Code.CTCI.other.Ch_03_Stacks_and_Queues.MultiStackArrayList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_01_Three_in_One_Test {

  @Rule
  public TestName name = new TestName();

  public static void printStacks(FixedMultiStack stacks) {
    System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
  }

  @Test
  public void MultiStackArrayList() {
    System.out.format("%s: \n", name.getMethodName());
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int stack = 0;
    int data = 10;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 1;
    data = 20;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 2;
    data = 30;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 1;
    data = 21;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 0;
    data = 11;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 0;
    data = 12;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 0;
    data = stacksArray.pop(stack);
    System.out.format("%s: Popped %d from Stack %d\n", name.getMethodName(), data, stack);
    System.out.println(stacksArray.toString());
    stack = 2;
    data = 31;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 0;
    data = 13;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 1;
    data = 22;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
    stack = 2;
    data = 32;
    System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
    stacksArray.push(stack, data);
    System.out.println(stacksArray.toString());
  }

  @Test
  public void MultiStackArray_solution_1() throws FullStackException {
    System.out.format("%s: \n", name.getMethodName());
    FixedMultiStack stacks = new FixedMultiStack(4);
    printStacks(stacks);
    stacks.push(0, 10);
    printStacks(stacks);
    stacks.push(1, 20);
    printStacks(stacks);
    stacks.push(2, 30);
    printStacks(stacks);

    stacks.push(1, 21);
    printStacks(stacks);
    stacks.push(0, 11);
    printStacks(stacks);
      stacks.push(0, 12);
      printStacks(stacks);

      stacks.pop(0);
      printStacks(stacks);

      stacks.push(2, 31);
      printStacks(stacks);

      stacks.push(0, 13);
      printStacks(stacks);
      stacks.push(1, 22);
      printStacks(stacks);

      stacks.push(2, 31);
      printStacks(stacks);
      stacks.push(2, 32);
      printStacks(stacks);
  }

    @Test
    public void MultiStackArray_solution_2() throws Exception {
        System.out.format("%s: \n", name.getMethodName());
        MultiStack stacks = new MultiStack(3, 4);
        printStacks(stacks);
        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);

        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

    stacks.pop(0);
    printStacks(stacks);

    stacks.push(2, 31);
    printStacks(stacks);

    stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(2, 32);
        printStacks(stacks);
        stacks.push(2, 33);
        printStacks(stacks);
        stacks.push(2, 34);
        printStacks(stacks);

        stacks.pop(1);
        printStacks(stacks);
        stacks.push(2, 35);
        printStacks(stacks);

        System.out.println("Final Stack: " + AssortedMethods.arrayToString(stacks.getValues()));
    }

    public static void printStacks(MultiStack stacks) {
        System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
    }

    @Test
    public void MultiStackArray() {
        System.out.format("%s: \n", name.getMethodName());
        MultiStackArray stacksArray = new MultiStackArray();

        System.out.format(
                "%s: MultiStackArray has %d Stacks\n", name.getMethodName(), stacksArray.getStackCount());
        int stack = 0;
        int data = 0;
        System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
        stacksArray.push(stack, data);
        System.out.println(stacksArray.toString());
        stack = 1;
        data = 10;
        System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
        stacksArray.push(stack, data);
        System.out.println(stacksArray.toString());
        stack = 2;
        data = 20;
        System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
        stacksArray.push(stack, data);
        System.out.println(stacksArray.toString());
        stack = 0;
        data = 1;
        System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
        stacksArray.push(stack, data);
        System.out.println(stacksArray.toString());
        stack = 0;
        data = 2;
        System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
        stacksArray.push(stack, data);
        System.out.println(stacksArray.toString());
        stack = 0;
        data = 3;
        System.out.format("%s: Insert data %d into Stack %d\n", name.getMethodName(), data, stack);
        stacksArray.push(stack, data);
        System.out.println(stacksArray.toString());
        for (int i = 0; i < stacksArray.getStackCount(); i++) {
            System.out.format(
                    "%s: MultiStackArray Stack %d has a top value of %d\n",
                    name.getMethodName(), i, stacksArray.peek(i));
        }
        stack = 0;
        data = stacksArray.pop(stack);
        System.out.format("%s: Pop %d from Stack %d\n", name.getMethodName(), data, stack);
        System.out.println(stacksArray.toString());
    }
}
