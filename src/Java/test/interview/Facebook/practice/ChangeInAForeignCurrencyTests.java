package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.code.interview.Facebook.practice.ChangeInAForeignCurrency;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangeInAForeignCurrencyTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    ChangeInAForeignCurrency.getDescription();
  }

  @Test
  public void canGetExactChange_1() {
    int[] denominations = {5, 10, 25, 100, 200};
    int targetMoney = 94;
    boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, denominations);
    System.out.format(
        "%s: Given the denominations '%s' the value %d can be given in exact change: %b\n",
        name.getMethodName(), Arrays.toString(denominations), targetMoney, result);
    assertFalse(result);
  }

  @Test
  public void canGetExactChange_2() {
    int[] denominations = {4, 17, 29};
    int targetMoney = 75;
    boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, denominations);
    System.out.format(
        "%s: Given the denominations '%s' the value %d can be given in exact change: %b\n",
        name.getMethodName(), Arrays.toString(denominations), targetMoney, result);
    assertTrue(result);
  }

  @Test
  public void canGetExactChange_3() {
    int[] denominations = {5, 29};
    int targetMoney = 59;
    boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, denominations);
    System.out.format(
        "%s: Given the denominations '%s' the value %d can be given in exact change: %b\n",
        name.getMethodName(), Arrays.toString(denominations), targetMoney, result);
    assertTrue(result);
  }
}
