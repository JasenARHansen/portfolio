package Java.test.interview.Google.jan_14_2021.interview_5;

import Java.code.interview.Google.jan_14_2021.interview_5.Prefix;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrefixTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Prefix.getDescription();
    }

    @Test
    public void longestPrefix_1() {
        String expected = "";
        printTestHeader(name.getMethodName());
        ArrayList<String> inputs =
                new ArrayList<>(List.of("abc", "bc", "ab", "abdabz123", "abe", "bz"));
        String result = Prefix.longestPrefix(inputs);
        assertNotEquals(result, expected);
        System.out.format(
                "\tlist %s has '%s' as its longest prefxes that at least half of the nodes share\n",
                inputs, result);
    }

    @Test
    public void longestPrefix_2() {
        String expected = "";
        printTestHeader(name.getMethodName());
        ArrayList<String> inputs = new ArrayList<>(List.of("a", "b"));
        String result = Prefix.longestPrefix(inputs);
        assertEquals(result, expected);
        System.out.format(
                "\tlist %s has '%s' as its longest prefxes that at least half of the nodes share\n",
                inputs, result);
    }

    @Test
    public void longestPrefix_3() {
        String expected = "No values provided";
        printTestHeader(name.getMethodName());
        String result = Prefix.longestPrefix(null);
        assertEquals(result, expected);
        System.out.format(
                "\tlist null has '%s' as its longest prefxes that at least half of the nodes share\n",
                result);
    }
}
