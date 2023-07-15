package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.BalanceBrackets;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BalanceBracketsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        BalanceBrackets.getDescription();
    }

    @Test
    public void isBalanced_1() {
        printTestHeader(name.getMethodName());
        String input = "{[()]}";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("\tThe string '%s' is balanced: %b\n", input, result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_2() {
        printTestHeader(name.getMethodName());
        String input = "{}()";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("\tThe string '%s' is balanced: %b\n", input, result);
        assertTrue(result);
    }

    @Test
    public void isBalanced_3() {
        printTestHeader(name.getMethodName());
        String input = "{(})";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("\tThe string '%s' is balanced: %b\n", input, result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_4() {
        printTestHeader(name.getMethodName());
        String input = ")";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("\tThe string '%s' is balanced: %b\n", input, result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_5() {
        printTestHeader(name.getMethodName());
        String input = "(";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("\tThe string '%s' is balanced: %b\n", input, result);
        assertFalse(result);
    }

    @Test
    public void isBalanced_6() {
        printTestHeader(name.getMethodName());
        String input = "((3+5)   (1/2)) ";
        boolean result = BalanceBrackets.isBalanced(input);
        System.out.format("\tThe string '%s' is balanced: %b\n", input, result);
        assertTrue(result);
    }
}
