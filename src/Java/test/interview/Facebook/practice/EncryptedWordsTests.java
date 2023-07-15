package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.EncryptedWords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EncryptedWordsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findEncryptedWord_1() {
        String expected = "bac";
        printTestHeader(name.getMethodName());
        String input = "abc";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is encrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findEncryptedWord_2() {
        String expected = "bacd";
        printTestHeader(name.getMethodName());
        String input = "abcd";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is encrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findEncryptedWord_3() {
        String expected = "xbacbca";
        printTestHeader(name.getMethodName());
        String input = "abcxcba";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is encrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findEncryptedWord_4() {
        String expected = "eafcobok";
        printTestHeader(name.getMethodName());
        String input = "facebook";
        String result = EncryptedWords.findEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is encrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findUnEncryptedWord_1() {
        String expected = "abc";
        printTestHeader(name.getMethodName());
        String input = "bac";
        String result = EncryptedWords.findUnEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is unencrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findUnEncryptedWord_2() {
        String expected = "bacd";
        printTestHeader(name.getMethodName());
        String input = "abcd";
        String result = EncryptedWords.findUnEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is unencrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findUnEncryptedWord_3() {
        String expected = "abcxcba";
        printTestHeader(name.getMethodName());
        String input = "xbacbca";
        String result = EncryptedWords.findUnEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is unencrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void findUnEncryptedWord_4() {
        String expected = "facebook";
        printTestHeader(name.getMethodName());
        String input = "eafcobok";
        String result = EncryptedWords.findUnEncryptedWord(input);
        System.out.format(
                "\tThe value '%s' is unencrypted as '%s'\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        EncryptedWords.getDescription();
    }
}
