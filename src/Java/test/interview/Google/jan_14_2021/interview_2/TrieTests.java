package Java.test.interview.Google.jan_14_2021.interview_2;

import static org.junit.Assert.assertNotNull;

import Java.code.interview.Google.jan_14_2021.interview_2.Trie;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void Trie() {
    Trie trie = new Trie();
    assertNotNull(trie);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void insert() {
    Trie trie = new Trie();
    String value = "value";
    trie.insert(value);
    System.out.format("%s: insert \n", name.getMethodName());
  }
}
