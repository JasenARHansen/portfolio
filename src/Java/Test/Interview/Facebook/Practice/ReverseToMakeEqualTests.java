package Java.Test.Interview.Facebook.Practice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.Code.Interview.Facebook.Practice.ReverseToMakeEqual;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReverseToMakeEqualTests {
  @Rule public TestName name = new TestName();

  @Test
  public void ReverseToMakeEqual() {
    System.out.format("%s: ", name.getMethodName());
    ReverseToMakeEqual.getDescription();
  }

  @Test
  public void areTheyEqual_1() {
    int[] array_a = {1, 2, 3, 4};
    int[] array_b = {1, 4, 3, 2};
    boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
    System.out.format(
        "%s: The array '%s' can be made equal to '%s': %b\n",
        name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
    assertTrue(result);
  }

  @Test
  public void areTheyEqual_2() {
    int[] array_a = {1, 2, 3, 4};
    int[] array_b = {1, 4, 3, 3};
    boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
    System.out.format(
        "%s: The array '%s' can be made equal to '%s': %b\n",
        name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
    assertFalse(result);
  }

  @Test
  public void areTheyEqual_3() {
    int[] array_a = {1, 2, 3, 4};
    int[] array_b = {1, 3, 2, 4};
    boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
    System.out.format(
        "%s: The array '%s' can be made equal to '%s': %b\n",
        name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
    assertTrue(result);
  }

  @Test
  public void areTheyEqual_4() {
    int[] array_a = {1, 2, 3, 4, 5, 6};
    int[] array_b = {2, 1, 4, 3, 6, 5};
    boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
    System.out.format(
        "%s: The array '%s' can be made equal to '%s': %b\n",
        name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
    assertTrue(result);
  }

  @Test
  public void areTheyEqual_5() {
    int[] array_a = {1, 2, 3, 4, 5, 6};
    int[] array_b = {2, 1, 6, 3, 4, 5};
    boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
    System.out.format(
        "%s: The array '%s' can be made equal to '%s': %b\n",
        name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
    assertTrue(result);
  }

  @Test
  public void areTheyEqual_6() {
    int[] array_a = {1, 2, 3, 4, 5, 6};
    int[] array_b = {2, 4, 6, 3, 1, 5};
    boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
    System.out.format(
        "%s: The array '%s' can be made equal to '%s': %b\n",
        name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
    assertTrue(result);
  }

  @Test
  public void areTheyEqual_7() {
    int[] array_a = {1, 2, 3, 4, 5, 6};
    int[] array_b = {2, 4, 5, 3, 1, 7};
    boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
    System.out.format(
        "%s: The array '%s' can be made equal to '%s': %b\n",
        name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
    assertFalse(result);
  }
}
