package Java.Test.Interview.Facebook.Practice;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Facebook.Practice.EditDistance;
import Java.Code.Interview.Facebook.Practice.ElementSwapping;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementSwappingTests {
  @Rule public TestName name = new TestName();

  @Test
  public void EditDistance() {
    System.out.format("%s: ", name.getMethodName());
    EditDistance.getDescription();
  }

  @Test
  public void findMinArray_1() {
    int[] expected = {1, 5, 3};
    int k = 2;
    int[] values = {5, 3, 1};
    int[] result = ElementSwapping.findMinArray(values, k);
    System.out.format(
        "%s: The smallest possible lexical sort of '%s' with %d swaps is '%s'.\n",
        name.getMethodName(), Arrays.toString(values), k, Arrays.toString(result));
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }

  @Test
  public void findMinArray_2() {
    int[] expected = {2, 8, 9, 11, 1};
    int k = 3;
    int[] values = {8, 9, 11, 2, 1};
    int[] result = ElementSwapping.findMinArray(values, k);
    System.out.format(
        "%s: The smallest possible lexical sort of '%s' with %d swaps is '%s'.\n",
        name.getMethodName(), Arrays.toString(values), k, Arrays.toString(result));
    assertEquals(Arrays.toString(expected), Arrays.toString(result));
  }
}
