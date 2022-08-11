package Test.Interview.Amazon.Assessment;

import Code.Interview.Amazon.Assessment.assessment_1;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SuppressWarnings({"rawtypes", "unchecked"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class assessment_1_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void isBalanced_1() {
    List<Integer> expected = new ArrayList<>(Arrays.asList(4, 5));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    ArrayList start = new ArrayList(start_original);
    List<Integer> result = assessment_1.minimalHeaviestSetA(start);
    System.out.format(
        "%s: The subset A of '%s' is '%s'\n", name.getMethodName(), start_original, result);
    assertEquals(expected, result);
  }

  @Test
  public void isBalanced_2() {
    List<Integer> expected = new ArrayList<>(Arrays.asList(6, 7));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(3, 6, 7, 4, 5));
    ArrayList start = new ArrayList(start_original);
    List<Integer> result = assessment_1.minimalHeaviestSetA(start);
    System.out.format(
        "%s: The subset A of '%s' is '%s'\n", name.getMethodName(), start_original, result);
    assertEquals(expected, result);
  }
}
