package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_01_Is_Unique;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_01_Is_Unique_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void isUniqueChars_true() {
    String word = "cat";
    boolean result = Q1_01_Is_Unique.isUnique(word);
    assertTrue(result);
    System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, result);
  }

  @Test
  public void isUniqueChars_false() {
    String word = "Jasen Hansen";
    boolean result = Q1_01_Is_Unique.isUnique(word);
    assertFalse(result);
    System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, result);
  }

  @Test
  public void isUniqueChars_solution_1_true() {
    String word = "cake";
    boolean result = Q1_01_Is_Unique.isUnique_solution_1(word);
    assertTrue(result);
    System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, result);
  }

  @Test
  public void isUniqueChars_solution_1_false() {
    String word = "teapot";
    boolean result = Q1_01_Is_Unique.isUnique_solution_1(word);
    assertFalse(result);
    System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, result);
  }

  @Test
  public void isUniqueChars_solution_2_true() {
    String word = "cake";
    boolean result = Q1_01_Is_Unique.isUnique_solution_2(word);
    assertTrue(result);
    System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, result);
  }

  @Test
  public void isUniqueChars_solution_2_false() {
    String word = "teapot";
    boolean result = Q1_01_Is_Unique.isUnique_solution_2(word);
    assertFalse(result);
    System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, result);
  }
}
