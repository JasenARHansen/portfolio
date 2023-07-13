package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_02_Stack_Min.StackWithMin;
import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_02_Stack_Min.StackWithMin2;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_02_Stack_Min_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void stackWithMin() {
    int[] expected = {1, 1, 2, 2147483647};
    System.out.format("%s:\n", name.getMethodName());
    StackWithMin stack = new StackWithMin();
    int[] array = {2, 1, 3, 1};
    for (int value : array) {
      stack.push(value);
    }
    int popped;
    int result;
    System.out.format("\tSource: %s\n", Arrays.toString(array).replace("[", "").replace("]", ""));
    for (int i = 0; i < array.length; i++) {
      popped = stack.pop().value;
      result = stack.min();
      assertEquals(expected[i], result);
      System.out.format("\tPopped: %d\n", popped);
      System.out.format("\tNew min is: %d\n", result);
    }
  }

  @Test
  public void StackWithMin2() {
    int[] expected = {1, 1, 2, 2147483647};
    System.out.format("%s:\n", name.getMethodName());
    StackWithMin2 stack = new StackWithMin2();
    int[] array = {2, 1, 3, 1};
    for (int value : array) {
      stack.push(value);
    }
    System.out.format("\tSource: %s\n", Arrays.toString(array).replace("[", "").replace("]", ""));
    int popped;
    int result;
    for (int i = 0; i < array.length; i++) {
      popped = stack.pop();
      result = stack.min();
      assertEquals(expected[i], result);
      System.out.format("\tPopped: %d\n", popped);
      System.out.format("\tNew min is: %d\n", result);
    }
  }
}
