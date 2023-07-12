package Java.test.interview.Google;

import static org.junit.Assert.*;

import Java.code.interview.Google.palindrome;
import java.util.Map;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PalindromeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void detect_false() {
    String source = "cat";
    boolean result = palindrome.detect(source);
    print_palindrome(name.getMethodName(), source, result);
    assertFalse(result);
  }

  public void print_palindrome(String name, String value, boolean result) {
    System.out.printf("%s: %s is a palindrome: %b\n", name, value, result);
  }

  @Test
  public void detect_true() {
    String source = "Anna";
    boolean result = palindrome.detect(source);
    print_palindrome(name.getMethodName(), source, result);
    assertTrue(result);
  }

  @Test
  public void convert_palindrome_even() {
    String source = "Ann";
    Map.Entry<String, String> transformed = palindrome.transform(source);
    String value = palindrome.convert(transformed);
    String transform = palindrome.report(transformed);
    print_palindrome(name.getMethodName(), source, value);
    print_transform(name.getMethodName(), source, transform);
  }

  public void print_palindrome(String name, String value, String result) {
    System.out.printf("%s: %s became the palindrome: %s\n", name, value, result);
  }

  public void print_transform(String name, String value, String transform) {
    System.out.printf("%s: %s applied the transform: %s\n", name, value, transform);
  }

  @Test
  public void convert_palindrome_odd() {
    String source = "Lvel";
    Map.Entry<String, String> transformed = palindrome.transform(source);
    String value = palindrome.convert(transformed);
    String transform = palindrome.report(transformed);
    print_palindrome(name.getMethodName(), source, value);
    print_transform(name.getMethodName(), source, transform);
  }

  @Test
  public void convert_non_palindrome() {
    String source = "Racear";
    Map.Entry<String, String> transformed = palindrome.transform(source);
    String value = palindrome.convert(transformed);
    String transform = palindrome.report(transformed);
    print_palindrome(name.getMethodName(), source, value);
    print_transform(name.getMethodName(), source, transform);
  }
}
