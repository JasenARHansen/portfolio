package Java.test.interview.Amazon.interview.question2;

import Java.code.interview.Amazon.interview.question2.TrieNode;
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
    System.out.format("%s: ", name.getMethodName());
    TrieNode.getDescription();
  }

  @Test
  public void constructor() {
    System.out.format("%s: TrieNode\n", name.getMethodName());
    new TrieNode();
  }
}
