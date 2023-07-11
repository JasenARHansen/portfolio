package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertEquals;

import Java.code.interview.Facebook.practice.EncryptedWords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EncryptedWordsTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void EncryptedWords() {
    System.out.format("%s: ", name.getMethodName());
    EncryptedWords.getDescription();
  }

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

  @Test
  public void findUnEncryptedWord_1() {
    String input = "bac";
    String expected = "abc";
    String result = EncryptedWords.findUnEncryptedWord(input);
    System.out.format(
        "%s: The value '%s' is unencrypted as '%s'\n", name.getMethodName(), input, result);
    assertEquals(expected, result);
  }

  @Test
  public void findUnEncryptedWord_2() {
    String input = "abcd";
    String expected = "bacd";
    String result = EncryptedWords.findUnEncryptedWord(input);
    System.out.format(
        "%s: The value '%s' is unencrypted as '%s'\n", name.getMethodName(), input, result);
    assertEquals(expected, result);
  }

  @Test
  public void findUnEncryptedWord_3() {
    String input = "xbacbca";
    String expected = "abcxcba";
    String result = EncryptedWords.findUnEncryptedWord(input);
    System.out.format(
        "%s: The value '%s' is unencrypted as '%s'\n", name.getMethodName(), input, result);
    assertEquals(expected, result);
  }

  @Test
  public void findUnEncryptedWord_4() {
    String input = "eafcobok";
    String expected = "facebook";
    String result = EncryptedWords.findUnEncryptedWord(input);
    System.out.format(
        "%s: The value '%s' is unencrypted as '%s'\n", name.getMethodName(), input, result);
    assertEquals(expected, result);
  }
}
