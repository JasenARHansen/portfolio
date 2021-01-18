package Test.interview.Google.Jan_14_2021.interview_2;

import interview.Google.Jan_14_2021.interview_2.Scrabble;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Collection;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class scrabble_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void test() {
        List<String> dictionary = List.of("hat", "cat", "chat", "at", "a", "foo", "bar", "baz", "test");
        String source = "CHAT";
        Scrabble result = new Scrabble();
        result.setup(dictionary);
        Collection<String> words = result.getWords(source);
        for (String word : words) {
            System.out.format("%s: Word: %s\n", name.getMethodName(), word);
        }
    }
}
