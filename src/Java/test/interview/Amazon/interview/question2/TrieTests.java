package Java.test.interview.Amazon.interview.question2;

import Java.code.interview.Amazon.interview.question2.Trie;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    Trie.getDescription();
  }

  @Test
  public void constructor() {
    System.out.format("%s: Trie\n", name.getMethodName());
    new Trie();
  }

  @Test
  public void insert() {
    System.out.format("%s:\n", name.getMethodName());
    String[] words = {
      "bog", "boggle", "boggled", "dog", "god", "lob", "bad", "dab", "bode", "abode", "cat", "rat"
    };
    Trie trie = new Trie();
    trie.insert(words);
  }
}
