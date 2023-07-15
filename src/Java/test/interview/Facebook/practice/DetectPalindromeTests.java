package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.DetectPalindrome;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DetectPalindromeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        DetectPalindrome.getDescription();
    }

    @Test
    public void isPalindrome_1() {
        printTestHeader(name.getMethodName());
        String input = "A man, a plan, a canal: Panama";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format(
                "\tThe string '%s' is a palindrome ignoring non alpha numeric characters: %b\n",
                input, result);
        assertTrue(result);
    }

    @Test
    public void isPalindrome_2() {
        printTestHeader(name.getMethodName());
        String input = "race a car";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format(
                "\tThe string '%s' is a palindrome ignoring non alpha numeric characters: %b\n",
                input, result);
        assertFalse(result);
    }

    @Test
    public void isPalindrome_3() {
        printTestHeader(name.getMethodName());
        String input = "123   321";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format(
                "\tThe string '%s' is a palindrome ignoring non alpha numeric characters: %b\n",
                input, result);
        assertTrue(result);
    }

    @Test
    public void isPalindrome_4() {
        printTestHeader(name.getMethodName());
        String input = "123ab321";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format(
                "\tThe string '%s' is a palindrome ignoring non alpha numeric characters: %b\n",
                input, result);
        assertFalse(result);
    }
}
