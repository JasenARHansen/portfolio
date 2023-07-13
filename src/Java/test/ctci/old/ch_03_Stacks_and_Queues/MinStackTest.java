package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.MinStack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinStackTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void MinStack() {
    MinStack<Integer> result = new MinStack<>();
    assertNotNull(result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void enqueue() {
    System.out.format("%s:\n", name.getMethodName());
    MinStack<Integer> minStack = new MinStack<>();
    boolean result = minStack.isEmpty();
    assertTrue(result);
    System.out.format("\tBefore: Source %s\n", minStack);
    minStack.push(5);
    result = minStack.isEmpty();
    assertFalse(result);
    System.out.format("\tAfter: Source %s\n", minStack);
  }

  @Test
  public void getSize() {
    int expected = 1;
    System.out.format("%s:\n", name.getMethodName());
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    System.out.format("\tStack '%s'\n", minStack);
    int result = minStack.getSize();
    assertEquals(expected, result);
    System.out.format("\tSize: %d\n", result);
  }

  @Test
  public void min() {
    int expected = 0;
    System.out.format("%s:\n", name.getMethodName());
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    minStack.push(1);
    minStack.push(4);
    minStack.push(0);
    minStack.push(2);
    minStack.push(3);
    System.out.format("\tStack '%s'\n", minStack);
    int result = minStack.min();
    assertEquals(expected, result);
    System.out.format("\tMin '%s'\n", result);
  }

  @Test
  public void peek() {
    int expected = 3;
    System.out.format("%s:\n", name.getMethodName());
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    minStack.push(1);
    minStack.push(4);
    minStack.push(0);
    minStack.push(2);
    minStack.push(3);
    System.out.format("\tStack '%s'\n", minStack);
    int result = minStack.peek();
    assertEquals(expected, result);
    System.out.format("\tPeek '%d'\n", result);
  }

  @Test
  public void pop() {
    int expected = 3;
    System.out.format("%s:\n", name.getMethodName());
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    minStack.push(1);
    minStack.push(4);
    minStack.push(0);
    minStack.push(2);
    minStack.push(3);
    System.out.format("\tStack '%s'\n", minStack);
    int result = minStack.pop();
    assertEquals(expected, result);
    System.out.format("\tPop '%d'\n", result);
    System.out.format("\tStack '%s'\n", minStack);
  }
}
