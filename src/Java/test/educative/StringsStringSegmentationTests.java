package Java.test.educative;

import Java.code.educative.StringsStringSegmentation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringsStringSegmentationTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void can_segment_string_1() {
        printTestHeader(name.getMethodName());
        Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
        String sentence = "applepie";
        boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
        System.out.format(
                "\tThe string '%s' can be segmented using the dictionary '%s': %b.\n",
                sentence, dictionary, result);
        assertTrue(result);
    }

    @Test
    public void can_segment_string_2() {
        printTestHeader(name.getMethodName());
        Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
        String sentence = "applepeer";
        boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
        System.out.format(
                "\tThe string '%s' can be segmented using the dictionary '%s': %b.\n",
                sentence, dictionary, result);
        assertFalse(result);
    }

    @Test
    public void can_segment_string_3() {
        printTestHeader(name.getMethodName());
        Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
        String sentence = "applepearpie";
        boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
        System.out.format(
                "\tThe string '%s' can be segmented using the dictionary '%s': %b.\n",
                sentence, dictionary, result);
        assertTrue(result);
    }

    @Test
    public void can_segment_string_4() {
        printTestHeader(name.getMethodName());
        Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
        String sentence = "applespie";
        boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
        System.out.format(
                "\tThe string '%s' can be segmented using the dictionary '%s': %b.\n",
                sentence, dictionary, result);
        assertFalse(result);
    }
}
