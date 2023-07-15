package Java.test.hackerrank.arrays;

import Java.code.hackerrank.arrays.LeftRotation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeftRotationTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void rotateLeft_1() {
        int[] expected = {2, 3, 4, 5, 1};
        printTestHeader(name.getMethodName());
        int rotations = 1;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_10() {
        int[] expected = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
        printTestHeader(name.getMethodName());
        int rotations = 10;
        int[] values = {77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_11() {
        int[] expected = {87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60};
        printTestHeader(name.getMethodName());
        int[] values = {33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
        int rotations = 13;
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_12() {
        int[] expected = {5, 1, 2, 3, 4};
        printTestHeader(name.getMethodName());
        int rotations = -1;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_13() {
        int[] expected = {};
        printTestHeader(name.getMethodName());
        int rotations = 0;
        int[] values = {};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_14() {
        int[] expected = {};
        printTestHeader(name.getMethodName());
        int rotations = 1;
        int[] values = {};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_15() {
        int[] expected = {1, 2, 3, 4, 5};
        printTestHeader(name.getMethodName());
        int rotations = 15;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_2() {
        int[] expected = {3, 4, 5, 1, 2};
        printTestHeader(name.getMethodName());
        int rotations = 2;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_3() {
        int[] expected = {4, 5, 1, 2, 3};
        printTestHeader(name.getMethodName());
        int rotations = 3;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_4() {
        int[] expected = {5, 1, 2, 3, 4};
        printTestHeader(name.getMethodName());
        int rotations = 4;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_5() {
        int[] expected = {1, 2, 3, 4, 5};
        printTestHeader(name.getMethodName());
        int rotations = 5;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_6() {
        int[] expected = {5, 1, 2, 3, 4};
        printTestHeader(name.getMethodName());
        int rotations = 24;
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_7() {
        int[] expected = {2, 3, 4, 5, 6, 1};
        printTestHeader(name.getMethodName());
        int rotations = 1;
        int[] values = {1, 2, 3, 4, 5, 6};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_8() {
        int[] expected = {3, 4, 5, 6, 1, 2};
        printTestHeader(name.getMethodName());
        int rotations = 2;
        int[] values = {1, 2, 3, 4, 5, 6};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }

    @Test
    public void rotateLeft_9() {
        int[] expected = {4, 5, 6, 1, 2, 3};
        printTestHeader(name.getMethodName());
        int rotations = 3;
        int[] values = {1, 2, 3, 4, 5, 6};
        int[] result = LeftRotation.rotateLeft(values, rotations);
        assertArrayEquals(expected, result);
        System.out.format(
                "\tThe largest array '%s' rotated left %d values is '%s'.\n",
                Arrays.toString(values), rotations, Arrays.toString(result));
    }
}
