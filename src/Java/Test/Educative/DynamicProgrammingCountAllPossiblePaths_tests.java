package Java.Test.Educative;

import Java.Code.Educative.DynamicProgrammingCountAllPossiblePaths;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicProgrammingCountAllPossiblePaths_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void uniquePaths_1() {
    int expected = 28;
    int m = 3;
    int n = 7;
    int result = DynamicProgrammingCountAllPossiblePaths.uniquePaths(m, n);
    System.out.format(
            "%s: Given the prices %d by %d matrix, there are %d unique paths.\n",
            name.getMethodName(), m, n, result);
    assertEquals(expected, result);
  }

  @Test
  public void uniquePaths_2() {
    int expected = 3;
    int m = 3;
    int n = 2;
    int result = DynamicProgrammingCountAllPossiblePaths.uniquePaths(m, n);
    System.out.format(
            "%s: Given the prices %d by %d matrix, there are %d unique paths.\n",
            name.getMethodName(), m, n, result);
    assertEquals(expected, result);
  }

  @Test
  public void uniquePaths_3() {
    int expected = 6;
    int m = 3;
    int n = 3;
    int result = DynamicProgrammingCountAllPossiblePaths.uniquePaths(m, n);
    System.out.format(
            "%s: Given the prices %d by %d matrix, there are %d unique paths.\n",
            name.getMethodName(), m, n, result);
    assertEquals(expected, result);
  }
}
