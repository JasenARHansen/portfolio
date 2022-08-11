package Test.Interview.Facebook.practice;

import Code.Interview.Facebook.practice.MagicalCandyBags;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MagicalCandyBags_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void maxCandies_1() {
        int expected = 14;
        int[] values = {2, 1, 7, 4, 2};
        int k = 3;
        int result = MagicalCandyBags.maxCandies(values, k);
        System.out.format(
                "%s: After eating candy %d times from the candy bags '%s', %d pieces of candy have been eaten.\n",
                name.getMethodName(), k, Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void maxCandies_2() {
        int expected = 228;
        int[] values = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int k = 3;
        int result = MagicalCandyBags.maxCandies(values, k);
        System.out.format(
                "%s: After eating candy %d times from the candy bags '%s', %d pieces of candy have been eaten.\n",
                name.getMethodName(), k, Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
