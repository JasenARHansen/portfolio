package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_02_Is_Permutation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "ConstantValue", "SpellCheckingInspection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_02_Is_Permutation_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void isPermutation_true() {
    String left = "apple";
    String right = "elppa";
    boolean result = Q1_02_Is_Permutation.isPermutation(left, right);
    assertTrue(result);
    System.out.format(
        "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, result);
  }

  @Test
  public void isPermutation_false() {
    String left = "cat";
    String right = "dog";
    boolean result = Q1_02_Is_Permutation.isPermutation(left, right);
    assertFalse(result);
    System.out.format(
        "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, result);
  }

  @Test
  public void isPermutation_solution_1_true() {
    String left = "123";
    String right = "321";
    boolean result = Q1_02_Is_Permutation.isPermutation_solution_1(left, right);
    assertTrue(result);
    System.out.format(
        "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, result);
  }

  @Test
  public void isPermutation_solution_1_false() {
    String left = "good";
    String right = "bad";
    boolean result = Q1_02_Is_Permutation.isPermutation_solution_1(left, right);
    assertFalse(result);
    System.out.format(
        "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, result);
  }

  @Test
  public void isPermutation_solution_2_true() {
    String left = "god";
    String right = "dog";
    boolean result = Q1_02_Is_Permutation.isPermutation_solution_2(left, right);
    assertTrue(result);
    System.out.format(
        "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, result);
  }

  @Test
  public void isPermutation_solution_2_false() {
    String left = "right";
    String right = "wrong";
    boolean result = Q1_02_Is_Permutation.isPermutation_solution_2(left, right);
    assertFalse(result);
    System.out.format(
        "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, result);
  }
}
