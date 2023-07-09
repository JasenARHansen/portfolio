package Java.Test.Interview.Amazon.Assessment.Question2;

import static org.junit.Assert.assertEquals;

import Java.Code.Interview.Amazon.Assessment.Question2.Inventory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryTests {
  @Rule public TestName name = new TestName();

  @Test
  public void Inventory() {
    System.out.format("%s: ", name.getMethodName());
    Inventory.getDescription();
  }

  @Test
  public void numberOfItems_1() {
    String input = "|**|*|*";
    List<Integer> expected = new ArrayList<>(Arrays.asList(0, 0));
    List<Integer> start_original = new ArrayList<>(Arrays.asList(1, 1));
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 3));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 4));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 6));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 7));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 2));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 4));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
    List<Integer> start = new ArrayList<>(start_original);
    List<Integer> stop_original = new ArrayList<>(Arrays.asList(1, 8, 5, 7, 9));
    List<Integer> stop = new ArrayList<>(stop_original);
    List<Integer> result = Inventory.numberOfItems(input, start, stop);
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
