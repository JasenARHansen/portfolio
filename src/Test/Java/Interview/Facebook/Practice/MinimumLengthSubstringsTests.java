package Test.Java.Interview.Facebook.Practice;

import Code.Java.Interview.Facebook.Practice.MinimumLengthSubstrings;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinimumLengthSubstringsTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void MinimumLengthSubstrings() {
        System.out.format("%s: ", name.getMethodName());
        MinimumLengthSubstrings.getDescription();
    }

    @Test
    public void minLengthSubstring_1() {
        int expected = 5;
        String source = "dcbefebce";
        String target = "fd";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format("%s: The minimum number of characters in '%s' to have a potential substring of '%s' is %d\n", name.getMethodName(), source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_2() {
        int expected = 2;
        String source = "dcbefdebce";
        String target = "fd";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format("%s: The minimum number of characters in '%s' to have a potential substring of '%s' is %d\n", name.getMethodName(), source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_3() {
        int expected = -1;
        String source = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String target = "cbccfafebccdccebdd";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format("%s: The minimum number of characters in '%s' to have a potential substring of '%s' is %d\n", name.getMethodName(), source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_4() {
        int expected = 0;
        String source = "asdf";
        String target = "";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format("%s: The minimum number of characters in '%s' to have a potential substring of '%s' is %d\n", name.getMethodName(), source, target, result);
        assertEquals(expected, result);
    }

    @Test
    public void minLengthSubstring_5() {
        int expected = -1;
        String source = "as";
        String target = "asdf";
        int result = MinimumLengthSubstrings.minLengthSubstring(source, target);
        System.out.format("%s: The minimum number of characters in '%s' to have a potential substring of '%s' is %d\n", name.getMethodName(), source, target, result);
        assertEquals(expected, result);
    }
}
