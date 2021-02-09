package Test.interview.Facebook.practice;

import Code.interview.Facebook.practice.BalanceBrackets;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BalanceBrackets_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void isBalanced_1() {
        String input = "{[()]}";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("%s: The string '%s' is balanced: %b\n", name.getMethodName(), input, result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_2() {
        String input = "{}()";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("%s: The string '%s' is balanced: %b\n", name.getMethodName(), input, result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_3() {
        String input = "{(})";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("%s: The string '%s' is balanced: %b\n", name.getMethodName(), input, result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_4() {
        String input = ")";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("%s: The string '%s' is balanced: %b\n", name.getMethodName(), input, result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_5() {
        String input = "(";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("%s: The string '%s' is balanced: %b\n", name.getMethodName(), input, result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_6() {
        String input = "((3+5) * (1/2)) ";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("%s: The string '%s' is balanced: %b\n", name.getMethodName(), input, result);
        assertTrue(result);
    }
}
