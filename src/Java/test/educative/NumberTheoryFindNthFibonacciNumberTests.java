package Java.test.educative;

import Java.code.educative.NumberTheoryFindNthFibonacciNumber;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumberTheoryFindNthFibonacciNumberTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getFibonacci_0() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int count = 0;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_1() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int count = 1;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_2() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int count = 2;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_20() {
        int expected = 6765;
        printTestHeader(name.getMethodName());
        int count = 20;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_6() {
        int expected = 8;
        printTestHeader(name.getMethodName());
        int count = 6;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_7() {
        int expected = 13;
        printTestHeader(name.getMethodName());
        int count = 7;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_negative_1() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int count = -1;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_negative_2() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        int count = -2;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_negative_3() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int count = -3;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_negative_7() {
        int expected = 13;
        printTestHeader(name.getMethodName());
        int count = -7;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getFibonacci_negative_8() {
        int expected = -21;
        printTestHeader(name.getMethodName());
        int count = -8;
        int result = NumberTheoryFindNthFibonacciNumber.getFibonacci(count);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
        assertEquals(expected, result);
    }
}
