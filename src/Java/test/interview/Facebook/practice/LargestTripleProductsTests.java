package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.LargestTripleProducts;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LargestTripleProductsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findMaxProduct_1() {
        int[] expected = {-1, -1, 6, 24, 60};
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LargestTripleProducts.findMaxProduct(values);
        System.out.format(
                "\tThe largest triple product '%s' has the following number of sub-arrays '%s'\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findMaxProduct_2() {
        int[] expected = {-1, -1, 4, 4, 8};
        printTestHeader(name.getMethodName());
        int[] values = {2, 1, 2, 1, 2};
        int[] result = LargestTripleProducts.findMaxProduct(values);
        System.out.format(
                "\tThe largest triple product '%s' has the following number of sub-arrays '%s'\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        LargestTripleProducts.getDescription();
    }
}
