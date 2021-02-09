package Test.chalenge;

import Code.chalenge.PowersOfBase;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PowersOfBaseTest {

  @Rule
  public TestName name = new TestName();

  @Test
  public void getNPowersOfBase_1() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "101";
    int expected = 1;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_2() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "111";
    int expected = 3;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_3() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "101011001";
    int expected = 2;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_4() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "101011000";
    int expected = 0;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_5() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "101101";
    int expected = 2;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_6() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "10010010001";
    int expected = 4;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_7() {
    int numberBase = 10;
    int powerBase = 5;
    String input = "5";
    int expected = 1;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_8() {
    int numberBase = 10;
    int powerBase = 5;
    String input = "25";
    int expected = 1;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_9() {
    int numberBase = 10;
    int powerBase = 5;
    String input = "55";
    int expected = 2;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_10() {
    int numberBase = 10;
    int powerBase = 5;
    String input = "56";
    int expected = 0;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_11() {
    int numberBase = 7;
    int powerBase = 5;
    String input = "34";
    int expected = 1;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_12() {
    int numberBase = 7;
    int powerBase = 5;
    String input = "3400034";
    int expected = 2;
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d' '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void getNPowersOfBase_13() {
    int numberBase = 7;
    int powerBase = 6;
    String input = "651";
    int expected = 2;

    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that are a power of '%d'"
                    + " '%s'\n",
            name.getMethodName(), input, numberBase, result.size(), powerBase, result.toString());
    assertEquals(expected, result.size());
  }

  @Test
  public void validatePowerOfBase_1() {
    int numberBase = 10;
    int powerBase = 2;
    String input = "4";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }

  @Test
  public void validatePowerOfBase_2() {
    int numberBase = 10;
    int powerBase = 2;
    String input = "5";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertFalse(result);
  }

  @Test
  public void validatePowerOfBase_3() {
    int numberBase = 10;
    int powerBase = 2;
    String input = "16";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }

  @Test
  public void validatePowerOfBase_5() {
    int numberBase = 10;
    int powerBase = 5;
    String input = "390625";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }

  @Test
  public void validatePowerOfBase_6() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "1011111010111100001";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }

  @Test
  public void validatePowerOfBase_7() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "101111101011110000";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertFalse(result);
  }

  @Test
  public void validatePowerOfBase_8() {
    int numberBase = 16;
    int powerBase = 5;
    String input = "5F5E1";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }

  @Test
  public void validatePowerOfBase_9() {
    int numberBase = 16;
    int powerBase = 5;
    String input = "5F5E0";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertFalse(result);
  }

  @Test
  public void validatePowerOfBase_10() {
    int numberBase = 7;
    int powerBase = 7;
    String input = "10";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }

  @Test
  public void validatePowerOfBase_11() {
    int numberBase = 7;
    int powerBase = 7;
    String input = "11";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertFalse(result);
  }

  @Test
  public void validatePowerOfBase_12() {
    int numberBase = 7;
    int powerBase = 5;
    String input = "34";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }

  @Test
  public void validatePowerOfBase_13() {
    int numberBase = 7;
    int powerBase = 5;
    String input = "33";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertFalse(result);
  }

  @Test
  public void validatePowerOfBase_14() {
    int numberBase = 7;
    int powerBase = 6;
    String input = "51";

    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    System.out.format(
            "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
            name.getMethodName(), input, numberBase, powerBase, result);
    assertTrue(result);
  }
}
