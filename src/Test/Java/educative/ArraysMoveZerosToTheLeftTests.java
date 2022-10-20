package Test.Java.educative;

import Code.Java.Educative.ArraysMoveZeros;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArraysMoveZerosToTheLeftTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void moveZeros_1() {
        int[] expected = {0, 0, 0, 1, 2, 3, 4};
        int[] values = {1, 0, 2, 0, 0, 3, 4};
        int[] source = values.clone();
        ArraysMoveZeros.moveZerosLeft(source);
        System.out.format(
                "%s: The after shifting the zeros in array '%s' the array becomes '%s'.\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(source));
        assertEquals(Arrays.toString(expected), Arrays.toString(source));
    }

    @Test
    public void moveZeros_2() {
        int[] expected = {0, 0, 0, 1, 2, 5, 6, 3, 4};
        int[] values = {1, 0, 2, 0, 5, 6, 0, 3, 4};
        int[] source = values.clone();
        ArraysMoveZeros.moveZerosLeft(source);
        System.out.format(
                "%s: The after shifting the zeros in array '%s' the array becomes '%s'.\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(source));
        assertEquals(Arrays.toString(expected), Arrays.toString(source));
    }

    @Test
    public void moveZeros_3() {
        int[] expected = {1, 2, 3, 4, 0, 0, 0};
        int[] values = {1, 0, 2, 0, 0, 3, 4};
        int[] source = values.clone();
        ArraysMoveZeros.moveZerosRight(source);
        System.out.format(
                "%s: The after shifting the zeros in array '%s' the array becomes '%s'.\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(source));
        assertEquals(Arrays.toString(expected), Arrays.toString(source));
    }

    @Test
    public void moveZeros_4() {
        int[] expected = {1, 2, 5, 6, 3, 4, 0, 0, 0};
        int[] values = {1, 0, 2, 0, 5, 6, 0, 3, 4};
        int[] source = values.clone();
        ArraysMoveZeros.moveZerosRight(source);
        System.out.format(
                "%s: The after shifting the zeros in array '%s' the array becomes '%s'.\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(source));
        assertEquals(Arrays.toString(expected), Arrays.toString(source));
    }
}
