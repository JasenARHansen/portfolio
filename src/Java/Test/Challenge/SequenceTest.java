package Java.Test.Challenge;

import static org.junit.Assert.assertEquals;

import Java.Code.Challenge.Sequence;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SequenceTest {

  @Rule public TestName name = new TestName();

  @Test
  public void Sequence() {
    System.out.format("%s: ", name.getMethodName());
    Sequence.getDescriptionFibonacci();
  }

  @Test
  public void getFibonacci_0() {
    int expected = 0;
    int count = 0;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_1() {
    int expected = 1;
    int count = 1;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_2() {
    int expected = 1;
    int count = 2;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_6() {
    int expected = 8;
    int count = 6;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_7() {
    int expected = 13;
    int count = 7;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_20() {
    int expected = 6765;
    int count = 20;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_1() {
    int expected = 1;
    int count = -1;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_2() {
    int expected = -1;
    int count = -2;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_3() {
    int expected = 2;
    int count = -3;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_7() {
    int expected = 13;
    int count = -7;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_8() {
    int expected = -21;
    int count = -8;
    int result = Sequence.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getPascalTriangleRow_0() {
    int row = 0;
    int expectedLength = row + 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
    assertEquals(expectedLength, result.size());
  }

  @Test
  public void getPascalTriangleRow_1() {
    int row = 1;
    int expectedLength = row + 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
    assertEquals(expectedLength, result.size());
  }

  @Test
  public void getPascalTriangleRow_2() {
    int row = 2;
    int expectedLength = row + 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
    assertEquals(expectedLength, result.size());
  }

  @Test
  public void getPascalTriangleRow_3() {
    int row = 3;
    int expectedLength = row + 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
    assertEquals(expectedLength, result.size());
  }

  @Test
  public void getPascalTriangleRow_7() {
    int row = 7;
    int expectedLength = row + 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
    assertEquals(expectedLength, result.size());
  }
}
