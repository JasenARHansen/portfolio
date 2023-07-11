package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.MinStack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinStackTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void MinStack() {
    new MinStack<>();
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void enqueue() {
    MinStack<Integer> minStack = new MinStack<>();
    boolean result_1 = minStack.isEmpty();
    assertTrue(result_1);
    minStack.push(5);
    boolean result_2 = minStack.isEmpty();
    assertFalse(result_2);
    System.out.format("%s: %b - %b\n", name.getMethodName(), result_1, result_2);
  }

  @Test
  public void getSize() {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    int result = minStack.getSize();
    assertEquals(1, result);
    System.out.format("%s: %d\n", name.getMethodName(), result);
  }

  @Test
  public void min() {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    minStack.push(1);
    minStack.push(4);
    minStack.push(0);
    minStack.push(2);
    minStack.push(3);
    System.out.format("Stack '%s'\n", minStack);
    int result = minStack.min();
    assertEquals(0, result);
    System.out.format("%s: Min '%s' on Stack '%s'\n", name.getMethodName(), result, minStack);
  }

  @Test
  public void peek() {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    minStack.push(1);
    minStack.push(4);
    minStack.push(0);
    minStack.push(2);
    minStack.push(3);
    System.out.format("Stack '%s'\n", minStack);
    int result = minStack.peek();
    assertEquals(3, result);
    System.out.format("%s: Peek '%s' on Stack '%s'\n", name.getMethodName(), result, minStack);
  }

  @Test
  public void pop() {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    minStack.push(1);
    minStack.push(4);
    minStack.push(0);
    minStack.push(2);
    minStack.push(3);
    System.out.format("Stack '%s'\n", minStack);
    int result = minStack.pop();
    assertEquals(3, result);
    System.out.format("%s: pop '%s' on Stack '%s'\n", name.getMethodName(), result, minStack);
  }

  @Test
  public void sequence() {
    System.out.format("%s:\n", name.getMethodName());
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
}
