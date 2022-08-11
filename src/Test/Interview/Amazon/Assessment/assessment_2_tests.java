package Test.Interview.Amazon.Assessment;

import Code.Interview.Amazon.Assessment.assessment_2;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SuppressWarnings({"rawtypes", "unchecked"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class assessment_2_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void numberOfItems_1() {
    String input = "|**|*|*";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 3));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_2() {
    String input = "|**|*|*";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 2));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 4));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_3() {
    String input = "|**|*|*";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 3));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 6));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_4() {
    String input = "|**|*|*";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 2));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 7));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_5() {
    String input = "*|*|";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 2));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_6() {
    String input = "*|*|";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 4));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_7() {
    String input = "||||||||||||||||";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_8() {
    String input = "***********";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }

  @Test
  public void numberOfItems_9() {
    String input = "|**|**|*||*|*||***";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 4, 0, 2, 1));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1, 2, 4, 7));
    ArrayList start = new ArrayList(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8, 5, 7, 9));
    ArrayList stop = new ArrayList(stop_original);
    List<Integer> result = assessment_2.numberOfItems(input, start, stop);

    System.out.format("%s: The full range '%s':\n", name.getMethodName(), input);
    int index = 0;
    while ((index < start_original.size()) && (index < stop_original.size())) {
      int start_index = start_original.get(index);
      int stop_index = stop_original.get(index);
      int count = result.get(index);
      index++;
      System.out.format(
          "%s: The range '%s' defined with start index %d and stop index %d, '%s' contains %d items in closed"
              + " containers:\n",
          name.getMethodName(),
          input,
          start_index,
          stop_index,
          input.substring(start_index - 1, stop_index),
          count);
    }
    assertEquals(expected, result);
  }
}
