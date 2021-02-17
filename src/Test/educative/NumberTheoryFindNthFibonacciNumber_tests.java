package Test.educative;

import Code.educative.NumberTheoryFindNthFibonacciNumber;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumberTheoryFindNthFibonacciNumber_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void getFibonacci_0() {
    int expected = 0;
    int count = 0;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_1() {
    int expected = 1;
    int count = 1;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_2() {
    int expected = 1;
    int count = 2;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_6() {
    int expected = 8;
    int count = 6;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_7() {
    int expected = 13;
    int count = 7;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_20() {
    int expected = 6765;
    int count = 20;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_1() {
    int expected = 1;
    int count = -1;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_2() {
    int expected = -1;
    int count = -2;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_3() {
    int expected = 2;
    int count = -3;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_7() {
    int expected = 13;
    int count = -7;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }

  @Test
  public void getFibonacci_negative_8() {
    int expected = -21;
    int count = -8;
    int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
    System.out.format("%s: Fibonacci number %d is %d\n", name.getMethodName(), count, result);
    assertEquals(expected, result);
  }
}
