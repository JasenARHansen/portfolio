package Java.test.challenge;

import static org.junit.Assert.*;

import Java.code.challenge.PowersOfBase;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PowersOfBaseTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    PowersOfBase.getDescription();
  }

  @Test
  public void getNPowersOfBase_2_1() {
    int expected = 1;
    int numberBase = 2;
    int powerBase = 5;
    String input = "101";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_2_2() {
    int expected = 3;
    int numberBase = 2;
    int powerBase = 5;
    String input = "111";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_2_3() {
    int expected = 2;
    int numberBase = 2;
    int powerBase = 5;
    String input = "101011001";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_2_4() {
    int expected = 0;
    int numberBase = 2;
    int powerBase = 5;
    String input = "101011000";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_2_5() {
    int expected = 2;
    int numberBase = 2;
    int powerBase = 5;
    String input = "101101";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_2_6() {
    int expected = 4;
    int numberBase = 2;
    int powerBase = 5;
    String input = "10010010001";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_10_1() {
    int expected = 1;
    int numberBase = 10;
    int powerBase = 5;
    String input = "5";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_10_2() {
    int expected = 1;
    int numberBase = 10;
    int powerBase = 5;
    String input = "25";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_10_3() {
    int expected = 2;
    int numberBase = 10;
    int powerBase = 5;
    String input = "55";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_10_4() {
    int expected = 0;
    int numberBase = 10;
    int powerBase = 5;
    String input = "56";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_7_1() {
    int expected = 1;
    int numberBase = 7;
    int powerBase = 5;
    String input = "34";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_7_2() {
    int expected = 2;
    int numberBase = 7;
    int powerBase = 5;
    String input = "3400034";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d' '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void getNPowersOfBase_7_3() {
    int expected = 2;
    int numberBase = 7;
    int powerBase = 6;
    String input = "651";
    List<String> result = PowersOfBase.splitPowersOfBase(numberBase, powerBase, input);
    assertEquals(expected, result.size());
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' splits '%d' times into values that"
            + " are a power of '%d'"
            + " '%s'\n",
        name.getMethodName(), input, numberBase, result.size(), powerBase, result);
  }

  @Test
  public void validatePowerOfBase_10_1() {
    String input = "4";
    int numberBase = 10;
    int powerBase = 2;
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_10_2() {
    int numberBase = 10;
    int powerBase = 2;
    String input = "5";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertFalse(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_10_3() {
    int numberBase = 10;
    int powerBase = 2;
    String input = "16";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_10_4() {
    int numberBase = 10;
    int powerBase = 5;
    String input = "390625";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_2_1() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "1011111010111100001";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_2_2() {
    int numberBase = 2;
    int powerBase = 5;
    String input = "101111101011110000";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertFalse(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_16_1() {
    int numberBase = 16;
    int powerBase = 5;
    String input = "5F5E1";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_16_2() {
    int numberBase = 16;
    int powerBase = 5;
    String input = "5F5E0";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertFalse(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_7_1() {
    int numberBase = 7;
    int powerBase = 7;
    String input = "10";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_7_2() {
    int numberBase = 7;
    int powerBase = 7;
    String input = "11";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertFalse(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_7_3() {
    int numberBase = 7;
    int powerBase = 5;
    String input = "34";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_7_4() {
    int numberBase = 7;
    int powerBase = 5;
    String input = "33";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertFalse(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }

  @Test
  public void validatePowerOfBase_7_5() {
    int numberBase = 7;
    int powerBase = 6;
    String input = "51";
    boolean result = PowersOfBase.validatePowerOfBase(numberBase, powerBase, input);
    assertTrue(result);
    System.out.format(
        "%s: The string '%s' with a numeric base of '%d' is a power of '%d': %b\n",
        name.getMethodName(), input, numberBase, powerBase, result);
  }
}
