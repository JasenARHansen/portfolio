package Java.test.educative;

import Java.code.educative.StringSubstringWithConcatenationOfAllWords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringSubstringWithConcatenationOfAllWordsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findSubstring_1() {
        List<Integer> expected = Arrays.asList(0, 9);
        printTestHeader(name.getMethodName());
        String string = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> result = StringSubstringWithConcatenationOfAllWords.findSubstring(string, words);
        System.out.format(
                "\tThe string '%s' has %d substrings composed of every element of '%s' used 1 time.\n",
                string, result.size(), Arrays.toString(words));
        for (int index = 0; index < expected.size(); index++) {
            assertEquals(expected.get(index), result.get(index));
        }
    }

    @Test
    public void findSubstring_2() {
        printTestHeader(name.getMethodName());
        String string = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        List<Integer> result = StringSubstringWithConcatenationOfAllWords.findSubstring(string, words);
        System.out.format(
                "\tThe string '%s' has %d substrings composed of every element of '%s' used 1 time.\n",
                string, result.size(), Arrays.toString(words));
        assertEquals(0, result.size());
    }

    @Test
    public void findSubstring_3() {
        printTestHeader(name.getMethodName());
        List<Integer> expected = Arrays.asList(6, 9, 12);
        String string = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> result = StringSubstringWithConcatenationOfAllWords.findSubstring(string, words);
        System.out.format(
                "\tThe string '%s' has %d substrings composed of every element of '%s' used 1 time.\n",
                string, result.size(), Arrays.toString(words));
        printTestHeader(name.getMethodName());
        for (int index = 0; index < expected.size(); index++) {
            assertEquals(expected.get(index), result.get(index));
        }
    }
}
