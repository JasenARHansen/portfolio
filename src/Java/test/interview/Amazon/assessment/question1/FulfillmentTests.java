package Java.test.interview.Amazon.assessment.question1;

import Java.code.interview.Amazon.assessment.question1.Fulfillment;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FulfillmentTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Fulfillment.getDescription();
    }

    @Test
    public void isBalanced_1() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 5));
        printTestHeader(name.getMethodName());
        List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> result = Fulfillment.minimalHeaviestSetA(start);
        System.out.format(
                "\tThe subset A of '%s' is '%s'\n", start_original, result);
        assertEquals(expected, result);
    }

    @Test
    public void isBalanced_2() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 7));
        printTestHeader(name.getMethodName());
        List<Integer> start_original = new ArrayList<>(Arrays.asList(3, 6, 7, 4, 5));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> result = Fulfillment.minimalHeaviestSetA(start);
        System.out.format(
                "\tThe subset A of '%s' is '%s'\n", start_original, result);
        assertEquals(expected, result);
    }

    @Test
    public void isBalanced_3() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 7));
        printTestHeader(name.getMethodName());
        List<Integer> start_original = new ArrayList<>(Arrays.asList(3, 7, 5, 6, 2));
        List<Integer> start = new ArrayList<>(start_original);
        List<Integer> result = Fulfillment.minimalHeaviestSetA(start);
        System.out.format(
                "\tThe subset A of '%s' is '%s'\n", start_original, result);
        assertEquals(expected, result);
    }
}
