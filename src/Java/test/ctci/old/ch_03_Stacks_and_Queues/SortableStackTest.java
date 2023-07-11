package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.SortableStack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortableStackTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void SortableStack() {
    new SortableStack<>();
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void isEmpty() {
    SortableStack<Integer> sortableStack = new SortableStack<>();
    boolean result_1 = sortableStack.isEmpty();
    assertTrue(result_1);
    int data = 10;
    sortableStack.push(data);
    boolean result_2 = sortableStack.isEmpty();
    assertFalse(result_2);
    System.out.format("%s: isEmpty %b - %b\n", name.getMethodName(), result_1, result_2);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void getSize() {
    SortableStack<Integer> sortableStack = new SortableStack<>();
    int data = 10;
    sortableStack.push(data);
    int result = sortableStack.getSize();
    assertEquals(1, result);
    System.out.format("%s: getSize %d\n", name.getMethodName(), result);
  }

  @Test
  public void peek() {
    SortableStack<Integer> sortableStack = new SortableStack<>();
    int data = 10;
    sortableStack.push(data);
    int result = sortableStack.peek();
    assertEquals(data, result);
    assertFalse(sortableStack.isEmpty());
    System.out.format("%s: peek %d\n", name.getMethodName(), result);
  }

  @Test
  public void push() {
    SortableStack<Integer> sortableStack = new SortableStack<>();
    int data = 10;
    boolean result = sortableStack.isEmpty();
    assertTrue(result);
    sortableStack.push(data);
    result = sortableStack.isEmpty();
    assertFalse(result);
    System.out.format("%s: push %b\n", name.getMethodName(), result);
  }

  @Test
  public void pop() {
    SortableStack<Integer> sortableStack = new SortableStack<>();
    int data = 10;
    sortableStack.push(data);
    int result = sortableStack.pop();
    assertEquals(data, result);
    assertTrue(sortableStack.isEmpty());
    System.out.format("%s: pop %d\n", name.getMethodName(), result);
  }

  @Test
  public void sort() {
    SortableStack<Integer> sortableStack = new SortableStack<>();
    int data = 10;
    sortableStack.push(data++);
    sortableStack.push(data++);
    sortableStack.push(data);
    String result_1 = sortableStack.toString();
    sortableStack.sort();
    String result1_2 = sortableStack.toString();
    assertNotEquals(result_1, result1_2);
    System.out.format("%s: sort %s - %s\n", name.getMethodName(), result_1, result1_2);
  }
}
