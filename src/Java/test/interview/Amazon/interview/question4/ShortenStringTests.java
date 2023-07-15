package Java.test.interview.Amazon.interview.question4;

import Java.code.interview.Amazon.interview.question4.ShortenString;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"SpellCheckingInspection", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShortenStringTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void ShortenAll_1() {
        List<String> expected = Arrays.asList("ad2c", "ab2c", "a4d");
        printTestHeader(name.getMethodName());
        List<String> input = Arrays.asList("abbbc", "adbbc", "abcccd");
        List<String> result = ShortenString.ShortenAll(input);
        System.out.format("\tNote.\n");
        for (int i = 0; i < input.size(); i++) {
            System.out.format(
                    "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                    input.get(i), expected.get(i), result.get(i));
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        ShortenString.getDescription();
    }

    @Test
    public void shorten_1() {
        String expected = "Not valid";
        printTestHeader(name.getMethodName());
        String input = null;
        String result = ShortenString.Shorten(input, 1);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_2() {
        String expected = "Not valid";
        printTestHeader(name.getMethodName());
        String input = "A";
        String result = ShortenString.Shorten(input, -1);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_3() {
        String expected = "A";
        printTestHeader(name.getMethodName());
        String input = "A";
        String result = ShortenString.Shorten(input, 0);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_4() {
        String expected = "A";
        printTestHeader(name.getMethodName());
        String input = "A";
        String result = ShortenString.Shorten(input, 2);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_5() {
        String expected = "A";
        printTestHeader(name.getMethodName());
        String input = "A";
        String result = ShortenString.Shorten(input, 1);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_6() {
        String expected = "AB";
        printTestHeader(name.getMethodName());
        String input = "AB";
        String result = ShortenString.Shorten(input, 1);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_7() {
        String expected = "A1C";
        printTestHeader(name.getMethodName());
        String input = "ABC";
        String result = ShortenString.Shorten(input, 1);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_8() {
        String expected = "i18n";
        printTestHeader(name.getMethodName());
        String input = "internationalization";
        String result = ShortenString.Shorten(input, 1);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }

    @Test
    public void shorten_9() {
        String expected = "in17n";
        printTestHeader(name.getMethodName());
        String input = "internationalization";
        String result = ShortenString.Shorten(input, 2);
        System.out.format(
                "\tInput string string '%s', Expected '%s' and recieved '%s'.\n",
                input, expected, result);
        assertEquals(expected, result);
    }
}
