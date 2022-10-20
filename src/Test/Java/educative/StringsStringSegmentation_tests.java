package Test.Java.educative;

import Code.Java.Educative.StringsStringSegmentation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringsStringSegmentation_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void can_segment_string_1() {
    Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
    String sentence = "applepie";
    boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
    System.out.format(
            "%s: The string '%s' can be segmented using the dictionary '%s': %b.\n",
            name.getMethodName(), sentence, dictionary, result);
    assertTrue(result);
  }

  @Test
  public void can_segment_string_2() {
    Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
    String sentence = "applepeer";
    boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
    System.out.format(
            "%s: The string '%s' can be segmented using the dictionary '%s': %b.\n",
            name.getMethodName(), sentence, dictionary, result);
    assertFalse(result);
  }

  @Test
  public void can_segment_string_3() {
    Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
    String sentence = "applepearpie";
    boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
    System.out.format(
            "%s: The string '%s' can be segmented using the dictionary '%s': %b.\n",
            name.getMethodName(), sentence, dictionary, result);
    assertTrue(result);
  }

  @Test
  public void can_segment_string_4() {
    Set<String> dictionary = Stream.of("apple", "apple", "pear", "pie").collect(Collectors.toSet());
    String sentence = "applespie";
    boolean result = StringsStringSegmentation.can_segment_string(sentence, dictionary);
    System.out.format(
            "%s: The string '%s' can be segmented using the dictionary '%s': %b.\n",
            name.getMethodName(), sentence, dictionary, result);
    assertFalse(result);
  }
}
