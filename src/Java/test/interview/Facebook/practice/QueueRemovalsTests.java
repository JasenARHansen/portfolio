package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertArrayEquals;

import Java.code.interview.Facebook.practice.QueueRemovals;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueRemovalsTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    QueueRemovals.getDescription();
  }

  @Test
  public void findPositions_1() {
    int[] expected = {5, 6, 4, 1, 2};
    int x = 5;
    int[] array = {1, 2, 2, 3, 4, 5};
    int[] result = QueueRemovals.findPositions(array, x);
    System.out.format(
        "%s: The array '%s' with %d iterations becomes '%s'\n",
        name.getMethodName(), Arrays.toString(array), x, Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void findPositions_2() {
    int[] expected = {2, 5, 10, 13};
    int x = 4;
    int[] array = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    int[] result = QueueRemovals.findPositions(array, x);
    System.out.format(
        "%s: The array '%s' with %d iterations becomes '%s'\n",
        name.getMethodName(), Arrays.toString(array), x, Arrays.toString(result));
    assertArrayEquals(expected, result);
  }
}
