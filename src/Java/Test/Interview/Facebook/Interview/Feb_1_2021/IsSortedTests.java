package Test.Java.Interview.Facebook.Interview.Feb_1_2021;

import Java.Code.Interview.Facebook.Interview.Feb_8_2021.IsSorted;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IsSortedTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void IsSorted() {
        System.out.format("%s: ", name.getMethodName());
        IsSorted.getDescription();
    }

    @Test
    public void isBalanced_1() {
        char[] ordering = {'c', 'b', 'a'};
        String[] words = {"cc", "cb", "bc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_2() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"cc", "cb", "bc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_3() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_4() {
        char[] ordering = {'c', 'b', 'a'};
        String[] words = {"", "cc", "cb", "bc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_5() {
        char[] ordering = {'c', 'b', 'a'};
        String[] words = {"ccc", "cb"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }


    @Test
    public void isBalanced_6() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"ccc", "cc"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_7() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"cc", "ac"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_8() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"cc", "cc"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_9() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"ac", "cc"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_10() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {""};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_11() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"", "ab"};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_12() {
        char[] ordering = {'b', 'c', 'a'};
        String[] words = {"ac", ""};
        boolean result = IsSorted.isSorted(ordering, words);
        System.out.format("%s: Using the ordering array '%s' on the string array '%s', the array is sorted: %b\n", name.getMethodName(), Arrays.toString(ordering), Arrays.toString(words), result);
        assertFalse(result);
    }
}
