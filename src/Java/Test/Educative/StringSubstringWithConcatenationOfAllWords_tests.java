package Java.Test.Educative;

import Java.Code.Educative.StringSubstringWithConcatenationOfAllWords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringSubstringWithConcatenationOfAllWords_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void findSubstring_1() {
    List<Integer> expected = Arrays.asList(0, 9);
    String string = "barfoothefoobarman";
    String[] words = {"foo", "bar"};
    List<Integer> result = StringSubstringWithConcatenationOfAllWords.findSubstring(string, words);
    System.out.format(
        "%s: The string '%s' has %d substrings composed of every element of '%s' used 1 time.\n",
        name.getMethodName(), string, result.size(), Arrays.toString(words));
    assertEquals(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
      assertEquals(expected.get(index), result.get(index));
    }
  }

  @Test
  public void findSubstring_2() {
    List<Integer> expected = Collections.emptyList();
    String string = "wordgoodgoodgoodbestword";
    String[] words = {"word", "good", "best", "word"};
    List<Integer> result = StringSubstringWithConcatenationOfAllWords.findSubstring(string, words);
    System.out.format(
        "%s: The string '%s' has %d substrings composed of every element of '%s' used 1 time.\n",
        name.getMethodName(), string, result.size(), Arrays.toString(words));
    assertEquals(0, result.size());
  }

  @Test
  public void findSubstring_3() {
    List<Integer> expected = Arrays.asList(6, 9, 12);
    String string = "barfoofoobarthefoobarman";
    String[] words = {"bar", "foo", "the"};
    List<Integer> result = StringSubstringWithConcatenationOfAllWords.findSubstring(string, words);
    System.out.format(
        "%s: The string '%s' has %d substrings composed of every element of '%s' used 1 time.\n",
        name.getMethodName(), string, result.size(), Arrays.toString(words));
    assertEquals(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
      assertEquals(expected.get(index), result.get(index));
    }
  }
}
