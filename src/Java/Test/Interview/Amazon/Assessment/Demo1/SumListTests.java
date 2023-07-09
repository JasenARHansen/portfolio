package Java.Test.Interview.Amazon.Assessment.Demo1;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Amazon.Assessment.Demo1.SumList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SumListTests {
  @Rule public TestName name = new TestName();

  @Test
  public void SumList() {
    System.out.format("%s: ", name.getMethodName());
    SumList.getDescription();
  }

  @Test
  public void sumList() {
    int expected = 15;
    List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int result = SumList.sumList(values);
    System.out.format(
        "%s: The sum of the list '%s' is: %d\n", name.getMethodName(), values, result);
    assertEquals(expected, result);
  }
}
