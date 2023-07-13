package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import static org.junit.Assert.assertEquals;

import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_03_Stack_of_Plates.SetOfStacks;
import java.util.EmptyStackException;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_03_Stack_of_Plates_Test {
  @Rule public final TestName name = new TestName();

  @Test(expected = EmptyStackException.class)
  public void StackWithMin() {
    int[] expected = {11, 10, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    System.out.format("%s:\n", name.getMethodName());
    int capacity_per_sub_stack = 5;
    SetOfStacks set = new SetOfStacks(capacity_per_sub_stack);
    int length = 12;
    for (int i = 0; i < length; i++) {
      set.push(i);
    }
    int index = 1;
    System.out.format("\tPopped %d at index %d\n", set.popAt(index), index);
    int result;
    for (int i = 0; i < length + 1; i++) {
      result = set.pop();
      assertEquals(expected[i], result);
      System.out.format("\tPopped: %d\n", result);
    }
  }
}
