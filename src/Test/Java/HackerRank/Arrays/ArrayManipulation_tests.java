package Test.Java.HackerRank.Arrays;

import Code.Java.HackerRank.Arrays.ArrayManipulation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArrayManipulation_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void arrayManipulation_1() {
    long expected = 10;
    int n = 10;
    int[][] values = {
            {1, 5, 3},
            {4, 8, 7},
            {6, 9, 1}
    };
    long result = ArrayManipulation.arrayManipulation(n, values);
    System.out.format(
            "%s: Using all of the queries, the largest result is %d.\n", name.getMethodName(), result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_2() {
    long expected = 200;
    int n = 5;
    int[][] values = {
            {1, 2, 100},
            {2, 5, 100},
            {3, 4, 100}
    };
    long result = ArrayManipulation.arrayManipulation(n, values);
    System.out.format(
            "%s: Using all of the queries, the largest result is %d.\n", name.getMethodName(), result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_3() {
    long expected = 31;
    int n = 10;
    int[][] values = {
            {2, 6, 8},
            {3, 5, 7},
            {1, 8, 1},
            {5, 9, 15}
    };
    long result = ArrayManipulation.arrayManipulation(n, values);
    System.out.format(
            "%s: Using all of the queries, the largest result is %d.\n", name.getMethodName(), result);
    assertEquals(expected, result);
  }
}
