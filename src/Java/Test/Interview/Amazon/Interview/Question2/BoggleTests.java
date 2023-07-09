package Java.Test.Interview.Amazon.Interview.Question2;

import Java.Code.Interview.Amazon.Interview.Question2.Boggle;
import Java.Code.Interview.Amazon.Interview.Question2.Trie;
import java.util.Set;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("InstantiationOfUtilityClass")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoggleTests {
  @Rule public TestName name = new TestName();

  @Test
  public void Boggle() {
    System.out.format("%s: ", name.getMethodName());
    Boggle.getDescription();
  }

  @Test
  public void constructor() {
    System.out.format("%s: Boggle\n", name.getMethodName());
    new Boggle();
  }

  @Test
  public void game() {
    String[] words = {
      "bog", "boggle", "boggled", "dog", "god", "lob", "bad", "dab", "bode", "abode", "cat", "rat"
    };
    Trie dictionary = new Trie();
    dictionary.insert(words);
    Character[][] board = {{'a', 'b', 'c'}, {'d', 'o', 'g'}, {'e', 'l', 'g'}};
    Set<String> result = Boggle.getWords(dictionary, board);
    System.out.format("%s: Words %s.\n", name.getMethodName(), result);
  }
}
