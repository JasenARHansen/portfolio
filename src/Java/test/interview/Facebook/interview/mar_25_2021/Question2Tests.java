package Java.test.interview.Facebook.interview.mar_25_2021;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.code.interview.Facebook.interview.mar_25_2021.Question2;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Question2Tests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    Question2.getDescription();
  }

  @Test
  public void NValues_1() {
    int[][] points = {{50, 50}, {100, 50}, {50, 200}, {100, 200}};
    boolean result = Question2.rectangleFound(points);
    System.out.format(
        "%s: The array contains prints that can form a rectangle: %s.\n",
        name.getMethodName(), result);
    assertTrue(result);
  }

  @Test
  public void NValues_2() {
    int[][] points = {{0, 0}, {50, 50}, {100, 50}, {50, 200}, {100, 200}, {120, 200}};
    boolean result = Question2.rectangleFound(points);
    System.out.format(
        "%s: The array contains prints that can form a rectangle: %s.\n",
        name.getMethodName(), result);
    assertTrue(result);
  }

  @Test
  public void NValues_3() {
    int[][] points = {{0, 0}, {100, 50}, {50, 200}, {100, 200}, {120, 200}};
    boolean result = Question2.rectangleFound(points);
    System.out.format(
        "%s: The array contains prints that can form a rectangle: %s.\n",
        name.getMethodName(), result);
    assertFalse(result);
  }
}
