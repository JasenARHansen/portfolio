package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_02_Stack_Min.StackWithMin;
import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_02_Stack_Min.StackWithMin2;
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
  public void StackWithMin_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    StackWithMin stack = new StackWithMin();
    StackWithMin2 stack2 = new StackWithMin2();
    int[] array = {2, 1, 3, 1};
    for (int value : array) {
      stack.push(value);
      stack2.push(value);
      System.out.print(value + ", ");
    }
    System.out.println('\n');
    for (int i = 0; i < array.length; i++) {
      System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
      System.out.println("New min is " + stack.min() + ", " + stack2.min());
    }
  }
}
