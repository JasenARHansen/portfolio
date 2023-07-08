package Java.Test.HackerRank.DictionariesAndHashmaps;

import Java.Code.HackerRank.DictionariesAndHashmaps.SherlockAndAnagrams;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sherlockAndAnagramsTests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void sherlockAndAnagrams_1() {
    int expected = 2;
    String source = "mom";
    int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
    System.out.format(
            "%s: The string '%s' has %d unordered anagrams.\n", name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void sherlockAndAnagrams_2() {
    int expected = 4;
    String source = "abba";
    int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
    System.out.format(
            "%s: The string '%s' has %d unordered anagrams.\n", name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void sherlockAndAnagrams_3() {
    int expected = 0;
    String source = "abcd";
    int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
    System.out.format(
            "%s: The string '%s' has %d unordered anagrams.\n", name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void sherlockAndAnagrams_4() {
    int expected = 3;
    String source = "ifailuhkqq";
    int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
    System.out.format(
            "%s: The string '%s' has %d unordered anagrams.\n", name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void sherlockAndAnagrams_5() {
    int expected = 10;
    String source = "kkkk";
    int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
    System.out.format(
            "%s: The string '%s' has %d unordered anagrams.\n", name.getMethodName(), source, result);
    assertEquals(expected, result);
  }

  @Test
  public void sherlockAndAnagrams_6() {
    int expected = 5;
    String source = "cdcd";
    int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
    System.out.format(
            "%s: The string '%s' has %d unordered anagrams.\n", name.getMethodName(), source, result);
    assertEquals(expected, result);
  }
}
