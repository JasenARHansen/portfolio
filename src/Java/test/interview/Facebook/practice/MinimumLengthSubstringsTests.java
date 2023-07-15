package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.MinimumLengthSubstrings;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinimumLengthSubstringsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        MinimumLengthSubstrings.getDescription();
    }

    @Test
    public void minLengthSubstring_1() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        String source = "dcbefebce";
        String target = "fd";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format(
                "\tThe minimum number of characters in '%s' to have a potential substring of '%s' is %d\n",
                source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_2() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        String source = "dcbefdebce";
        String target = "fd";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format(
                "\tThe minimum number of characters in '%s' to have a potential substring of '%s' is %d\n",
                source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_3() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String source = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String target = "cbccfafebccdccebdd";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format(
                "\tThe minimum number of characters in '%s' to have a potential substring of '%s' is %d\n",
                source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_4() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        String source = "asdf";
        String target = "";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format(
                "\tThe minimum number of characters in '%s' to have a potential substring of '%s' is %d\n",
                source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_5() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String source = "as";
        String target = "asdf";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format(
                "\tThe minimum number of characters in '%s' to have a potential substring of '%s' is %d\n",
                source, target, result);
        assertEquals(expected, result);
    }
}
