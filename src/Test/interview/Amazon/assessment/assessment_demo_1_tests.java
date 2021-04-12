package Test.interview.Amazon.assessment;

import Code.interview.Amazon.assessment.assessment_demo_1;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class assessment_demo_1_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void fizzBuzz_1() {
    int expected = 15;
    List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int result = assessment_demo_1.sumList(values);
    System.out.format(
        "%s: The sum of the list '%s' is: %d\n", name.getMethodName(), values, result);
    assertEquals(expected, result);
  }
}
