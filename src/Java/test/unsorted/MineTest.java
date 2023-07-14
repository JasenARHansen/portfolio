package Java.test.unsorted;

import static Java.code.unsorted.Mine.*;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

@SuppressWarnings({"DuplicatedCode"})
public class MineTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void search_1() {
    int[] expected = {1, 2, 3, 5, 7, 9, 10, 11, 12, 13, 16, 17, 18};
    System.out.format("%s:\n", name.getMethodName());
    int[] array1 = {1, 5, 10, 11, 13, 18};
    int[] array2 = {2, 3, 7, 9, 12, 16, 17};
    int[] answer = mergeAndSort(array1, array2);
    for (int i = 1; i <= answer.length; i++) {
      int result = search(i, array1, array2);
      assertEquals(expected[i - 1], result);
      System.out.format(
          "\tThe answer is: %s and the expected is: %d. This is %b.\n",
          result, answer[i - 1], result == answer[i - 1]);
    }
  }

  @Test
  public void search_2() {
    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    System.out.format("%s:\n", name.getMethodName());
    int[] array1 = {1, 2, 3, 4, 5, 6};
    int[] array2 = {7, 8, 9, 10, 11, 12, 13};
    int[] answer = mergeAndSort(array1, array2);
    for (int i = 1; i <= answer.length; i++) {
      int result = search(i, array1, array2);
      assertEquals(expected[i - 1], result);
      System.out.format(
          "\tThe answer is: %s and the expected is: %d. This is %b.\n",
          result, answer[i - 1], result == answer[i - 1]);
    }
  }

  @Test
  public void search_3() {
    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    System.out.format("%s:\n", name.getMethodName());
    int[] array1 = {7, 8, 9, 10, 11, 12, 13};
    int[] array2 = {1, 2, 3, 4, 5, 6};
    int[] answer = mergeAndSort(array1, array2);
    for (int i = 1; i <= answer.length; i++) {
      int result = search(i, array1, array2);
      assertEquals(expected[i - 1], result);
      assertEquals(expected[i - 1], result);
      System.out.format(
          "\tThe answer is: %s and the expected is: %d. This is %b.\n",
          result, answer[i - 1], result == answer[i - 1]);
    }
  }

  @Test
  public void search_4() {
    int[] expected = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13};
    System.out.format("%s:\n", name.getMethodName());
    int[] array1 = {6, 8, 2, 10, 4, 12, 13};
    int[] array2 = {1, 9, 7, 3, 11, 5, 6};
    int[] answer = mergeAndSort(array1, array2);
    for (int i = 1; i <= answer.length; i++) {
      int result = search(i, array1, array2);
      assertEquals(expected[i - 1], result);
      System.out.format(
          "\tThe answer is: %s and the expected is: %d. This is %b.\n",
          result, answer[i - 1], result == answer[i - 1]);
    }
  }

  @Test
  public void search_5() {
    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    System.out.format("%s:\n", name.getMethodName());
    int[] array1 = {1, 2, 3, 4, 5, 6};
    int[] array2 = {7, 8, 9, 10, 11, 12, 13};
    int[] answer = mergeAndSort(array1, array2);
    for (int i = 1; i <= answer.length; i++) {
      int result = search(i, array1, array2);
      assertEquals(expected[i - 1], result);
      System.out.format(
          "\tThe answer is: %s and the expected is: %d. This is %b.\n",
          result, answer[i - 1], result == answer[i - 1]);
    }
  }

  @Test
  public void search_6() {
    int[] expected = {1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9, 10, 11, 12, 13};
    System.out.format("%s:\n", name.getMethodName());
    int[] array1 = {1, 2, 3, 4, 5, 6};
    int[] array2 = {7, 8, 9, 10, 11, 12, 13};
    int[] array3 = {3, 6, 9};
    int[] answer = mergeAndSort(array1, array2, array3);
    for (int i = 1; i <= answer.length; i++) {
      int result = searchComplex(i, array1, array2, array3);
      assertEquals(expected[i - 1], result);
      System.out.format(
          "\tThe answer is: %s and the expected is: %d. This is %b.\n",
          result, answer[i - 1], result == answer[i - 1]);
    }
  }

  @Test
  public void search_7() {
    int[] expected = {1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9, 10, 11, 12, 13};
    System.out.format("%s:\n", name.getMethodName());
    int[] array1 = {5, 3, 1, 2, 4, 6};
    int[] array2 = {11, 12, 7, 9, 8, 10, 13};
    int[] array3 = {6, 3, 9};
    int[] answer = mergeAndSort(array1, array2, array3);
    for (int i = 1; i <= answer.length; i++) {
      int result = searchComplex(i, array1, array2, array3);
      assertEquals(expected[i - 1], result);
      System.out.format(
          "\tThe answer is: %s and the expected is: %d. This is %b.\n",
          result, answer[i - 1], result == answer[i - 1]);
    }
  }

  @Test
  public void search_8() {
    String expected = "2";
    // Mock inputs for scanner
    String input = "3.0 3 1 2 2.0 2 3 4.0 3 4 4.0";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.format("%s:\n", name.getMethodName());
    String result = highestAssociativity();
    assertEquals(expected, result);
  }

  @Test
  public void test10() {
    // Mock inputs for scanner
    String input = "3 1 2 3 2 3 4 3 4 5";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.format("%s:\n", name.getMethodName());
    loopTest();
  }
}
