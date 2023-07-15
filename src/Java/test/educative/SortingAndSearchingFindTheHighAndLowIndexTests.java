package Java.test.educative;

import Java.code.educative.SortingAndSearchingFindTheHighAndLowIndex;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortingAndSearchingFindTheHighAndLowIndexTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void find_index_1() {
        int expectedLow = 0;
        int expectedHigh = 0;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        int index = 1;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_10() {
        int expectedLow = 18;
        int expectedHigh = 23;
        printTestHeader(name.getMethodName());
        int[] values = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int index = 6;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_2() {
        int expectedLow = 1;
        int expectedHigh = 1;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        int index = 2;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_3() {
        int expectedLow = 2;
        int expectedHigh = 9;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        int index = 5;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_4() {
        int expectedLow = 10;
        int expectedHigh = 10;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20};
        int index = 20;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_5() {
        int expectedLow = 0;
        int expectedHigh = 2;
        printTestHeader(name.getMethodName());
        int[] values = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int index = 1;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_6() {
        int expectedLow = 3;
        int expectedHigh = 7;
        printTestHeader(name.getMethodName());
        int[] values = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int index = 2;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_7() {
        int expectedLow = 8;
        int expectedHigh = 10;
        printTestHeader(name.getMethodName());
        int[] values = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int index = 3;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_8() {
        int expectedLow = 11;
        int expectedHigh = 14;
        printTestHeader(name.getMethodName());
        int[] values = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int index = 4;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }

    @Test
    public void find_index_9() {
        int expectedLow = 15;
        int expectedHigh = 17;
        printTestHeader(name.getMethodName());
        int[] values = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int index = 5;
        int low = SortingAndSearchingFindTheHighAndLowIndex.find_low_index(values, index);
        int high = SortingAndSearchingFindTheHighAndLowIndex.find_high_index(values, index);
        System.out.format(
                "\tWhen searching for %d in data '%s', the low index %d is and the high index is %d.\n",
                index, Arrays.toString(values), low, high);
        assertEquals(expectedLow, low);
        assertEquals(expectedHigh, high);
    }
}
