package Test.Java.Interview.Facebook.Practice;

import Java.Code.Interview.Facebook.Practice.DetectPalindrome;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DetectPalindromeTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void DetectPalindrome() {
        System.out.format("%s: ", name.getMethodName());
        DetectPalindrome.getDescription();
    }

    @Test
    public void isPalindrome_1() {
        String input = "A man, a plan, a canal: Panama";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format("%s: The string '%s' is a palindrome ignoring non alpha numeric characters: %b\n", name.getMethodName(), input, result);
        assertTrue(result);
    }

    @Test
    public void isPalindrome_2() {
        String input = "race a car";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format("%s: The string '%s' is a palindrome ignoring non alpha numeric characters: %b\n", name.getMethodName(), input, result);
        assertFalse(result);
    }

    @Test
    public void isPalindrome_3() {
        String input = "123   321";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format("%s: The string '%s' is a palindrome ignoring non alpha numeric characters: %b\n", name.getMethodName(), input, result);
        assertTrue(result);
    }

    @Test
    public void isPalindrome_4() {
        String input = "123ab321";
        boolean result = DetectPalindrome.isPalindrome(input);
        System.out.format("%s: The string '%s' is a palindrome ignoring non alpha numeric characters: %b\n", name.getMethodName(), input, result);
        assertFalse(result);
    }
}
