package Test.interview.Facebook.Feb_1_2021.practice;

import interview.Facebook.Feb_1_2021.practice.LookAndSay;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LookAndSay_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void lookAndSay_1() {
    String[] expected = {
            "11",
            "21",
            "1211",
            "111221",
            "312211",
            "13112221",
            "1113213211",
            "31131211131221",
            "13211311123113112211"
    };
    String start = "1";
    for (int index = 0; index < expected.length; index++) {
      String result = LookAndSay.lookAndSay(start);
      System.out.format(
              "%s: The Look and Say of '%s' is '%s'\n", name.getMethodName(), start, result);
      assertEquals(expected[index], result);
      start = result;
    }
  }

  @Test
  public void lookAndSay_2() {
    String[] expected = {
            "11",
            "21",
            "1211",
            "111221",
            "312211",
            "13112221",
            "1113213211"
    };
    int start = 1;
    for (int index = 0; index < expected.length; index++) {
      String result = LookAndSay.lookAndSay(start);
      System.out.format(
              "%s: The Look and Say of '%s' is '%s'\n", name.getMethodName(), start, result);
      assertEquals(expected[index], result);
      start = Integer.parseInt(result);
    }
  }
}
