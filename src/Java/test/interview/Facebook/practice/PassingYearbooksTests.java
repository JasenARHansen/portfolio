package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.PassingYearbooks;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PassingYearbooksTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findSignatureCounts_1() {
        int[] expected = {2, 2};
        printTestHeader(name.getMethodName());
        int[] values = {2, 1};
        int[] result = PassingYearbooks.findSignatureCounts(values);
        System.out.format(
                "\tThe yearbooks for the initial mix '%s' has the following number of signatures '%s'\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findSignatureCounts_2() {
        int[] expected = {1, 1};
        printTestHeader(name.getMethodName());
        int[] values = {1, 2};
        int[] result = PassingYearbooks.findSignatureCounts(values);
        System.out.format(
                "\tThe yearbooks for the initial mix '%s' has the following number of signatures '%s'\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        PassingYearbooks.getDescription();
    }
}
