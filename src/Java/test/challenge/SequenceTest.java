package Java.test.challenge;

import static org.junit.Assert.assertEquals;

import Java.code.challenge.Sequence;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SequenceTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    Sequence.getDescription();
  }

  @Test
  public void getFibonacci_0() {
    int expected = 0;
    int count = 0;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_1() {
    int expected = 1;
    int count = 1;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_2() {
    int expected = 1;
    int count = 2;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_6() {
    int expected = 8;
    int count = 6;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_7() {
    int expected = 13;
    int count = 7;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_20() {
    int expected = 6765;
    int count = 20;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_negative_1() {
    int expected = 1;
    int count = -1;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_negative_2() {
    int expected = -1;
    int count = -2;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_negative_3() {
    int expected = 2;
    int count = -3;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_negative_7() {
    int expected = 13;
    int count = -7;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getFibonacci_negative_8() {
    int expected = -21;
    int count = -8;
    int result = Sequence.getFibonacci(count);
    assertEquals(expected, result);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
  }

  @Test
  public void getPascalTriangleRow_0() {
    int expected = 1;
    int row = expected - 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    assertEquals(expected, result.size());
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
  }

  @Test
  public void getPascalTriangleRow_1() {
    int expected = 2;
    int row = expected - 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    assertEquals(expected, result.size());
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
  }

  @Test
  public void getPascalTriangleRow_2() {
    int expected = 3;
    int row = expected - 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    assertEquals(expected, result.size());
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
  }

  @Test
  public void getPascalTriangleRow_3() {
    int expected = 4;
    int row = expected - 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    assertEquals(expected, result.size());
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
  }

  @Test
  public void getPascalTriangleRow_7() {
    int expected = 8;
    int row = expected - 1;
    List<Integer> result = Sequence.getPascalTriangleRow(row);
    assertEquals(expected, result.size());
    System.out.format("%s: Pascal's Triangle Row %d is %s\n", name.getMethodName(), row, result);
  }
}
