package Java.test.hackerrank.warmUpChallenges;

import Java.code.hackerrank.warmUpChallenges.RepeatedString;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepeatedStringTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void repeatedString_1() {
        long expected = 4;
        printTestHeader(name.getMethodName());
        long count = 10;
        String string = "abcac";
        long result = RepeatedString.repeatedString(string, count);
        System.out.format(
                "\tIn the first %d characters of the repeated string '%s' the character 'a' appears %d times.\n",
                count, string, result);
        assertEquals(expected, result);
    }

    @Test
    public void repeatedString_2() {
        long expected = 7;
        printTestHeader(name.getMethodName());
        long count = 10;
        String string = "aba";
        long result = RepeatedString.repeatedString(string, count);
        System.out.format(
                "\tIn the first %d characters of the repeated string '%s' the character 'a' appears %d times.\n",
                count, string, result);
        assertEquals(expected, result);
    }

    @Test
    public void repeatedString_3() {
        long expected = 1000000000000L;
        printTestHeader(name.getMethodName());
        long count = 1000000000000L;
        String string = "a";
        long result = RepeatedString.repeatedString(string, count);
        System.out.format(
                "\tIn the first %d characters of the repeated string '%s' the character 'a' appears %d times.\n",
                count, string, result);
        assertEquals(expected, result);
    }
}
