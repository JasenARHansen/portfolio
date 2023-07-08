package Java.Test.Educative;

import static org.junit.Assert.assertEquals;

import Java.Code.Educative.NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch;
import java.text.DecimalFormat;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearchTests {

  @Rule public TestName name = new TestName();

  @Test
  public void squareRoot_1() {
    double expected = 2;
    int number = 4;
    int precision = 2;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    float result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.squareRoot(
            number, precision);
    System.out.format(
        "%s: The square root of %d is %s.\n", name.getMethodName(), number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }

  @Test
  public void squareRoot_2() {
    double expected = 7.071;
    int number = 50;
    int precision = 3;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    double result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.squareRoot(
            number, precision);
    System.out.format(
        "%s: The square root of %d is %s.\n", name.getMethodName(), number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }

  @Test
  public void squareRoot_3() {
    double expected = 3.1622;
    int number = 10;
    int precision = 4;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    double result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.squareRoot(
            number, precision);
    System.out.format(
        "%s: The square root of %d is %s.\n", name.getMethodName(), number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }

  @Test
  public void nThRoot_1() {
    double expected = 2;
    int number = 4;
    int root = 2;
    int precision = 2;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    float result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
            number, root, precision);
    System.out.format(
        "%s: The %d root of %d is %s.\n",
        name.getMethodName(), root, number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }

  @Test
  public void nThRoot_2() {
    double expected = 7.071;
    int number = 50;
    int root = 2;
    int precision = 3;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    float result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
            number, root, precision);
    System.out.format(
        "%s: The %d root of %d is %s.\n",
        name.getMethodName(), root, number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }

  @Test
  public void nThRoot_3() {
    double expected = 3.1622;
    int number = 10;
    int root = 2;
    int precision = 4;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    float result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
            number, root, precision);
    System.out.format(
        "%s: The %d root of %d is %s.\n",
        name.getMethodName(), root, number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }

  @Test
  public void nThRoot_4() {
    double expected = 2;
    int number = 8;
    int root = 3;
    int precision = 4;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    float result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
            number, root, precision);
    System.out.format(
        "%s: The %d root of %d is %s.\n",
        name.getMethodName(), root, number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }

  @Test
  public void nThRoot_5() {
    double expected = 3.6840;
    int number = 50;
    int root = 3;
    int precision = 3;
    DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
    float result =
        NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
            number, root, precision);
    System.out.format(
        "%s: The %d root of %d is %s.\n",
        name.getMethodName(), root, number, format.format(result));
    assertEquals(expected, result, 0.0001);
  }
}
