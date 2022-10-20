package Test.Java.Interview.Facebook.Practice;

import Code.Java.Interview.Facebook.Practice.ShiftZeros;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShiftZeros_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void removeZeros_1() {
        int expected = 4;
        int[] values = {1, 0, 2, 0, 0, 3, 4};
        int[] source = values.clone();
        int result = ShiftZeros.removeZeros(source);
        System.out.format(
                "%s: The after shifting the zeros in array '%s' the array becomes '%s' with %d non zero values\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void removeZeros_2() {
        int expected = 6;
        int[] values = {1, 0, 2, 0, 5, 6, 0, 3, 4};
        int[] source = values.clone();
        int result = ShiftZeros.removeZeros(source);
        System.out.format(
                "%s: The after shifting the zeros in array '%s' the array becomes '%s' with %d non zero values\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(source), result);
        assertEquals(expected, result);
    }
}
