package Java.test.ctci.old.ctciLibrary;

import Java.code.ctci.source.ctciLibrary.TrieNode;
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
    public void TrieNode() {
        printTestHeader(name.getMethodName());
        char data = 'a';
        TrieNode trieNode = new TrieNode(data);
        assertNotNull(trieNode);
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
