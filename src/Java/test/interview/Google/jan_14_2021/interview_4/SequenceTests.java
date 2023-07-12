package Java.test.interview.Google.jan_14_2021.interview_4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.code.interview.Google.jan_14_2021.interview_4.Sequence;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SequenceTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void XofAKind_1() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 6, 6, 6, 6));
    boolean result = Sequence.XofAKind(inputs);
    assertFalse(result);
    System.out.format(
        "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void XofAKind_2() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 6, 6, 6, 6));
    boolean result = Sequence.XofAKind(inputs);
    assertTrue(result);
    System.out.format(
        "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void XofAKind_3() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 5, 6, 5, 6, 6, 6));
    boolean result = Sequence.XofAKind(inputs);
    assertTrue(result);
    System.out.format(
        "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void XofAKind_4() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of());
    boolean result = Sequence.XofAKind(inputs);
    assertTrue(result);
    System.out.format(
        "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void XofAKind_5() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    boolean result = Sequence.XofAKind(inputs);
    assertFalse(result);
    System.out.format(
        "%s: list %s can be broken up to entirely X of a kind sequences: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void XofAKind_6() {
    boolean result = Sequence.XofAKind(null);
    assertFalse(result);
    System.out.format(
        "%s: list null can be broken up to entirely of straights of 5 cards: %b\n",
        name.getMethodName(), result);
  }

  @Test
  public void straights_1() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    boolean result = Sequence.straights(inputs);
    assertFalse(result);
    System.out.format(
        "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void straights_2() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 3, 4, 5, 6));
    boolean result = Sequence.straights(inputs);
    assertTrue(result);
    System.out.format(
        "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void straights_3() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 3, 4, 5, 7));
    boolean result = Sequence.straights(inputs);
    assertFalse(result);
    System.out.format(
        "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void straights_4() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(6, 2, 4, 1, 3, 5, 4, 5, 2, 3));
    boolean result = Sequence.straights(inputs);
    assertTrue(result);
    System.out.format(
        "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void straights_5() {
    ArrayList<Integer> inputs = new ArrayList<>(List.of(2, 4, 1, 3, 5, 4, 5, 2, 3, 3));
    boolean result = Sequence.straights(inputs);
    assertFalse(result);
    System.out.format(
        "%s: list %s can be broken up to entirely of straights of 5 cards: %b\n",
        name.getMethodName(), inputs, result);
  }

  @Test
  public void straights_6() {
    Sequence.straights(null);
    boolean result = Sequence.straights(null);
    assertFalse(result);
    System.out.format(
        "%s: list null can be broken up to entirely of straights of 5 cards: %b\n",
        name.getMethodName(), result);
  }
}
