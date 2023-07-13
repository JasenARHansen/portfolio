package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import Java.code.ctci.old.ch_03_Stacks_and_Queues.SortableStack;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import java.util.Stack;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_05_Sort_Stack_Test {
  @Rule public final TestName name = new TestName();

  public static Stack<Integer> mergesort(Stack<Integer> inStack) {
    if (inStack.size() <= 1) {
      return inStack;
    }
    Stack<Integer> left = new Stack<>();
    Stack<Integer> right = new Stack<>();
    int count = 0;
    while (inStack.size() != 0) {
      count++;
      if (count % 2 == 0) {
        left.push(inStack.pop());
      } else {
        right.push(inStack.pop());
      }
    }
    left = mergesort(left);
    right = mergesort(right);
    while (left.size() > 0 || right.size() > 0) {
      if (left.size() == 0) {
        inStack.push(right.pop());
      } else if (right.size() == 0) {
        inStack.push(left.pop());
      } else if (right.peek().compareTo(left.peek()) <= 0) {
        inStack.push(left.pop());
      } else {
        inStack.push(right.pop());
      }
    }
    Stack<Integer> reverseStack = new Stack<>();
    while (inStack.size() > 0) {
      reverseStack.push(inStack.pop());
    }
    return reverseStack;
  }

  @Test
  public void sort_stack_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 10; i++) {
      int r = AssortedMethods.randomIntInRange(0, 1000);
      s.push(r);
    }
    String notExpected = s.toString();
    sort(s);
    String result = s.toString();
    assertNotEquals(notExpected, result);
    while (!s.isEmpty()) {
      System.out.format("\t%s\n", s.pop());
    }
  }

  public static void sort(Stack<Integer> s) {
    Stack<Integer> r = new Stack<>();
    while (!s.isEmpty()) {
      /* Insert each element in s in sorted order into r. */
      int tmp = s.pop();
      while (!r.isEmpty() && r.peek() > tmp) {
        s.push(r.pop());
      }
      r.push(tmp);
    }
    /* Copy the elements back. */
    while (!r.isEmpty()) {
      s.push(r.pop());
    }
  }

  @Test
  public void SortableStack() {
    String expected = "[123, 55, 23, 5, 1, 0]";
    System.out.format("%s:\n", name.getMethodName());
    SortableStack<Integer> sortableStack = new SortableStack<>();
    int[] array = new int[] {55, 1, 23, 0, 123, 5};
    for (int data : array) {
      sortableStack.push(data);
      System.out.format("\tPush '%s' on Stack '%s'\n", data, sortableStack);
    }
    sortableStack.sort();
    String result = sortableStack.toString();
    assertEquals(expected, result);
    System.out.format("\tSorted Queue '%s'\n", sortableStack);
    for (int i = 0; i < array.length; i++) {
      System.out.format("\tPop '%s' on Stack '%s'\n", sortableStack.pop(), sortableStack);
    }
  }

  @Test
  public void sort_stack_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 10; i++) {
      int r = AssortedMethods.randomIntInRange(0, 1000);
      s.push(r);
    }
    String notExpected = s.toString();
    mergesort(s);
    String result = s.toString();
    assertNotEquals(notExpected, result);
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }
}
