package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.MatchingPairs;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MatchingPairsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        MatchingPairs.getDescription();
    }

    @Test
    public void matchingPairs_1() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        String first = "abcd";
        String second = "adcb";
        int result = MatchingPairs.matchingPairs(first, second);
        System.out.format(
                "\tComparing '%s' to '%s' after exchanging 2 characters in '%s' results in %d matches\n",
                first, second, second, result);
        assertEquals(expected, result);
    }

    @Test
    public void matchingPairs_2() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        String first = "mno";
        String second = "mno";
        int result = MatchingPairs.matchingPairs(first, second);
        System.out.format(
                "\tComparing '%s' to '%s' after exchanging 2 characters in '%s' results in %d matches\n",
                first, second, second, result);
        assertEquals(expected, result);
    }

    @Test
    public void matchingPairs_3() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        String first = "abcde";
        String second = "adcbe";
        int result = MatchingPairs.matchingPairs(first, second);
        System.out.format(
                "\tComparing '%s' to '%s' after exchanging 2 characters in '%s' results in %d matches\n",
                first, second, second, result);
        assertEquals(expected, result);
    }

    @Test
    public void matchingPairs_4() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        String first = "abcd";
        String second = "abcd";
        int result = MatchingPairs.matchingPairs(first, second);
        System.out.format(
                "\tComparing '%s' to '%s' after exchanging 2 characters in '%s' results in %d matches\n",
                first, second, second, result);
        assertEquals(expected, result);
    }
}
