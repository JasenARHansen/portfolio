package Java.test.interview.Facebook.interview.feb_1_2021;

import Java.code.interview.Facebook.interview.feb_8_2021.IsSorted;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IsSortedTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        IsSorted.getDescription();
    }

    @Test
    public void isBalanced_1() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'c', 'b', 'a'};
        String[] words = {"cc", "cb", "bc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_10() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {""};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_11() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"", "ab"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_12() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"ac", ""};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_2() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"cc", "cb", "bc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_3() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_4() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'c', 'b', 'a'};
        String[] words = {"", "cc", "cb", "bc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_5() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'c', 'b', 'a'};
        String[] words = {"ccc", "cb"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_6() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"ccc", "cc"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_7() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"cc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_8() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"cc", "cc"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_9() {
        printTestHeader(name.getMethodName());
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"ac", "cc"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format(
                "\tUsing the ordering array '%s' on the string array '%s', the array is sorted: %b\n",
                Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }
}
