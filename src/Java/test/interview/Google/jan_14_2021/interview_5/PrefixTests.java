package Java.test.interview.Google.jan_14_2021.interview_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import Java.code.interview.Google.jan_14_2021.interview_5.Prefix;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrefixTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    Prefix.getDescription();
  }

  @Test
  public void longestPrefix_1() {
    String expected = "";
    ArrayList<String> inputs =
        new ArrayList<>(List.of("abc", "bc", "ab", "abdabz123", "abe", "bz"));
    String result = Prefix.longestPrefix(inputs);
    assertNotEquals(result, expected);
    System.out.format(
        "%s: list %s has '%s' as its longest prefxes that at least half of the nodes share\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void longestPrefix_2() {
    String expected = "";
    ArrayList<String> inputs = new ArrayList<>(List.of("a", "b"));
    String result = Prefix.longestPrefix(inputs);
    assertEquals(result, expected);
    System.out.format(
        "%s: list %s has '%s' as its longest prefxes that at least half of the nodes share\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void longestPrefix_3() {
    String expected = "No values provided";
    String result = Prefix.longestPrefix(null);
    assertEquals(result, expected);
    System.out.format(
        "%s: list null has '%s' as its longest prefxes that at least half of the nodes share\n",
        name.getMethodName(), result);
  }
}
