package Test.interview.Facebook.interview.Mar_25_2021;

import Code.interview.Facebook.interview.Mar_25_2021.question_3;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class question_3_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void addString_1() {
    String a = "1234";
    String b = "1111";
    String expected = "2345";
    String result = question_3.addString(a, b);
    System.out.format("%s: Value '%s' plus '%s' is '%s'.\n", name.getMethodName(), a, b, result);
    assertEquals(expected, result);
  }

  @Test
  public void almostSorted_1() {
    int k = 3;
    int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] source = {1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] arr = source.clone();
    question_3.almostSorted(arr, k);
    System.out.format(
        "%s: The after sorting the partially sorted array '%s' with k as %d the array becomes '%s'.\n",
        name.getMethodName(), Arrays.toString(source), k, Arrays.toString(arr));
    assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
  }

  @Test
  public void almostSorted_2() {
    int k = 3;
    int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] source = {0, 1, 2, 3, 6, 4, 5, 7, 8, 9, 10, 11, 12};
    int[] arr = source.clone();
    question_3.almostSorted(arr, k);
    System.out.format(
        "%s: The after sorting the partially sorted array '%s' with k as %d the array becomes '%s'.\n",
        name.getMethodName(), Arrays.toString(source), k, Arrays.toString(arr));
    assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
  }
}
