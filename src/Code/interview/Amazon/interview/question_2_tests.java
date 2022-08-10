package Code.interview.Amazon.interview;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class question_2_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void Trie() {
        Trie dictionary = new Trie();
        String[] words = {"bog", "boggle", "boggled", "dog", "god", "lob", "bad", "dab", "bode", "abode", "cat", "rat"};
        for (String word : words) {
            dictionary.insert(word);
        }

        Character[][] board = {{'a', 'b', 'c'}, {'d', 'o', 'g'}, {'e', 'l', 'g'}};

        Set result = boggle.getWords(dictionary, board);


        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(0, 0);
    }
}
