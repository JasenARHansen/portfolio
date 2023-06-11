package Test.Java.Interview.Google.Jan_14_2021.interview_5;

import Java.Code.Interview.Google.Jan_14_2021.interview_5.Prefix;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SuppressWarnings({"SpellCheckingInspection", "ConstantConditions"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class prefix_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void longestPrefix_1() throws Exception {
        ArrayList<String> inputs =
                new ArrayList<>(List.of("abc", "bc", "ab", "abdabz123", "abe", "bz"));
        String result = Java.Code.Interview.Google.Jan_14_2021.interview_5.Prefix.longestPrefix(inputs);
        System.out.format(
                "%s: list %s has '%s' as its longest prefxes that at least half of the nodes share\n",
                name.getMethodName(), inputs, result);
        assertNotEquals(result, "");
    }

    @Test
    public void longestPrefix_2() throws Exception {
        ArrayList<String> inputs = new ArrayList<>(List.of("a", "b"));
        String result = Java.Code.Interview.Google.Jan_14_2021.interview_5.Prefix.longestPrefix(inputs);
        System.out.format(
                "%s: list %s has '%s' as its longest prefxes that at least half of the nodes share\n",
                name.getMethodName(), inputs, result);
        assertEquals(result, "");
    }

    @Test(expected = Exception.class)
    public void longestPrefix_3() throws Exception {
        Prefix.longestPrefix(null);
    }
}