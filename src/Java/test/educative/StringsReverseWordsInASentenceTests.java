package Java.test.educative;

import Java.code.educative.StringsReverseWordsInASentence;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringsReverseWordsInASentenceTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void reverse_1() {
        String expected = "olleH dlroW";
        printTestHeader(name.getMethodName());
        String sentence = "Hello World";
        String result = StringsReverseWordsInASentence.reverse_words(sentence);
        System.out.format(
                "\tThe string '%s' with its words reversed is '%s'.\n",
                sentence, result);
        assertEquals(expected, result);
    }

    @Test
    public void reverse_2() {
        String expected = "I ma taerg ta gnimmargorp";
        printTestHeader(name.getMethodName());
        String sentence = "I am great at programming";
        String result = StringsReverseWordsInASentence.reverse_words(sentence);
        System.out.format(
                "\tThe string '%s' with its words reversed is '%s'.\n",
                sentence, result);
        assertEquals(expected, result);
    }

    @Test
    public void reverse_3() {
        String expected = " ta ";
        printTestHeader(name.getMethodName());
        String sentence = " at ";
        String result = StringsReverseWordsInASentence.reverse_words(sentence);
        System.out.format(
                "\tThe string '%s' with its words reversed is '%s'.\n",
                sentence, result);
        assertEquals(expected, result);
    }

    @Test
    public void reverse_4() {
        String expected = " ta";
        printTestHeader(name.getMethodName());
        String sentence = " at";
        String result = StringsReverseWordsInASentence.reverse_words(sentence);
        System.out.format(
                "\tThe string '%s' with its words reversed is '%s'.\n",
                sentence, result);
        assertEquals(expected, result);
    }

    @Test
    public void reverse_5() {
        String expected = "ta ";
        printTestHeader(name.getMethodName());
        String sentence = "at ";
        String result = StringsReverseWordsInASentence.reverse_words(sentence);
        System.out.format(
                "\tThe string '%s' with its words reversed is '%s'.\n",
                sentence, result);
        assertEquals(expected, result);
    }

    @Test
    public void reverse_6() {
        String expected = " tac";
        printTestHeader(name.getMethodName());
        String sentence = " cat";
        String result = StringsReverseWordsInASentence.reverse_words(sentence);
        System.out.format(
                "\tThe string '%s' with its words reversed is '%s'.\n",
                sentence, result);
        assertEquals(expected, result);
    }

    @Test
    public void reverse_7() {
        String expected = "tac ";
        printTestHeader(name.getMethodName());
        String sentence = "cat ";
        String result = StringsReverseWordsInASentence.reverse_words(sentence);
        System.out.format(
                "\tThe string '%s' with its words reversed is '%s'.\n",
                sentence, result);
        assertEquals(expected, result);
    }
}
