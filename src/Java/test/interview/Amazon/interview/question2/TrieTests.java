package Java.test.interview.Amazon.interview.question2;

import Java.code.interview.Amazon.interview.question2.Trie;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrieTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void constructor() {
        printTestHeader(name.getMethodName());
        Trie result = new Trie();
        assertNotNull(result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Trie.getDescription();
    }

    @Test
    public void insert() {
        printTestHeader(name.getMethodName());
        String[] words = {
                "bog", "boggle", "boggled", "dog", "god", "lob", "bad", "dab", "bode", "abode", "cat", "rat"
        };
        Trie trie = new Trie();
        trie.insert(words);
    }
}
