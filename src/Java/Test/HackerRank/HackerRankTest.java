package Java.Test.HackerRank;

import static org.junit.Assert.assertEquals;

import Java.Code.HackerRank.HackerRank;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"SpellCheckingInspection", "MismatchedQueryAndUpdateOfCollection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HackerRankTest {
  @Test
  public void http() throws Exception {
    List<String> test = HackerRank.http("Spiderman");
    System.out.println(test);
  }

  @Test
  public void stringMerge() {
    String test = HackerRank.stringMerge("abcd", "1234567");
    System.out.println(test);
  }

  @Test
  public void isSubset_1() {
    String[] master = {"John", "New York", "Rajeev", "Bengaluru", "Steve", "London"};
    String[] secondary = {"John", "New York", "Rajeev", "Bengaluru"};
    String result = HackerRank.isSubset(master, secondary);
    System.out.println(result);
    assertEquals("Yes", result);
  }

  @Test
  public void isSubset_2() {
    String[] master = {"John", "New York", "Rajeev", "Bengaluru"};
    String[] secondary = {"John", "New York", "Rajeev", "Bengaluru", "Steve", "London"};
    String result = HackerRank.isSubset(master, secondary);
    System.out.println(result);
    assertEquals("No", result);
  }

  @Test
  public void isBalanced_1() {
    String value = "({[Test]})";
    String result = HackerRank.isBalanced(value);
    System.out.println(result);
    assertEquals("Yes", result);
  }

  @Test
  public void isBalanced_2() {
    String value = "({[Test)]}";
    String result = HackerRank.isBalanced(value);
    System.out.println(result);
    assertEquals("No", result);
  }
}
