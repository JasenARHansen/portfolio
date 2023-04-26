package Test.Java.Interview.Amazon.Interview.Question4;

import Java.Code.Interview.Amazon.Interview.Question4.ShortenString;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShortenStringTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void ConvertXML() {
        System.out.format("%s: ", name.getMethodName());
        ShortenString.getDescription();
    }

    @Test
    public void shorten_1() {
        String expected = "Not valid";
        String input = null;
        String result = ShortenString.Shorten(input, 1);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_2() {
        String expected = "Not valid";
        String input = "A";
        String result = ShortenString.Shorten(input, -1);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_3() {
        String expected = "A";
        String input = "A";
        String result = ShortenString.Shorten(input, 0);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_4() {
        String expected = "A";
        String input = "A";
        String result = ShortenString.Shorten(input, 2);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_5() {
        String expected = "A";
        String input = "A";
        String result = ShortenString.Shorten(input, 1);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_6() {
        String expected = "AB";
        String input = "AB";
        String result = ShortenString.Shorten(input, 1);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_7() {
        String expected = "A1C";
        String input = "ABC";
        String result = ShortenString.Shorten(input, 1);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_8() {
        String expected = "i18n";
        String input = "internationalization";
        String result = ShortenString.Shorten(input, 1);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_9() {
        String expected = "in17n";
        String input = "internationalization";
        String result = ShortenString.Shorten(input, 2);
        System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void ShortenAll_1() {
        List<String> expected = Arrays.asList("ad2c", "ab2c", "a4d");
        List<String> input = Arrays.asList("abbbc", "adbbc", "abcccd");
        List<String> result = ShortenString.ShortenAll(input);
        System.out.format("%s: Note.\n", name.getMethodName());
        for (int i = 0; i < input.size(); i++) {
            System.out.format("%s: Input string string '%s', Expected '%s' and recieved '%s'.\n", name.getMethodName(), input.get(i), expected.get(i), result.get(i));
            assertEquals(expected.get(i), result.get(i));
        }
    }
}
