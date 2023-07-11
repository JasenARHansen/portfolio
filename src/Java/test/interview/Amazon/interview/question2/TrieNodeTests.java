package Java.test.interview.Amazon.interview.question2;

import Java.code.interview.Amazon.interview.question2.TrieNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieNodeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void TrieNode() {
    System.out.format("%s: ", name.getMethodName());
    TrieNode.getDescription();
  }
  @Test
  public void constructor_1() {
    TrieNode trieNode = new TrieNode();
    assertNotNull(trieNode);
    System.out.format("%s: TrieNode\n", name.getMethodName());
  }

  @Test
  public void constructor_2() {
    char data = 'a';
    TrieNode trieNode = new TrieNode(data);
    assertNotNull(trieNode);
    System.out.format("%s: TrieNode\n", name.getMethodName());
  }

  @Test
  public void size() {
    char data = 'a';
    TrieNode trieNode = new TrieNode(data);
    char result = trieNode.getChar();
    assertEquals(data, result);
    System.out.format("%s: size - %c\n", name.getMethodName(), result);
  }
}
