package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.QueueFromStack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueFromStackTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void QueueFromStack() {
    QueueFromStack<Integer> result = new QueueFromStack<>();
    assertNotNull(result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void isEmpty() {
    System.out.format("%s:\n", name.getMethodName());
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    boolean result_1 = queueFromStack.isEmpty();
    assertTrue(result_1);
    queueFromStack.add(0);
    boolean result_2 = queueFromStack.isEmpty();
    assertFalse(result_2);
    System.out.format("\tResult: %b\n", result_2);
  }

  @Test
  public void add() {
    int expected = 1;
    System.out.format("%s:\n", name.getMethodName());
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    System.out.format("\tSource: %s\n", queueFromStack);
    queueFromStack.add(0);
    int result = queueFromStack.getSize();
    assertEquals(expected, result);
    System.out.format("\tResult: %s\n", queueFromStack);
  }

  @Test
  public void getSize() {
    int expected = 2;
    System.out.format("%s:\n", name.getMethodName());
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    queueFromStack.add(0);
    queueFromStack.add(1);
    System.out.format("\tSource: %s\n", queueFromStack);
    int result = queueFromStack.getSize();
    assertEquals(expected, result);
    System.out.format("\tResult: %d\n", result);
  }

  @Test
  public void remove() {
    int expected = 6;
    System.out.format("%s:\n", name.getMethodName());
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    queueFromStack.add(expected);
    queueFromStack.add(1);
    System.out.format("\tSource: %s\n", queueFromStack);
    int result = queueFromStack.remove();
    assertEquals(expected, result);
    System.out.format("\tResult: %d\n", result);
  }

  @Test
  public void peek() {
    int expected = 5;
    System.out.format("%s:\n", name.getMethodName());
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    queueFromStack.add(expected);
    queueFromStack.add(1);
    System.out.format("\tSource: %s\n", queueFromStack);
    int result = queueFromStack.peek();
    assertEquals(expected, result);
    System.out.format("\tResult: %d\n", result);
  }

  @Test
  public void to_string() {
    String expected = "[1, 5]";
    System.out.format("%s:\n", name.getMethodName());
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    queueFromStack.add(5);
    queueFromStack.add(1);
    System.out.format("\tSource: %s\n", queueFromStack);
    String result = queueFromStack.toString();
    assertEquals(expected, result);
    System.out.format("\tResult: %s\n", queueFromStack);
  }
}
