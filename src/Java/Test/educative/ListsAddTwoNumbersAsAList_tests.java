package Test.Java.educative;

import Java.Code.Educative.ListsAddTwoNumbersAsAList;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListsAddTwoNumbersAsAList_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void addTwoLists_1() {
    List<String> expected = new ArrayList<>(Arrays.asList("2", "0", "2", "3"));
    List<String> left = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
    List<String> right = new ArrayList<>(Arrays.asList("7", "8", "9"));
    List<String> result =
            ListsAddTwoNumbersAsAList.addTwoLists_most_significant_digit_first(left, right);
    System.out.format(
            "%s: The '%s' plus '%s' is '%s'.\n", name.getMethodName(), left, right, result);
    assertEquals(expected.size(), result.size());
  }

  @Test
  public void addTwoLists_2() {
    List<String> expected = new ArrayList<>(Arrays.asList("1", "0", "0", "0", "0"));
    List<String> left = new ArrayList<>(Arrays.asList("9", "9", "9", "9"));
    List<String> right = new ArrayList<>(Collections.singletonList("1"));
    List<String> result =
            ListsAddTwoNumbersAsAList.addTwoLists_most_significant_digit_first(left, right);
    System.out.format(
            "%s: The '%s' plus '%s' is '%s'.\n", name.getMethodName(), left, right, result);
    assertEquals(expected.size(), result.size());
  }
}
