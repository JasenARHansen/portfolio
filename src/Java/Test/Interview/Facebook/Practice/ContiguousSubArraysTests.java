package Java.Test.Interview.Facebook.Practice;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Facebook.Practice.ContiguousSubArrays;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContiguousSubArraysTests {
  @Rule public TestName name = new TestName();

  @Test
  public void ContiguousSubArrays() {
    System.out.format("%s: ", name.getMethodName());
    ContiguousSubArrays.getDescription();
  }

  @Test
  public void countSubArrays_1() {
    int[] expected = {1, 3, 1, 5, 1};
    int[] values = {3, 4, 1, 6, 2};
    int[] result = ContiguousSubArrays.countSubArrays(values);
    System.out.format(
        "%s: The array '%s' has the following number of sub-arrays '%s'\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }

  @Test
  public void countSubArrays_2() {
    int[] expected = {1, 2, 6, 1, 3, 1};
    int[] values = {2, 4, 7, 1, 5, 3};
    int[] result = ContiguousSubArrays.countSubArrays(values);
    System.out.format(
        "%s: The array '%s' has the following number of sub-arrays '%s'\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }
}
