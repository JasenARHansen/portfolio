package Java.Test.Interview.Facebook.Interview.Mar_25_2021;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Facebook.Interview.Mar_25_2021.Question3;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Question3Tests {
  @Rule public TestName name = new TestName();

  @Test
  public void Question3() {
    System.out.format("%s: ", name.getMethodName());
    Question3.getDescription();
  }

  @Test
  public void addString_1() {
    String a = "1234";
    String b = "1111";
    String expected = "2345";
    String result = Question3.addString(a, b);
    System.out.format("%s: Value '%s' plus '%s' is '%s'.\n", name.getMethodName(), a, b, result);
    assertEquals(expected, result);
  }

  @Test
  public void addString_2() {
    String a = "99";
    String b = "999";
    String expected = "1098";
    String result = Question3.addString(a, b);
    System.out.format("%s: Value '%s' plus '%s' is '%s'.\n", name.getMethodName(), a, b, result);
    assertEquals(expected, result);
  }

  @Test
  public void addString_3() {
    String a = "1";
    String b = "999";
    String expected = "1000";
    String result = Question3.addString(a, b);
    System.out.format("%s: Value '%s' plus '%s' is '%s'.\n", name.getMethodName(), a, b, result);
    assertEquals(expected, result);
  }

  @Test
  public void almostSorted_1() {
    int k = 3;
    int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] source = {1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] arr = source.clone();
    Question3.almostSorted(arr, k);
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
    Question3.almostSorted(arr, k);
    System.out.format(
        "%s: The after sorting the partially sorted array '%s' with k as %d the array becomes '%s'.\n",
        name.getMethodName(), Arrays.toString(source), k, Arrays.toString(arr));
    assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
  }
}
