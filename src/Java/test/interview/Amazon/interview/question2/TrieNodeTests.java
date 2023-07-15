package Java.test.interview.Amazon.interview.question2;

import Java.code.interview.Amazon.interview.question2.TrieNode;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieNodeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void constructor_1() {
        printTestHeader(name.getMethodName());
        TrieNode result = new TrieNode();
        assertNotNull(result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void constructor_2() {
        printTestHeader(name.getMethodName());
        char data = 'a';
        TrieNode result = new TrieNode(data);
        assertNotNull(result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        TrieNode.getDescription();
    }

    @Test
    public void size() {
        printTestHeader(name.getMethodName());
        char data = 'a';
        TrieNode trieNode = new TrieNode(data);
        char result = trieNode.getChar();
        assertEquals(data, result);
        System.out.format("\tsize - %c\n", result);
    }
}
