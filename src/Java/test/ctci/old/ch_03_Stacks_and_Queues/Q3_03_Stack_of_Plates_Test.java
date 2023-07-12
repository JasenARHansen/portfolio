package Java.test.ctci.old.ch_03_Stacks_and_Queues;

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
  public void StackWithMin_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int capacity_per_sub_stack = 5;
    SetOfStacks set = new SetOfStacks(capacity_per_sub_stack);
    for (int i = 0; i < 34; i++) {
      set.push(i);
    }
    int index = 1;
    System.out.format("%s: Popped %d at index %d\n", name.getMethodName(), set.popAt(index), index);
    for (int i = 0; i < 35; i++) {
      System.out.println("Popped " + set.pop());
    }
  }
}
