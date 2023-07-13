package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.MultiStackArray;
import Java.code.ctci.old.ch_03_Stacks_and_Queues.MultiStackArrayList;
import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_01_Three_in_One.FixedMultiStack;
import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_01_Three_in_One.FullStackException;
import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_01_Three_in_One.MultiStack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode", "DataFlowIssue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_01_Three_in_One_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void MultiStackArrayList() {
    System.out.format("%s:\n", name.getMethodName());
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int stack = 0;
    int data = 10;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 1;
    data = 20;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 2;
    data = 30;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 1;
    data = 21;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 0;
    data = 11;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 0;
    data = 12;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 0;
    data = stacksArray.pop(stack);
    System.out.format("\tPopped %d from Stack %d\n", data, stack);
    System.out.format("\tStack:\n%s", stacksArray);
    stack = 2;
    data = 31;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 0;
    data = 13;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 1;
    data = 22;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 2;
    data = 32;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    System.out.format("\tStack:\n%s", stacksArray);
  }

  @Test
  public void FixedMultiStack() throws FullStackException {
    String expected = "10, 11, 30, 13, 20, 21, 22, 0, 30, 31, 31, 32";
    System.out.format("%s:\n", name.getMethodName());
    FixedMultiStack stacks = new FixedMultiStack(4);
    System.out.format("\tStack: %s\n", stacks);
    int stack = 0;
    int data = 10;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 11;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 12;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 1;
    data = 20;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 21;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 2;
    data = 30;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 0;
    stacks.pop(stack);
    System.out.format("\tPop Data from Stack %d\n", stack);
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 13;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 1;
    data = 22;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 2;
    data = 31;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 31;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 32;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    String result = stacks.toString();
    assertEquals(expected, result);
    System.out.format("\tStack: %s\n", result);
  }

  @Test
  public void MultiStack() throws Exception {
    String expected = "33, 34, 35, 10, 11, 13, 20, 21, 30, 31, 31, 32";
    System.out.format("%s:\n", name.getMethodName());
    MultiStack stacks = new MultiStack(3, 4);
    System.out.format("\tStack: %s\n", stacks);
    int stack = 0;
    int data = 10;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 11;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 12;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 1;
    data = 20;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 21;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 2;
    data = 30;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 0;
    stacks.pop(stack);
    System.out.format("\tPop Stack %d\n", stack);
    data = 13;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 1;
    data = 22;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 2;
    data = 31;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 31;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 32;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 33;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    data = 34;
    stacks.push(stack, data);
    System.out.format("\tInsert Data %d into Stack %d\n", data, stack);
    stack = 1;
    stacks.pop(stack);
    System.out.format("\tPop Stack %d\n", stack);
    stack = 2;
    data = 35;
    stacks.push(stack, data);
    String result = stacks.toString();
    assertEquals(expected, result);
    System.out.format("\tStack: %s\n", result);
  }

  @Test
  public void MultiStackArray() {
    int expected_1 = 2;
    int expected_2 = 10;
    int expected_3 = 20;
    System.out.format("%s:\n", name.getMethodName());
    MultiStackArray stacksArray = new MultiStackArray();
    System.out.format("\tMultiStackArray has %d Stacks\n", stacksArray.getStackCount());
    int stack = 0;
    int data = 0;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 1;
    data = 10;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 2;
    data = 20;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 0;
    data = 1;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 0;
    data = 2;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    stack = 0;
    data = 3;
    System.out.format("\tInsert data %d into Stack %d\n", data, stack);
    stacksArray.push(stack, data);
    System.out.format("\tStack:\n%s", stacksArray);
    for (int i = 0; i < stacksArray.getStackCount(); i++) {
      System.out.format(
          "\tMultiStackArray Stack %d has a top value of %d\n", i, stacksArray.peek(i));
    }
    stack = 0;
    data = stacksArray.pop(stack);
    System.out.format("\tPop %d from Stack %d\n", data, stack);
    int result_1 = stacksArray.peek(0);
    int result_2 = stacksArray.peek(1);
    int result_3 = stacksArray.peek(2);
    assertEquals(expected_1, result_1);
    assertEquals(expected_2, result_2);
    assertEquals(expected_3, result_3);
    System.out.format("\tStack:\n%s", stacksArray);
  }
}
