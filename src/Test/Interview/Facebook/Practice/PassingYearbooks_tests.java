package Test.Interview.Facebook.Practice;

import Code.Interview.Facebook.Practice.PassingYearbooks;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PassingYearbooks_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void findSignatureCounts_1() {
        int[] expected = {2, 2};
        int[] values = {2, 1};
        int[] result = PassingYearbooks.findSignatureCounts(values);
        System.out.format(
                "%s: The yearbooks for the initial mix '%s' has the following number of signatures '%s'\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void findSignatureCounts_2() {
        int[] expected = {1, 1};
        int[] values = {1, 2};
        int[] result = PassingYearbooks.findSignatureCounts(values);
        System.out.format(
                "%s: The yearbooks for the initial mix '%s' has the following number of signatures '%s'\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
