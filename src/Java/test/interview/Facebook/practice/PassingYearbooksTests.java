package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertArrayEquals;

import Java.code.interview.Facebook.practice.PassingYearbooks;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PassingYearbooksTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void PassingYearbooks() {
    System.out.format("%s: ", name.getMethodName());
    PassingYearbooks.getDescription();
  }

  @Test
  public void findSignatureCounts_1() {
    int[] expected = {2, 2};
    int[] values = {2, 1};
    int[] result = PassingYearbooks.findSignatureCounts(values);
    System.out.format(
        "%s: The yearbooks for the initial mix '%s' has the following number of signatures '%s'\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void findSignatureCounts_2() {
    int[] expected = {1, 1};
    int[] values = {1, 2};
    int[] result = PassingYearbooks.findSignatureCounts(values);
    System.out.format(
        "%s: The yearbooks for the initial mix '%s' has the following number of signatures '%s'\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }
}
