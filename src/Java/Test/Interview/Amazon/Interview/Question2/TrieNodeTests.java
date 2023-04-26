package Test.Java.Interview.Amazon.Interview.Question2;

import Java.Code.Interview.Amazon.Interview.Question2.TrieNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieNodeTests {

    @Rule
    public TestName name = new TestName();

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
