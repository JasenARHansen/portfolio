package Java.test.interview.Google.jan_14_2021.interview_2;

import static org.junit.Assert.*;

import Java.code.interview.Google.jan_14_2021.interview_2.Scrabble;
import java.util.Collection;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScrabbleTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void Scrabble() {
    String expected = "[a, at, chat, cat, hat]";
    System.out.format("%s:\n", name.getMethodName());
    List<String> dictionary = List.of("hat", "cat", "chat", "at", "a", "foo", "bar", "baz", "test");
    String source = "CHAT";
    Scrabble scrabble = new Scrabble();
    scrabble.setup(dictionary);
    Collection<String> words = scrabble.getWords(source);
    assertNotNull(words);
    String result = words.toString();
    assertEquals(expected, result);
    System.out.format("\tSource: %s\n", dictionary);
    System.out.format("\tWords: %s\n", result);
  }
}
