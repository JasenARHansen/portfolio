package Java.test.unsorted;

import static org.junit.Assert.*;

import Java.code.unsorted.classesStatic.KataStatic;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"SpellCheckingInspection", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void Multiple3_5_2() {
    int expected = 23;
    int input = 10;
    int result = KataStatic.multiple3_5_2(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void Multiple3_5() {
    int expected = 23;
    int input = 10;
    int result = KataStatic.multiple3_5(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void rowSumOddNumbers() {
    int expected = 27;
    int input = 3;
    int result = KataStatic.rowSumOddNumbers(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void rowSumOddNumbers2() {
    int input = 26;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: %d -> %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_1() {
    int input = -1;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: %d -> %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_2() {
    int input = 3;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: %d -> %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_3() {
    int input = 4;
    boolean result = KataStatic.isSquare(input);
    assertTrue(result);
    System.out.format("%s: %d -> %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_4() {
    int input = 25;
    boolean result = KataStatic.isSquare(input);
    assertTrue(result);
    System.out.format("%s: %d -> %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_5() {
    int input = 26;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: %d -> %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void HighAndLow() {
    String expected = "42 -9";
    String input = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
    String result = KataStatic.HighAndLow(input);
    assertEquals(expected, result);
    System.out.format("%s: %s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void HighAndLow2() {
    String expected = "42 -9";
    String input = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
    String result = KataStatic.HighAndLow2(input);
    assertEquals(expected, result);
    System.out.format("%s:%s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void reverseString() {
    String expected = "dlrow";
    String input = "world";
    String result = KataStatic.reverseString(input);
    assertEquals(expected, result);
    System.out.format("%s: %s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void reverseString2() {
    String expected = "dlrow";
    String input = "world";
    String result = KataStatic.reverseString2(input);
    assertEquals(expected, result);
    System.out.format("%s: %s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void sortDesc() {
    int expected = 321;
    int input = 123;
    int result = KataStatic.sortDesc(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNb_1() {
    long expected = 2022;
    long input = 4183059834009L;
    long result = KataStatic.findNb(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNb_2() {
    long expected = -1;
    long input = 24723578342962L;
    long result = KataStatic.findNb(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNb_3() {
    long expected = 4824;
    long input = 135440716410000L;
    long result = KataStatic.findNb(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void compArray() {
    int[] input_1 = new int[] {121, 144, 19, 161, 19, 144, 19, 11};
    int[] input_2 = new int[] {121, 14641, 20736, 361, 25921, 361, 20736, 361};
    boolean result = KataStatic.compArray(input_1, input_2);
    assertTrue(result);
    System.out.format(
        "%s: %s - %s -> %b\n",
        name.getMethodName(), Arrays.toString(input_1), Arrays.toString(input_2), result);
  }

  @Test
  public void findNextSquare_1() {
    long expected = -1;
    long input = 3;
    long result = KataStatic.findNextSquare(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNextSquare_2() {
    long expected = 9;
    long input = 4;
    long result = KataStatic.findNextSquare(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void digital_root_1() {
    int expected = 4;
    int input = 31;
    int result = KataStatic.digital_root(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void digital_root_2() {
    int expected = 9;
    int input = 99;
    int result = KataStatic.digital_root(input);
    assertEquals(expected, result);
    System.out.format("%s: %d -> %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight_1() {
    String expected = "2000 103 123 4444 99";
    String input = "103 123 4444 99 2000";
    String result = KataStatic.orderWeight(input);
    assertEquals(expected, result);
    System.out.format("%s: %s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight_2() {
    String expected = "11 11 2000 10003 22 123 1234000 44444444 9999";
    String input = "2000 10003 1234000 44444444 9999 11 11 22 123";
    String result = KataStatic.orderWeight(input);
    assertEquals(expected, result);
    System.out.format("%s: %s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight2_1() {
    String expected = "2000 103 123 4444 99";
    String input = "103 123 4444 99 2000";
    String result = KataStatic.orderWeight2(input);
    assertEquals(expected, result);
    System.out.format("%s: %s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight2_2() {
    String expected = "11 11 2000 10003 22 123 1234000 44444444 9999";
    String input = "2000 10003 1234000 44444444 9999 11 11 22 123";
    String result = KataStatic.orderWeight2(input);
    assertEquals(expected, result);
    System.out.format("%s: %s -> %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void inArray_1() {
    String[] expected = new String[] {"arp", "live", "strong"};
    String[] input_1 = new String[] {"arp", "live", "strong"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] result = KataStatic.inArray(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: %s - %s -> %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void inArray_2() {
    String[] expected = new String[] {};
    String[] input_1 = new String[] {"tarp", "mice", "bull"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] result = KataStatic.inArray(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: %s - %s -> %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void inArray2_1() {
    String[] expected = new String[] {"arp", "live", "strong"};
    String[] input_1 = new String[] {"arp", "live", "strong"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] result = KataStatic.inArray2(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: %s - %s -> %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void inArray2_2() {
    String[] expected = new String[] {};
    String[] input_1 = new String[] {"tarp", "mice", "bull"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] result = KataStatic.inArray2(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: %s - %s -> %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void count_find_num_1() {
    int[] expected = new int[] {1, 70};
    int[] input_1 = new int[] {2, 5, 7};
    int input_2 = 500;
    int[] result = KataStatic.count_find_num(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: %s - %d -> %s\n",
        name.getMethodName(), Arrays.toString(input_1), input_2, Arrays.toString(result));
  }

  @Test
  public void count_find_num_2() {
    int[] expected = new int[] {};
    int[] input_1 = new int[] {2, 3, 47};
    int input_2 = 200;
    int[] result = KataStatic.count_find_num(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: %s - %d -> %s\n",
        name.getMethodName(), Arrays.toString(input_1), input_2, Arrays.toString(result));
  }

  @Test
  public void count_find_num_3() {
    int[] expected = new int[] {1, 282};
    int[] input_1 = new int[] {2, 3, 47};
    int input_2 = 282;
    int[] result = KataStatic.count_find_num(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: %s - %d -> %s\n",
        name.getMethodName(), Arrays.toString(input_1), input_2, Arrays.toString(result));
  }
}
