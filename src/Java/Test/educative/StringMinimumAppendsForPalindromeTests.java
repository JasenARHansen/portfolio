package Java.test.educative;

import static org.junit.Assert.assertEquals;

import Java.code.educative.StringMinimumAppendsForPalindrome;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringMinimumAppendsForPalindromeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void minimumAppends_1() {
    int expected = 2;
    String source = "abede";
    int result = StringMinimumAppendsForPalindrome.minimumAppends(source);
    System.out.format(
        "%s: The string '%s' needs a minimum of %d appends to convert to a palindrome.\n",
        name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void minimumAppends_2() {
    int expected = 2;
    String source = "aabb";
    int result = StringMinimumAppendsForPalindrome.minimumAppends(source);
    System.out.format(
        "%s: The string '%s' needs a minimum of %d appends to convert to a palindrome.\n",
        name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void minimumAppends_3() {
    int expected = 0;
    String source = "ababbaba";
    int result = StringMinimumAppendsForPalindrome.minimumAppends(source);
    System.out.format(
        "%s: The string '%s' needs a minimum of %d appends to convert to a palindrome.\n",
        name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void minimumAppends_4() {
    int expected = 2;
    String source = "aacataa";
    int result = StringMinimumAppendsForPalindrome.minimumAppends(source);
    System.out.format(
        "%s: The string '%s' needs a minimum of %d appends to convert to a palindrome.\n",
        name.getMethodName(), source, result);
    assertEquals(expected, result);
  }
}
