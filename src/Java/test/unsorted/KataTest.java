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
    int input = 10;
    int expected = 23;
    int result = KataStatic.multiple3_5_2(input);
    assertEquals(expected, result);
    System.out.format("%s: multiple3_5_2 of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void Multiple3_5() {
    int input = 10;
    int expected = 23;
    int result = KataStatic.multiple3_5(input);
    assertEquals(expected, result);
    System.out.format("%s: multiple3_5 of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void rowSumOddNumbers() {
    int input = 3;
    int expected = 27;
    int result = KataStatic.rowSumOddNumbers(input);
    assertEquals(expected, result);
    System.out.format("%s: rowSumOddNumbers of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void rowSumOddNumbers2() {
    int input = 26;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: isSquare of %d is %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_1() {
    int input = -1;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: isSquare of %d is %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_2() {
    int input = 3;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: isSquare of %d is %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_3() {
    int input = 4;
    boolean result = KataStatic.isSquare(input);
    assertTrue(result);
    System.out.format("%s: isSquare of %d is %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_4() {
    int input = 25;
    boolean result = KataStatic.isSquare(input);
    assertTrue(result);
    System.out.format("%s: isSquare of %d is %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void isSquare_5() {
    int input = 26;
    boolean result = KataStatic.isSquare(input);
    assertFalse(result);
    System.out.format("%s: isSquare of %d is %b\n", name.getMethodName(), input, result);
  }

  @Test
  public void HighAndLow() {
    String input = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
    String expected = "42 -9";
    String result = KataStatic.HighAndLow(input);
    assertEquals(expected, result);
    System.out.format("%s: HighAndLow of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void HighAndLow2() {
    String input = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
    String expected = "42 -9";
    String result = KataStatic.HighAndLow2(input);
    assertEquals(expected, result);
    System.out.format("%s: HighAndLow2 of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void reverseString() {
    String input = "world";
    String expected = "dlrow";
    String result = KataStatic.reverseString(input);
    assertEquals(expected, result);
    System.out.format("%s: reverseString of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void reverseString2() {
    String input = "world";
    String expected = "dlrow";
    String result = KataStatic.reverseString2(input);
    assertEquals(expected, result);
    System.out.format("%s: reverseString2 of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void sortDesc() {
    int input = 123;
    int expected = 321;
    int result = KataStatic.sortDesc(input);
    assertEquals(expected, result);
    System.out.format("%s: sortDesc of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNb_1() {
    long input = 4183059834009L;
    long expected = 2022;
    long result = KataStatic.findNb(input);
    assertEquals(expected, result);
    System.out.format("%s: findNb of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNb_2() {
    long input = 24723578342962L;
    long expected = -1;
    long result = KataStatic.findNb(input);
    assertEquals(expected, result);
    System.out.format("%s: findNb of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNb_3() {
    long input = 135440716410000L;
    long expected = 4824;
    long result = KataStatic.findNb(input);
    assertEquals(expected, result);
    System.out.format("%s: findNb of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void compArray() {
    int[] input_1 = new int[] {121, 144, 19, 161, 19, 144, 19, 11};
    int[] input_2 = new int[] {121, 14641, 20736, 361, 25921, 361, 20736, 361};
    boolean result = KataStatic.compArray(input_1, input_2);
    assertTrue(result);
    System.out.format(
        "%s: compArray of %s and %s is %b\n",
        name.getMethodName(), Arrays.toString(input_1), Arrays.toString(input_2), result);
  }

  @Test
  public void findNextSquare_1() {
    long input = 3;
    long expected = -1;
    long result = KataStatic.findNextSquare(input);
    assertEquals(expected, result);
    System.out.format("%s: findNextSquare of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void findNextSquare_2() {
    long input = 4;
    long expected = 9;
    long result = KataStatic.findNextSquare(input);
    assertEquals(expected, result);
    System.out.format("%s: findNextSquare of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void digital_root_1() {
    int input = 31;
    int expected = 4;
    int result = KataStatic.digital_root(input);
    assertEquals(expected, result);
    System.out.format("%s: digital_root of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void digital_root_2() {
    int input = 99;
    int expected = 9;
    int result = KataStatic.digital_root(input);
    assertEquals(expected, result);
    System.out.format("%s: digital_root of %d is %d\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight_1() {
    String input = "103 123 4444 99 2000";
    String expected = "2000 103 123 4444 99";
    String result = KataStatic.orderWeight(input);
    assertEquals(expected, result);
    System.out.format("%s: orderWeight of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight_2() {
    String input = "2000 10003 1234000 44444444 9999 11 11 22 123";
    String expected = "11 11 2000 10003 22 123 1234000 44444444 9999";
    String result = KataStatic.orderWeight(input);
    assertEquals(expected, result);
    System.out.format("%s: orderWeight of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight2_1() {
    String input = "103 123 4444 99 2000";
    String expected = "2000 103 123 4444 99";
    String result = KataStatic.orderWeight2(input);
    assertEquals(expected, result);
    System.out.format("%s: orderWeight of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void orderWeight2_2() {
    String input = "2000 10003 1234000 44444444 9999 11 11 22 123";
    String expected = "11 11 2000 10003 22 123 1234000 44444444 9999";
    String result = KataStatic.orderWeight2(input);
    assertEquals(expected, result);
    System.out.format("%s: orderWeight2 of %s is %s\n", name.getMethodName(), input, result);
  }

  @Test
  public void inArray_1() {
    String[] input_1 = new String[] {"arp", "live", "strong"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] expected = new String[] {"arp", "live", "strong"};
    String[] result = KataStatic.inArray(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: inArray of %s and %s is %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void inArray_2() {
    String[] input_1 = new String[] {"tarp", "mice", "bull"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] expected = new String[] {};
    String[] result = KataStatic.inArray(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: inArray of %s and %s is %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void inArray2_1() {
    String[] input_1 = new String[] {"arp", "live", "strong"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] expected = new String[] {"arp", "live", "strong"};
    String[] result = KataStatic.inArray2(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: inArray2 of %s and %s is %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void inArray2_2() {
    String[] input_1 = new String[] {"tarp", "mice", "bull"};
    String[] input_2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
    String[] expected = new String[] {};
    String[] result = KataStatic.inArray2(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: inArray2 of %s and %s is %s\n",
        name.getMethodName(),
        Arrays.toString(input_1),
        Arrays.toString(input_2),
        Arrays.toString(result));
  }

  @Test
  public void count_find_num_1() {
    int[] input_1 = new int[] {2, 5, 7};
    int input_2 = 500;
    int[] expected = new int[] {1, 70};
    int[] result = KataStatic.count_find_num(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: count_find_num of %s and %d is %s\n",
        name.getMethodName(), Arrays.toString(input_1), input_2, Arrays.toString(result));
  }

  @Test
  public void count_find_num_2() {
    int[] input_1 = new int[] {2, 3, 47};
    int input_2 = 200;
    int[] expected = new int[] {};
    int[] result = KataStatic.count_find_num(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: count_find_num of %s and %d is %s\n",
        name.getMethodName(), Arrays.toString(input_1), input_2, Arrays.toString(result));
  }

  @Test
  public void count_find_num_3() {
    int[] input_1 = new int[] {2, 3, 47};
    int input_2 = 282;
    int[] expected = new int[] {1, 282};
    int[] result = KataStatic.count_find_num(input_1, input_2);
    assertArrayEquals(expected, result);
    System.out.format(
        "%s: count_find_num of %s and %d is %s\n",
        name.getMethodName(), Arrays.toString(input_1), input_2, Arrays.toString(result));
  }
}
