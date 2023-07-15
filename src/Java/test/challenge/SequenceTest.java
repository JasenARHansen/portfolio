package Java.test.challenge;

import Java.code.challenge.Sequence;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SequenceTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Sequence.getDescription();
    }

    @Test
    public void getFibonacci_0() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int count = 0;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_1() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int count = 1;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_2() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int count = 2;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_20() {
        int expected = 6765;
        printTestHeader(name.getMethodName());
        int count = 20;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_6() {
        int expected = 8;
        printTestHeader(name.getMethodName());
        int count = 6;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_7() {
        int expected = 13;
        printTestHeader(name.getMethodName());
        int count = 7;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_negative_1() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int count = -1;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_negative_2() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        int count = -2;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_negative_3() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int count = -3;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_negative_7() {
        int expected = 13;
        printTestHeader(name.getMethodName());
        int count = -7;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getFibonacci_negative_8() {
        int expected = -21;
        printTestHeader(name.getMethodName());
        int count = -8;
        int result = Sequence.getFibonacci(count);
        assertEquals(expected, result);
        System.out.format("\tFibonacci number %d is %d\n", count, result);
    }

    @Test
    public void getPascalTriangleRow_0() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int row = expected - 1;
        List<Integer> result = Sequence.getPascalTriangleRow(row);
        assertEquals(expected, result.size());
        System.out.format("\tPascal's Triangle Row %d is %s\n", row, result);
    }

    @Test
    public void getPascalTriangleRow_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int row = expected - 1;
        List<Integer> result = Sequence.getPascalTriangleRow(row);
        assertEquals(expected, result.size());
        System.out.format("\tPascal's Triangle Row %d is %s\n", row, result);
    }

    @Test
    public void getPascalTriangleRow_2() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int row = expected - 1;
        List<Integer> result = Sequence.getPascalTriangleRow(row);
        assertEquals(expected, result.size());
        System.out.format("\tPascal's Triangle Row %d is %s\n", row, result);
    }

    @Test
    public void getPascalTriangleRow_3() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int row = expected - 1;
        List<Integer> result = Sequence.getPascalTriangleRow(row);
        assertEquals(expected, result.size());
        System.out.format("\tPascal's Triangle Row %d is %s\n", row, result);
    }

    @Test
    public void getPascalTriangleRow_7() {
        int expected = 8;
        printTestHeader(name.getMethodName());
        int row = expected - 1;
        List<Integer> result = Sequence.getPascalTriangleRow(row);
        assertEquals(expected, result.size());
        System.out.format("\tPascal's Triangle Row %d is %s\n", row, result);
    }
}
