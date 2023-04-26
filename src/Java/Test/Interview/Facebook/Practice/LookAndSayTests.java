package Test.Java.Interview.Facebook.Practice;

import Java.Code.Interview.Facebook.Practice.LookAndSay;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LookAndSayTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void LookAndSay() {
        System.out.format("%s: ", name.getMethodName());
        LookAndSay.getDescription();
    }

    @Test
    public void lookAndSay_1() {
        String[] expected = {"11", "21", "1211", "111221", "312211", "13112221", "1113213211", "31131211131221", "13211311123113112211"};
        String start = "1";
        for (String s : expected) {
            String result = LookAndSay.lookAndSay(start);
            System.out.format("%s: The Look and Say of '%s' is '%s'\n", name.getMethodName(), start, result);
            assertEquals(s, result);
            start = result;
        }
    }

    @Test
    public void lookAndSay_2() {
        String[] expected = {"11", "21", "1211", "111221", "312211", "13112221", "1113213211"};
        int start = 1;
        for (String s : expected) {
            String result = LookAndSay.lookAndSay(start);
            System.out.format("%s: The Look and Say of '%s' is '%s'\n", name.getMethodName(), start, result);
            assertEquals(s, result);
            start = Integer.parseInt(result);
        }
    }

    @Test
    public void lookAndSayReverse_1() {
        String[] expected = {"31131211131221", "1113213211", "13112221", "312211", "111221", "1211", "21", "11", "1", ""};
        String start = "13211311123113112211";
        for (String s : expected) {
            String result = LookAndSay.lookAndSayReverse(start);
            System.out.format("%s: The Look and Say Reverse of '%s' is '%s'\n", name.getMethodName(), start, result);
            assertEquals(s, result);
            start = result;
        }
    }

    @Test
    public void lookAndSayReverse_2() {
        String[] expected = {"13112221", "312211", "111221", "1211", "21", "11", "1"};
        int start = 1113213211;
        for (String s : expected) {
            String result = LookAndSay.lookAndSayReverse(start);
            System.out.format("%s: The Look and Say of '%s' is '%s'\n", name.getMethodName(), start, result);
            assertEquals(s, result);
            start = Integer.parseInt(result);
        }
    }

}
