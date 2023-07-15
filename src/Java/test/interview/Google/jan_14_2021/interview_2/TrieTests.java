package Java.test.interview.Google.jan_14_2021.interview_2;

import Java.code.interview.Google.jan_14_2021.interview_2.Trie;
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
    public void Trie() {
        printTestHeader(name.getMethodName());
        Trie result = new Trie();
        assertNotNull(result);
        System.out.format("\t%s\n", result);
    }

    @Test
    public void insert() {
        Trie result = new Trie();
        String value = "value";
        result.insert(value);
        System.out.format("\t%s\n", result);
    }
}
