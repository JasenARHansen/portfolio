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
    new QueueFromStack<>();
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void isEmpty() {
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    boolean result_1 = queueFromStack.isEmpty();
    assertTrue(result_1);
    queueFromStack.add(0);
    boolean result_2 = queueFromStack.isEmpty();
    assertFalse(result_2);
    System.out.format("%s: is empty %b - %b\n", name.getMethodName(), result_1, result_2);
  }

  @Test
  public void add() {
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    queueFromStack.add(0);
    int result = queueFromStack.getSize();
    assertEquals(1, result);
    System.out.format("%s: Added %d\n", name.getMethodName(), result);
  }

  @Test
  public void getSize() {
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    queueFromStack.add(0);
    queueFromStack.add(1);
    int result = queueFromStack.getSize();
    assertEquals(2, result);
    System.out.format("%s: getSize %d\n", name.getMethodName(), result);
  }

  @Test
  public void remove() {
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    int value = 6;
    queueFromStack.add(value);
    queueFromStack.add(1);
    int result = queueFromStack.remove();
    assertEquals(value, result);
    System.out.format("%s: Remove %d\n", name.getMethodName(), result);
  }

  @Test
  public void peek() {
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    int value = 5;
    queueFromStack.add(value);
    queueFromStack.add(1);
    int result = queueFromStack.peek();
    assertEquals(value, result);
    System.out.format("%s: Peek %d\n", name.getMethodName(), result);
  }

  @Test
  public void print() {
    QueueFromStack<Integer> queueFromStack = new QueueFromStack<>();
    String value = "[1, 5]";
    queueFromStack.add(5);
    queueFromStack.add(1);
    String result = queueFromStack.toString();
    assertEquals(value, result);
    System.out.format("%s: toString %s\n", name.getMethodName(), result);
  }
}
