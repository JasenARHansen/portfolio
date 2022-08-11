package Test.Interview.Facebook.interview.Mar_25_2021;

import Code.Interview.Facebook.interview.Mar_25_2021.question_2;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class question_2_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void NValues_1() {
    int[][] points = {{50, 50}, {100, 50}, {50, 200}, {100, 200}};
    boolean result = question_2.rectangleFound(points);
    System.out.format(
        "%s: The array contains prints that can form a rectangle: %s.\n",
        name.getMethodName(), result);
    assertTrue(result);
  }

  @Test
  public void NValues_2() {
    int[][] points = {{0, 0}, {50, 50}, {100, 50}, {50, 200}, {100, 200}, {120, 200}};

    boolean result = question_2.rectangleFound(points);
    System.out.format(
        "%s: The array contains prints that can form a rectangle: %s.\n",
        name.getMethodName(), result);
    assertTrue(result);
  }

  @Test
  public void NValues_3() {
    int[][] points = {{0, 0}, {100, 50}, {50, 200}, {100, 200}, {120, 200}};

    boolean result = question_2.rectangleFound(points);
    System.out.format(
        "%s: The array contains prints that can form a rectangle: %s.\n",
        name.getMethodName(), result);
    assertFalse(result);
  }
}
