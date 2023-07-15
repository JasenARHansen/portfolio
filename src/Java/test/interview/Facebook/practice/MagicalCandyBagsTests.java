package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.MagicalCandyBags;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MagicalCandyBagsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        MagicalCandyBags.getDescription();
    }

    @Test
    public void maxCandies_1() {
        int expected = 14;
        printTestHeader(name.getMethodName());
        int[] values = {2, 1, 7, 4, 2};
        int k = 3;
        int result = MagicalCandyBags.maxCandies(values, k);
        System.out.format(
                "\tAfter eating candy %d times from the candy bags '%s', %d pieces of candy have been eaten.\n",
                k, Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void maxCandies_2() {
        int expected = 228;
        printTestHeader(name.getMethodName());
        int[] values = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int k = 3;
        int result = MagicalCandyBags.maxCandies(values, k);
        System.out.format(
                "\tAfter eating candy %d times from the candy bags '%s', %d pieces of candy have been eaten.\n",
                k, Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
