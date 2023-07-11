package Java.test.ctci.old.ctciLibrary;

import static org.junit.Assert.*;

import Java.code.ctci.source.ctciLibrary.TrieNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieNodeTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void TrieNode() {
    char data = 'a';
    TrieNode trieNode = new TrieNode(data);
    assertNotNull(trieNode);
    System.out.format("%s:\n", name.getMethodName());
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
