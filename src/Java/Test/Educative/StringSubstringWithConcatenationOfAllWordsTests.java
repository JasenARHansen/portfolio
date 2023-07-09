package Java.Test.Educative;

import static org.junit.Assert.assertEquals;

import Java.Code.Educative.StringSubstringWithConcatenationOfAllWords;
import java.util.Arrays;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringSubstringWithConcatenationOfAllWordsTests {
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
