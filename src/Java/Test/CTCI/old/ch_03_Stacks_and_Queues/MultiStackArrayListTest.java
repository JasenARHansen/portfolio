package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.*;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.MultiStackArrayList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"ConstantValue", "DuplicatedCode", "DataFlowIssue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MultiStackArrayListTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void MultiStackArrayList_default() {
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int result = stacksArray.getStackCount();
    assertEquals(3, result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void MultiStackArrayList_size() {
    int count = 5;
    MultiStackArrayList stacksArray = new MultiStackArrayList(count);
    int result = stacksArray.getStackCount();
    assertEquals(count, result);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void getStackCount() {
    int count = 6;
    MultiStackArrayList stacksArray = new MultiStackArrayList(count);
    int result = stacksArray.getStackCount();
    assertEquals(count, result);
    System.out.format("%s: Stack count %s\n", name.getMethodName(), result);
  }

  @Test
  public void push() {
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int stack = 0;
    int data = 10;
    stacksArray.push(stack, data);
    int result = stacksArray.peek(0);
    assertEquals(data, result);
    System.out.format("%s: Stack %d peek %d\n", name.getMethodName(), stack, result);
  }

  @Test
  public void getSize() {
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int stack = 0;
    int data = 10;
    stacksArray.push(stack, data);
    int result = stacksArray.getSize(0);
    assertEquals(1, result);
    System.out.format("%s: Stack %d size %d\n", name.getMethodName(), stack, result);
  }

  @Test
  public void peek() {
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int stack = 0;
    int data = 10;
    stacksArray.push(stack, data);
    int result = stacksArray.peek(0);
    assertEquals(data, result);
    System.out.format("%s: Stack %d peek %d\n", name.getMethodName(), stack, result);
  }

  @Test
  public void isEmpty() {
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int stack = 0;
    boolean result_1 = stacksArray.isEmpty(0);
    assertTrue(result_1);
    int data = 10;
    stacksArray.push(stack, data);
    boolean result_2 = stacksArray.isEmpty(0);
    assertFalse(result_2);
    System.out.format(
        "%s: Stack %d is empty %b - %b\n", name.getMethodName(), stack, result_1, result_2);
  }

  @Test
  public void print() {
    System.out.format("%s:\n", name.getMethodName());
    MultiStackArrayList stacksArray = new MultiStackArrayList();
    int stack = 0;
    int data = 10;
    stacksArray.push(stack, data);
    stack = 1;
    data = 20;
    stacksArray.push(stack, data);
    stack = 2;
    data = 30;
    stacksArray.push(stack, data);
    stack = 1;
    data = 21;
    stacksArray.push(stack, data);
    stack = 0;
    data = 11;
    stacksArray.push(stack, data);
    stack = 0;
    data = 12;
    stacksArray.push(stack, data);
    stack = 0;
    data = 13;
    stacksArray.push(stack, data);
    stack = 1;
    data = 22;
    stacksArray.push(stack, data);
    stack = 2;
    data = 32;
    stacksArray.push(stack, data);
    System.out.println(stacksArray);
    int first = 0;
    int second = 1;
    int third = 2;
    int first_size = stacksArray.peek(first);
    int second_size = stacksArray.peek(second);
    int third_size = stacksArray.peek(third);
    assertEquals(13, first_size);
    assertEquals(22, second_size);
    assertEquals(32, third_size);
    System.out.format(
        "%s: Stack %d count %d - Stack %d count %d - Stack %d count %d\n",
        name.getMethodName(), first, first_size, second, second_size, third, third_size);
  }
}
