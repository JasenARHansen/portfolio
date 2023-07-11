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
    new StackOfPlates<>();
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void isEmpty() {
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    boolean result_1 = stackOfPlates.isEmpty();
    stackOfPlates.push(3);
    boolean result_2 = stackOfPlates.isEmpty();
    assertTrue(result_1);
    assertFalse(result_2);
    assertNotEquals(result_1, result_2);
    System.out.format("%s: isEmpty %b - %b\n", name.getMethodName(), result_1, result_2);
  }

  @Test
  public void getSize() {
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int result_1 = stackOfPlates.getSize();
    stackOfPlates.push(3);
    int result_2 = stackOfPlates.getSize();
    System.out.format("%s: getSize %d - %d\n", name.getMethodName(), result_1, result_2);
  }

  @Test
  public void push() {
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int result_1 = stackOfPlates.getSize();
    stackOfPlates.push(3);
    int result_2 = stackOfPlates.getSize();
    System.out.format("%s: push %d - %d\n", name.getMethodName(), result_1, result_2);
  }

  @Test
  public void pop() {
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 5;
    stackOfPlates.push(data);
    int result = stackOfPlates.pop();
    assertEquals(data, result);
    System.out.format("%s: pop %d\n", name.getMethodName(), result);
  }

  @Test
  public void popAt() throws Exception {
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 5;
    for (int i = 0; i < 10; i++) {
      stackOfPlates.push(data++);
    }
    String string_1 = stackOfPlates.toString();
    int offset = 4;
    int result = stackOfPlates.popAt(offset);
    String string_2 = stackOfPlates.toString();
    int expected = data - offset;
    assertEquals(expected, result);
    System.out.format(
        "%s: '%s' popAt index '%d' is '%d' leaving '%s'\n",
        name.getMethodName(), string_1, offset, result, string_2);
  }

  @Test
  public void peek() {
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int result_1 = stackOfPlates.getSize();
    int data = 5;
    stackOfPlates.push(data);
    int result_2 = stackOfPlates.getSize();
    int result_3 = stackOfPlates.peek();
    assertNotEquals(result_1, result_2);
    System.out.format("%s: peek %d\n", name.getMethodName(), result_3);
  }

  @Test
  public void print() {
    StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>();
    int data = 5;
    stackOfPlates.push(data--);
    stackOfPlates.push(data--);
    stackOfPlates.push(data--);
    stackOfPlates.push(data);
    String result = stackOfPlates.toString();
    assertEquals("2, 3, 4, 5", result);
    System.out.format("%s: print %s\n", name.getMethodName(), result);
  }

  @Test
  public void StackOfPlates_1() {
    System.out.format("%s:\n", name.getMethodName());
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
    System.out.format("Pop '%s' on Stack '%s'\n", stackOfPlates.pop(), stackOfPlates);
    try {
      System.out.format("Pop at 1 '%s' on Stack '%s'\n", stackOfPlates.popAt(1), stackOfPlates);
      System.out.format("Pop at 1 '%s' on Stack '%s'\n", stackOfPlates.popAt(1), stackOfPlates);
      System.out.format("Pop at 1 '%s' on Stack '%s'\n", stackOfPlates.popAt(1), stackOfPlates);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
