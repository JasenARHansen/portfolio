package Test.HackerRank.DictionariesAndHashmaps;

import Code.HackerRank.DictionariesAndHashmaps.CountTriplets;
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
    List<Long> values = List.of(1l, 4l, 16l, 64l);
    long base = 4;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_2() {
    long expected = 2;
    List<Long> values = List.of(1l, 2l, 2l, 4l);
    long base = 2;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_3() {
    long expected = 6;
    List<Long> values = List.of(1l, 3l, 9l, 9l, 27l, 81l);
    long base = 3;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_5() {
    long expected = 4;
    List<Long> values = List.of(1l, 5l, 5l, 25l, 125l);
    long base = 5;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_6() {
    long expected = 0;
    List<Long> values = List.of(1l, 5l, 5l, 125l);
    long base = 5;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

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
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_8() {
    long expected = 0;
    List<Long> values = List.of(1l, 4l, -16l, 64l);
    long base = 4;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_9() {
    long expected = 161700;
    List<Long> values =
            List.of(
                    1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
                    1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
                    1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
                    1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
                    1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l);
    long base = 1;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_10() {
    long expected = 1;
    List<Long> values = List.of(1l, 2l, 3l, 4l);
    long base = 2;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_11() {
    long expected = 4;
    List<Long> values = List.of(0l, 0l, 0l, 0l);
    long base = 0;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }

  @Test
  public void countTriplets_12() {
    long expected = 4;
    List<Long> values = List.of(0l, 0l, 2l, 0l, 0l);
    long base = 0;
    long result = CountTriplets.countTriplets(values, base);
    System.out.format(
            "%s: Given the base of %d and the values of '%s' there are %d triplets.\n",
            name.getMethodName(), base, values.toString(), result);

    assertEquals(expected, result);
  }
}
