package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.ShiftZeros;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShiftZerosTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void removeZeros_1() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] values = {1, 0, 2, 0, 0, 3, 4};
        int[] source = values.clone();
        int result = ShiftZeros.removeZeros(source);
        System.out.format(
                "\tThe after shifting the zeros in array '%s' the array becomes '%s' with %d non zero values\n",
                Arrays.toString(values), Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void removeZeros_2() {
        int expected = 6;
        printTestHeader(name.getMethodName());
        int[] values = {1, 0, 2, 0, 5, 6, 0, 3, 4};
        int[] source = values.clone();
        int result = ShiftZeros.removeZeros(source);
        System.out.format(
                "\tThe after shifting the zeros in array '%s' the array becomes '%s' with %d non zero values\n",
                Arrays.toString(values), Arrays.toString(source), result);
        assertEquals(expected, result);
    }
}
