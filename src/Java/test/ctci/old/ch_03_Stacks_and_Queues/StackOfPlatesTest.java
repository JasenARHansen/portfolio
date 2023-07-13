package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.StackOfPlates;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StackOfPlatesTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void StackOfPlates() {
    StackOfPlates<Integer> result = new StackOfPlates<>();
    assertNotNull(result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void isEmpty_1() {
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    System.out.format("\tSource: %s\n", stackOfPlates);
    boolean result = stackOfPlates.isEmpty();
    assertTrue(result);
    System.out.format("\tEmpty: %b\n", result);
  }

  @Test
  public void isEmpty_2() {
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 4;
    for (int i = 0; i < data; i++) {
      stackOfPlates.push(i);
    }
    System.out.format("\tSource: %s\n", stackOfPlates);
    boolean result = stackOfPlates.isEmpty();
    assertFalse(result);
    System.out.format("\tEmpty: %b\n", result);
  }

  @Test
  public void getSize() {
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 4;
    for (int i = 0; i < data; i++) {
      stackOfPlates.push(i);
    }
    System.out.format("\tSource: %s\n", stackOfPlates);
    int result_2 = stackOfPlates.getSize();
    System.out.format("\tSize: %d\n", result_2);
  }

  @Test
  public void push() {
    int expected = 5;
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 4;
    for (int i = 0; i < data; i++) {
      stackOfPlates.push(i);
    }
    System.out.format("\tSource: %s\n", stackOfPlates);
    stackOfPlates.push(data);
    int result = stackOfPlates.getSize();
    assertEquals(expected, result);
    System.out.format("\tResult: %s\n", stackOfPlates);
  }

  @Test
  public void pop() {
    int expected = 4;
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    for (int i = 0; i < expected + 1; i++) {
      stackOfPlates.push(i);
    }
    System.out.format("\tSource: %s\n", stackOfPlates);
    int result = stackOfPlates.pop();
    assertEquals(expected, result);
    System.out.format("\tResult: %s\n", stackOfPlates);
    System.out.format("\tPop: %d\n", result);
  }

  @Test
  public void popAt() throws Exception {
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 5;
    for (int i = 0; i < 10; i++) {
      stackOfPlates.push(data++);
    }
    System.out.format("\tSource: %s\n", stackOfPlates);
    String string_1 = stackOfPlates.toString();
    int offset = 4;
    int result = stackOfPlates.popAt(offset);
    String string_2 = stackOfPlates.toString();
    int expected = data - offset;
    assertEquals(expected, result);
    System.out.format("\tPop at index '%d' is '%d'\n", offset, result);
    System.out.format("\tResult: %s\n", stackOfPlates);
  }

  @Test
  public void peek() {
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int result_1 = stackOfPlates.getSize();
    int data = 4;
    for (int i = 0; i < data; i++) {
      stackOfPlates.push(i);
    }
    System.out.format("\tSource: %s\n", stackOfPlates);
    int result_2 = stackOfPlates.getSize();
    int result_3 = stackOfPlates.peek();
    assertNotEquals(result_1, result_2);
    System.out.format("\tPeek: %d\n", result_3);
  }

  @Test
  public void print() {
    String expected = "3, 2, 1, 0";
    System.out.format("%s:\n", name.getMethodName());
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 4;
    for (int i = 0; i < data; i++) {
      stackOfPlates.push(i);
    }
    System.out.format("\tSource: %s\n", stackOfPlates);
    String result = stackOfPlates.toString();
    assertEquals(expected, result);
    System.out.format("\ttoString:  %s\n", result);
  }
}
