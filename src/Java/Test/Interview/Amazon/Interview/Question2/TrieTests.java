package Java.Test.Interview.Amazon.Interview.Question2;

import Java.Code.Interview.Amazon.Interview.Question2.Trie;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieTests {
  @Rule public TestName name = new TestName();

  @Test
  public void Trie() {
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
