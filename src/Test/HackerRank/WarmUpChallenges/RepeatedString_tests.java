package Test.HackerRank.WarmUpChallenges;

import Code.HackerRank.WarmUpChallenges.RepeatedString;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepeatedString_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void repeatedString_1() {
        long expected = 4;
        long count = 10;
        String string = "abcac";
        long result = RepeatedString.repeatedString(string, count);
        System.out.format(
                "%s: In the first %d characters of the repeated string '%s' the character 'a' appears %d times.\n",
                name.getMethodName(), count, string, result);
        assertEquals(expected, result);
    }

    @Test
    public void repeatedString_2() {
        long expected = 7;
        long count = 10;
        String string = "aba";
        long result = RepeatedString.repeatedString(string, count);
        System.out.format(
                "%s: In the first %d characters of the repeated string '%s' the character 'a' appears %d times.\n",
                name.getMethodName(), count, string, result);
        assertEquals(expected, result);
    }

    @Test
    public void repeatedString_3() {
        long expected = 1000000000000L;
        long count = 1000000000000L;
        String string = "a";
        long result = RepeatedString.repeatedString(string, count);
        System.out.format(
                "%s: In the first %d characters of the repeated string '%s' the character 'a' appears %d times.\n",
                name.getMethodName(), count, string, result);
        assertEquals(expected, result);
    }
}
