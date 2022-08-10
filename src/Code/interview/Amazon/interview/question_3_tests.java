package Code.interview.Amazon.interview;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class question_3_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void convert_1() {
        String[][] rules = {{"b", "1", "4"}, {"i", "2", "3"}};
        String input = "hello";
        String expected = "h<b>e<i>ll</i>o</b>";
        String result = question_3.convert(input, rules);
        System.out.format("%s: %s converts to %s\n", name.getMethodName(), input, result);
        assertEquals(expected, result);
    }

    @Test
    public void convert_2() {
        String[][] rules = {{"b", "1", "2"}, {"i", "2", "3"}};
        String input = "hello";
        String expected = "h<b>e<i>l</i></b><i>l</i>o";
        String result = question_3.convert(input, rules);
        System.out.format("%s: %s converts to %s\n", name.getMethodName(), input, result);
        assertEquals(expected, result);
    }
}
