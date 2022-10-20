package Test.Java.HackerRank.DictionariesAndHashmaps;

import Code.Java.HackerRank.DictionariesAndHashmaps.CountTriplets;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountTriplets_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void countTriplets_1() {
    long expected = 2;
    List<Long> values = List.of(1L, 4L, 16L, 64L);
    long base = 4;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_2() {
    long expected = 2;
    List<Long> values = List.of(1L, 2L, 2L, 4L);
    long base = 2;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_3() {
    long expected = 6;
    List<Long> values = List.of(1L, 3L, 9L, 9L, 27L, 81L);
    long base = 3;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_5() {
    long expected = 4;
    List<Long> values = List.of(1L, 5L, 5L, 25L, 125L);
    long base = 5;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_6() {
    long expected = 0;
    List<Long> values = List.of(1L, 5L, 5L, 125L);
    long base = 5;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_7() {
    long expected = 0;
    List<Long> values = List.of();
    long base = 5;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_8() {
    long expected = 0;
    List<Long> values = List.of(1L, 4L, -16L, 64L);
    long base = 4;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_9() {
    long expected = 161700;
    List<Long> values =
            List.of(
                    1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                    1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                    1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                    1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L,
                    1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
    long base = 1;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_10() {
    long expected = 1;
    List<Long> values = List.of(1L, 2L, 3L, 4L);
    long base = 2;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_11() {
    long expected = 4;
    List<Long> values = List.of(0L, 0L, 0L, 0L);
    long base = 0;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_12() {
    long expected = 4;
    List<Long> values = List.of(0L, 0L, 2L, 0L, 0L);
    long base = 0;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values, result);

    assertEquals(expected, result);
  }
}
