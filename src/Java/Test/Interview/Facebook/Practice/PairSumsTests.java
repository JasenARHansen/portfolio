package Java.Test.Interview.Facebook.Practice;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Facebook.Practice.PairSums;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PairSumsTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void PairSums() {
        System.out.format("%s: ", name.getMethodName());
        PairSums.getDescription();
    }

    @Test
    public void numberOfWays_1() {
        int sum = 6;
        int expected = 2;
        int[] values = {1, 2, 3, 4, 5};
        int result = PairSums.numberOfWays(values, sum);
        System.out.format("%s: The array %s has %d pairs that sum to %d\n", name.getMethodName(), Arrays.toString(values), result, sum);
        assertEquals(expected, result);
    }

    @Test
    public void numberOfWays_2() {
        int sum = 6;
        int expected = 4;
        int[] values = {1, 5, 3, 3, 3};
        int result = PairSums.numberOfWays(values, sum);
        System.out.format("%s: The array %s has %d pairs that sum to %d\n", name.getMethodName(), Arrays.toString(values), result, sum);
        assertEquals(expected, result);
    }

    @Test
    public void numberOfWays_3() {
        int sum = 7;
        int expected = 0;
        int[] values = {1, 5, 3, 3, 3};
        int result = PairSums.numberOfWays(values, sum);
        System.out.format("%s: The array %s has %d pairs that sum to %d\n", name.getMethodName(), Arrays.toString(values), result, sum);
        assertEquals(expected, result);
    }
}
