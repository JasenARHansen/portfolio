package Java.test.interview.Amazon.assessment.question1;

import static org.junit.Assert.assertEquals;

import Java.code.interview.Amazon.assessment.question1.Fulfillment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FulfillmentTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    Fulfillment.getDescription();
  }

  @Test
  public void isBalanced_1() {
    List<Integer> expected = new ArrayList<>(Arrays.asList(4, 5));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> result = Fulfillment.minimalHeaviestSetA(start);
    System.out.format(
        "%s: The subset A of '%s' is '%s'\n", name.getMethodName(), start_original, result);
    assertEquals(expected, result);
  }

  @Test
  public void isBalanced_2() {
    List<Integer> expected = new ArrayList<>(Arrays.asList(6, 7));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(3, 6, 7, 4, 5));
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> result = Fulfillment.minimalHeaviestSetA(start);
    System.out.format(
        "%s: The subset A of '%s' is '%s'\n", name.getMethodName(), start_original, result);
    assertEquals(expected, result);
  }

  @Test
  public void isBalanced_3() {
    List<Integer> expected = new ArrayList<>(Arrays.asList(6, 7));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(3, 7, 5, 6, 2));
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> result = Fulfillment.minimalHeaviestSetA(start);
    System.out.format(
        "%s: The subset A of '%s' is '%s'\n", name.getMethodName(), start_original, result);
    assertEquals(expected, result);
  }
}
