package Test.interview.Facebook.Feb_1_2021.practice;

import interview.Facebook.Feb_1_2021.practice.ChangeInAForeignCurrency;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangeInAForeignCurrency_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void canGetExactChange_1() {
    int[] values = {5, 10, 25, 100, 200};
    int targetMoney = 94;
    boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, values);
    System.out.format(
            "%s: Given the denominations '%s' the value %d can be given in exact change: %b\n",
            name.getMethodName(), Arrays.toString(values), targetMoney, result);
    assertFalse(result);
  }

  @Test
  public void canGetExactChange_2() {
    int[] values = {4, 17, 29};
    int targetMoney = 75;
    boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, values);
    System.out.format(
            "%s: Given the denominations '%s' the value %d can be given in exact change: %b\n",
            name.getMethodName(), Arrays.toString(values), targetMoney, result);
    assertTrue(result);
  }
}
