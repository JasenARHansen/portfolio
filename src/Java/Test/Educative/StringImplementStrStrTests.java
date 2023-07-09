package Java.Test.Educative;

import static org.junit.Assert.assertEquals;

import Java.Code.Educative.StringImplementStrStr;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringImplementStrStrTests {
  @Rule public TestName name = new TestName();

  @Test
  public void strStr_1() {
    int expected = 2;
    String haystack = "hello";
    String needle = "ll";
    int result = StringImplementStrStr.strStr(haystack, needle);
    System.out.format(
        "%s: The needle '%s' can be found in haystack '%s' at index %d.\n",
        name.getMethodName(), needle, haystack, result);
    assertEquals(expected, result);
  }

  @Test
  public void strStr_2() {
    int expected = -1;
    String haystack = "aaaaa";
    String needle = "bba";
    int result = StringImplementStrStr.strStr(haystack, needle);
    System.out.format(
        "%s: The needle '%s' can be found in haystack '%s' at index %d.\n",
        name.getMethodName(), needle, haystack, result);
    assertEquals(expected, result);
  }

  @Test
  public void strStr_3() {
    int expected = 0;
    String haystack = "";
    String needle = "";
    int result = StringImplementStrStr.strStr(haystack, needle);
    System.out.format(
        "%s: The needle '%s' can be found in haystack '%s' at index %d.\n",
        name.getMethodName(), needle, haystack, result);
    assertEquals(expected, result);
  }
}
