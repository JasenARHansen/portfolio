package Java.Test.Educative;

import Java.Code.Educative.SortingAndSearchingSearchRotatedArray;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sortingAndSearchingSearchRotatedArrayTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void binary_search_rotated_1() {
        int[] values = {
                176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162
        };
        for (int index = 0; index < values.length; index++) {
            int result =
                    SortingAndSearchingSearchRotatedArray.binary_search_rotated(values, values[index]);
            System.out.format(
                    "%s: When searching for %d in data '%s', the result index is %d.\n",
                    name.getMethodName(), values[index], Arrays.toString(values), result);
            assertEquals(index, result);
        }
    }

    @Test
    public void binary_search_rotated_2() {
        int[] values = {1, 2, 3, 4, 5};
        for (int index = 0; index < values.length; index++) {
            int result =
                    SortingAndSearchingSearchRotatedArray.binary_search_rotated(values, values[index]);
            System.out.format(
                    "%s: When searching for %d in data '%s', the result index is %d.\n",
                    name.getMethodName(), values[index], Arrays.toString(values), result);
            assertEquals(index, result);
        }
    }

    @Test
    public void binary_search_rotated_3() {
        int[] values = {3, 4, 5, 1, 2};
        for (int index = 0; index < values.length; index++) {
            int result =
                    SortingAndSearchingSearchRotatedArray.binary_search_rotated(values, values[index]);
            System.out.format(
                    "%s: When searching for %d in data '%s', the result index is %d.\n",
                    name.getMethodName(), values[index], Arrays.toString(values), result);
            assertEquals(index, result);
        }
    }
}
