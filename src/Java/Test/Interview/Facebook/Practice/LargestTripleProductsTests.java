package Java.Test.Interview.Facebook.Practice;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Facebook.Practice.LargestTripleProducts;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LargestTripleProductsTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void LargestTripleProducts() {
        System.out.format("%s: ", name.getMethodName());
        LargestTripleProducts.getDescription();
    }

    @Test
    public void findMaxProduct_1() {
        int[] expected = {-1, -1, 6, 24, 60};
        int[] values = {1, 2, 3, 4, 5};
        int[] result = LargestTripleProducts.findMaxProduct(values);
        System.out.format("%s: The largest triple product '%s' has the following number of sub-arrays '%s'\n", name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void findMaxProduct_2() {
        int[] expected = {-1, -1, 4, 4, 8};
        int[] values = {2, 1, 2, 1, 2};
        int[] result = LargestTripleProducts.findMaxProduct(values);
        System.out.format("%s: The largest triple product '%s' has the following number of sub-arrays '%s'\n", name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
