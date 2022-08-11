package Test.Interview.Facebook.practice;

import Code.Interview.Facebook.practice.EncryptedWords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EncryptedWords_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void findEncryptedWord_1() {
        String expected = "bac";
        String input = "abc";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "%s: The value '%s' is encrypted as '%s'\n", name.getMethodName(), input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findEncryptedWord_2() {
        String expected = "bacd";
        String input = "abcd";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "%s: The value '%s' is encrypted as '%s'\n", name.getMethodName(), input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findEncryptedWord_3() {
        String expected = "xbacbca";
        String input = "abcxcba";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "%s: The value '%s' is encrypted as '%s'\n", name.getMethodName(), input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findEncryptedWord_4() {
        String expected = "eafcobok";
        String input = "facebook";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "%s: The value '%s' is encrypted as '%s'\n", name.getMethodName(), input, result);
        assertEquals(expected, result);
    }
}
