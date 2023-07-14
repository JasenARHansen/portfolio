package Java.test.interview.Google;

import static org.junit.Assert.*;

import Java.code.interview.Google.palindrome;
import java.util.Map;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PalindromeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void detect_false() {
    System.out.format("%s:\n", name.getMethodName());
    String source = "cat";
    boolean result = palindrome.detect(source);
    assertFalse(result);
    System.out.printf("\tSource: %s\n", source);
    System.out.printf("\tIs palindrome: %b\n", result);
  }

  @Test
  public void detect_true() {
    System.out.format("%s:\n", name.getMethodName());
    String source = "Anna";
    boolean result = palindrome.detect(source);
    assertTrue(result);
    System.out.printf("\tSource: %s\n", source);
    System.out.printf("\tIs palindrome: %b\n", result);
  }

  @Test
  public void convert_palindrome_even() {
    String expected = "AnnA";
    System.out.format("%s:\n", name.getMethodName());
    String source = "Ann";
    Map.Entry<String, String> transformed = palindrome.transform(source);
    String result = palindrome.convert(transformed);
    String transform = palindrome.report(transformed);
    assertEquals(expected, result);
    System.out.printf("\t%s became the palindrome: %s\n", source, result);
    System.out.printf("\t%s applied the transform: %s\n", source, transform);
  }

  @Test
  public void convert_palindrome_odd() {
    String expected = "Level";
    System.out.format("%s:\n", name.getMethodName());
    String source = "Lvel";
    Map.Entry<String, String> transformed = palindrome.transform(source);
    String result = palindrome.convert(transformed);
    String transform = palindrome.report(transformed);
    assertEquals(expected, result);
    System.out.printf("\t%s became the palindrome: %s\n", source, result);
    System.out.printf("\t%s applied the transform: %s\n", source, transform);
  }

  @Test
  public void convert_non_palindrome() {
    String expected = "Raecear";
    System.out.format("%s:\n", name.getMethodName());
    String source = "Raecear";
    Map.Entry<String, String> transformed = palindrome.transform(source);
    String result = palindrome.convert(transformed);
    String transform = palindrome.report(transformed);
    assertEquals(expected, result);
    System.out.printf("\t%s became the palindrome: %s\n", source, result);
    System.out.printf("\t%s applied the transform: %s\n", source, transform);
  }
}
