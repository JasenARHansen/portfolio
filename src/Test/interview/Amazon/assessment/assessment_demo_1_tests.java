package Test.interview.Amazon.assessment;

import Code.interview.Amazon.assessment.assessment_demo_1;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class assessment_demo_1_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void fizzBuzz_1() {
    int count = 21;
    System.out.format("%s: FizzBuzz with '%d' as the input:\n", name.getMethodName(), count);
    assessment_demo_1.fizzBuzz(count);
  }
}
