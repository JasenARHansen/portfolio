package Java.test.interview.Facebook.interview.mar_25_2021;

import Java.code.interview.Facebook.interview.mar_25_2021.Question3;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Question3Tests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void addString_1() {
        String expected = "2345";
        printTestHeader(name.getMethodName());
        String a = "1234";
        String b = "1111";
        String result = Question3.addString(a, b);
        System.out.format("\tValue '%s' plus '%s' is '%s'.\n", a, b, result);
        assertEquals(expected, result);
    }

    @Test
    public void addString_2() {
        String expected = "1098";
        printTestHeader(name.getMethodName());
        String a = "99";
        String b = "999";
        String result = Question3.addString(a, b);
        System.out.format("\tValue '%s' plus '%s' is '%s'.\n", a, b, result);
        assertEquals(expected, result);
    }

    @Test
    public void addString_3() {
        String expected = "1000";
        printTestHeader(name.getMethodName());
        String a = "1";
        String b = "999";
        String result = Question3.addString(a, b);
        System.out.format("\tValue '%s' plus '%s' is '%s'.\n", a, b, result);
        assertEquals(expected, result);
    }

    @Test
    public void almostSorted_1() {
        printTestHeader(name.getMethodName());
        int k = 3;
        int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] source = {1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] arr = source.clone();
        Question3.almostSorted(arr, k);
        System.out.format(
                "\tThe after sorting the partially sorted array '%s' with k as %d the array becomes '%s'.\n",
                Arrays.toString(source), k, Arrays.toString(arr));
        assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
    }

    @Test
    public void almostSorted_2() {
        printTestHeader(name.getMethodName());
        int k = 3;
        int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] source = {0, 1, 2, 3, 6, 4, 5, 7, 8, 9, 10, 11, 12};
        int[] arr = source.clone();
        Question3.almostSorted(arr, k);
        System.out.format(
                "\tThe after sorting the partially sorted array '%s' with k as %d the array becomes '%s'.\n",
                Arrays.toString(source), k, Arrays.toString(arr));
        assertEquals(Arrays.toString(sorted), Arrays.toString(arr));
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Question3.getDescription();
    }
}
