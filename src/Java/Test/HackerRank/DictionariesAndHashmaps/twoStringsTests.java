package Java.Test.HackerRank.DictionariesAndHashmaps;

import Java.Code.HackerRank.DictionariesAndHashmaps.TwoStrings;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class twoStringsTests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void arrayManipulation_1() {
    String expected = "YES";
    String s1 = "and";
    String s2 = "art";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_2() {
    String expected = "NO";
    String s1 = "be";
    String s2 = "cat";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_3() {
    String expected = "YES";
    String s1 = "hello";
    String s2 = "world";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_4() {
    String expected = "NO";
    String s1 = "hi";
    String s2 = "world";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_5() {
    String expected = "YES";
    String s1 = "aaab";
    String s2 = "bet";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_6() {
    String expected = "NO";
    String s1 = "aaa";
    String s2 = "bet";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_7() {
    String expected = "NO";
    String s1 = "wouldyoulikefries";
    String s2 = "abcabcabcabcabcabc";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_8() {
    String expected = "YES";
    String s1 = "hackerrankcommunity";
    String s2 = "cdecdecdecde";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_9() {
    String expected = "YES";
    String s1 = "jackandjill";
    String s2 = "wentupthehill";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_10() {
    String expected = "NO";
    String s1 = "writetoyourparents";
    String s2 = "fghmqzldbc";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_11() {
    String expected = "YES";
    String s1 = "aardvark";
    String s2 = "apple";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_12() {
    String expected = "NO";
    String s1 = "beetroot";
    String s2 = "sandals";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }

  @Test
  public void arrayManipulation_13() {
    String expected = "NO";
    String s1 = "";
    String s2 = "sandals";
    String result = TwoStrings.twoStrings(s1, s2);
    System.out.format(
            "%s: The strings '%s' and '%s' have a common substring: %s.\n",
            name.getMethodName(), s1, s2, result);
    assertEquals(expected, result);
  }
}
