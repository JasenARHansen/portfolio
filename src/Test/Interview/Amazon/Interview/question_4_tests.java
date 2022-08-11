package Test.Interview.Amazon.Interview;

import Code.Interview.Amazon.Interview.question_4;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class question_4_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void shorten_1() {
        String expected = "Not valid";
        String result = question_4.Shorten(null, 1);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_2() {
        String expected = "Not valid";
        String result = question_4.Shorten("A", -1);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_3() {
        String expected = "A";
        String result = question_4.Shorten("A", 0);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_4() {
        String expected = "A";
        String result = question_4.Shorten("A", 2);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_5() {
        String expected = "A";
        String result = question_4.Shorten("A", 1);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_6() {
        String expected = "AB";
        String result = question_4.Shorten("AB", 1);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_7() {
        String expected = "A1C";
        String result = question_4.Shorten("ABC", 1);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_8() {
        String expected = "i18n";
        String result = question_4.Shorten("internationalization", 1);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void shorten_9() {
        String expected = "in17n";
        String result = question_4.Shorten("internationalization", 2);
        System.out.format("%s: Note.\n", name.getMethodName());
        assertEquals(expected, result);
    }

    @Test
    public void ShortenAll_1() {
        List<String> sourceList = Arrays.asList("abbbc", "adbbc", "abcccd");
        List<String> result = question_4.ShortenAll(sourceList);
        System.out.format("%s: Note.\n", name.getMethodName());
        //assertEquals(expected, result);
    }
}
