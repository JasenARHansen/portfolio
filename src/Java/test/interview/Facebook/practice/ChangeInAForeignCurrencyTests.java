package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.ChangeInAForeignCurrency;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangeInAForeignCurrencyTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void canGetExactChange_1() {
        printTestHeader(name.getMethodName());
        int[] denominations = {5, 10, 25, 100, 200};
        int targetMoney = 94;
        boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, denominations);
        System.out.format(
                "\tGiven the denominations '%s' the value %d can be given in exact change: %b\n",
                Arrays.toString(denominations), targetMoney, result);
        assertFalse(result);
    }

    @Test
    public void canGetExactChange_2() {
        printTestHeader(name.getMethodName());
        int[] denominations = {4, 17, 29};
        int targetMoney = 75;
        boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, denominations);
        System.out.format(
                "\tGiven the denominations '%s' the value %d can be given in exact change: %b\n",
                Arrays.toString(denominations), targetMoney, result);
        assertTrue(result);
    }

    @Test
    public void canGetExactChange_3() {
        printTestHeader(name.getMethodName());
        int[] denominations = {5, 29};
        int targetMoney = 59;
        boolean result = ChangeInAForeignCurrency.canGetExactChange(targetMoney, denominations);
        System.out.format(
                "\tGiven the denominations '%s' the value %d can be given in exact change: %b\n",
                Arrays.toString(denominations), targetMoney, result);
        assertTrue(result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        ChangeInAForeignCurrency.getDescription();
    }
}
