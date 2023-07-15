package Java.test.interview.Amazon.interview.question2;

import Java.code.interview.Amazon.interview.question2.Boggle;
import Java.code.interview.Amazon.interview.question2.Trie;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoggleTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void game() {
        printTestHeader(name.getMethodName());
        String[] words = {
                "bog", "boggle", "boggled", "dog", "god", "lob", "bad", "dab", "bode", "abode", "cat", "rat"
        };
        Trie dictionary = new Trie();
        dictionary.insert(words);
        Character[][] board = {{'a', 'b', 'c'}, {'d', 'o', 'g'}, {'e', 'l', 'g'}};
        Set<String> result = Boggle.getWords(dictionary, board);
        System.out.format("\tWords %s.\n", result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Boggle.getDescription();
    }
}
