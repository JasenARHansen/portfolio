package Java.test.educative;

import Java.code.educative.StringImplementStrStr;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringImplementStrStrTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void strStr_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        String haystack = "hello";
        String needle = "ll";
        int result = StringImplementStrStr.strStr(haystack, needle);
        System.out.format(
                "\tThe needle '%s' can be found in haystack '%s' at index %d.\n", needle, haystack, result);
        assertEquals(expected, result);
    }

    @Test
    public void strStr_2() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String haystack = "aaaaa";
        String needle = "bba";
        int result = StringImplementStrStr.strStr(haystack, needle);
        System.out.format(
                "\tThe needle '%s' can be found in haystack '%s' at index %d.\n", needle, haystack, result);
        assertEquals(expected, result);
    }

    @Test
    public void strStr_3() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        String haystack = "";
        String needle = "";
        int result = StringImplementStrStr.strStr(haystack, needle);
        System.out.format(
                "\tThe needle '%s' can be found in haystack '%s' at index %d.\n", needle, haystack, result);
        assertEquals(expected, result);
    }
}
