package Java.test.interview.Google;

import static org.junit.Assert.*;

import Java.code.interview.Google.string_arithmetic;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"DuplicatedCode", "OctalInteger"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringArithmeticTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void convert_string() {
    List<String> expected = new ArrayList<>();
    expected.add("4");
    expected.add("3");
    expected.add("2");
    expected.add("1");
    List<String> output = string_arithmetic.convert("1234");
    assertEquals(expected, output);
  }

  @Test
  public void convert_string_empty() {
    List<String> expected = new ArrayList<>();
    expected.add("0");
    List<String> output = string_arithmetic.convert("");
    assertEquals(expected, output);
  }

  @Test
  public void convert_string_zero() {
    List<String> expected = new ArrayList<>();
    expected.add("0");
    List<String> output = string_arithmetic.convert("0");
    assertEquals(expected, output);
  }

  @Test
  public void convert_string_zeros() {
    List<String> expected = new ArrayList<>();
    expected.add("0");
    List<String> output = string_arithmetic.convert("00000");
    assertEquals(expected, output);
  }

  @Test
  public void convert_string_padded_zeros() {
    List<String> expected = new ArrayList<>();
    expected.add("1");
    List<String> output = string_arithmetic.convert("000001");
    assertEquals(expected, output);
  }

  @Test
  public void convert_number() {
    List<String> expected = new ArrayList<>();
    expected.add("4");
    expected.add("3");
    expected.add("2");
    expected.add("1");
    List<String> output = string_arithmetic.convert(1234);
    assertEquals(expected, output);
  }

  @Test
  public void convert_number_zero() {
    List<String> expected = new ArrayList<>();
    expected.add("0");
    List<String> output = string_arithmetic.convert(0);
    assertEquals(expected, output);
  }

  @Test
  public void convert_number_zeros() {
    List<String> expected = new ArrayList<>();
    expected.add("0");
    List<String> output = string_arithmetic.convert(000000);
    assertEquals(expected, output);
  }

  @Test
  public void convert_number_padded_zeros() {
    List<String> expected = new ArrayList<>();
    expected.add("1");
    List<String> output = string_arithmetic.convert(000001);
    assertEquals(expected, output);
  }

  @Test
  public void convert_number_list() {
    List<String> expected = new ArrayList<>();
    expected.add("4");
    expected.add("3");
    expected.add("2");
    expected.add("1");
    List<Integer> input = new ArrayList<>();
    input.add(4);
    input.add(3);
    input.add(2);
    input.add(1);
    List<String> output = string_arithmetic.convert(input);
    assertEquals(expected, output);
  }

  @Test
  public void convert_number_list_null() {
    List<String> expected = new ArrayList<>();
    expected.add("0");
    List<String> output = string_arithmetic.convert(null);
    assertEquals(expected, output);
  }

  @Test
  public void convert_number_list_empty() {
    List<String> expected = new ArrayList<>();
    expected.add("0");
    List<Integer> input = new ArrayList<>();
    List<String> output = string_arithmetic.convert(input);
    assertEquals(expected, output);
  }

  @Test
  public void convert_number_list_padded_zeros() {
    List<String> expected = new ArrayList<>();
    expected.add("4");
    expected.add("3");
    expected.add("2");
    expected.add("1");
    List<Integer> input = new ArrayList<>();
    input.add(4);
    input.add(3);
    input.add(2);
    input.add(1);
    input.add(0);
    List<String> output = string_arithmetic.convert(input);
    assertEquals(expected, output);
  }

  @Test
  public void trimZeros_string() {
    List<String> expected = new ArrayList<>();
    expected.add("4");
    expected.add("3");
    expected.add("2");
    expected.add("1");
    List<String> input = new ArrayList<>();
    input.add("4");
    input.add("3");
    input.add("2");
    input.add("1");
    input.add("0");
    List<String> result = string_arithmetic.convert(input);
    assertEquals(expected, result);
  }

  @Test
  public void trimZeros_number() {
    List<String> expected = new ArrayList<>();
    expected.add("4");
    expected.add("3");
    expected.add("2");
    expected.add("1");
    List<Integer> input = new ArrayList<>();
    input.add(4);
    input.add(3);
    input.add(2);
    input.add(1);
    input.add(0);
    List<String> result = string_arithmetic.convert(input);
    assertEquals(expected, result);
  }

  @Test
  public void greaterThan_less_digits() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.greaterThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, ">", rvalue, output);
    assertFalse(output);
  }

  public void print_test(
      String name, List<String> lvalue, String operation, List<String> rvalue, boolean solution) {
    System.out.printf(
        "%s: %s %s %s = %s\n",
        name,
        string_arithmetic.convert(lvalue),
        operation,
        string_arithmetic.convert(rvalue),
        solution);
  }

  @Test
  public void greaterThan_more_digits() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("1");
    lvalue.add("2");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("1");
    boolean output = string_arithmetic.greaterThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, ">", rvalue, output);
    assertTrue(output);
  }

  @Test
  public void greaterThan_equal() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("2");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.greaterThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, ">", rvalue, output);
    assertFalse(output);
  }

  @Test
  public void greaterThan_true() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("2");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("1");
    boolean output = string_arithmetic.greaterThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, ">", rvalue, output);
    assertTrue(output);
  }

  @Test
  public void greaterThan_false() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("1");
    lvalue.add("2");
    lvalue.add("3");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("1");
    rvalue.add("2");
    rvalue.add("2");
    boolean output = string_arithmetic.greaterThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, ">", rvalue, output);
    assertTrue(output);
  }

  @Test
  public void lessThan_less_digits() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.lessThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "<", rvalue, output);
    assertTrue(output);
  }

  @Test
  public void lessThan_more_digits() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("2");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("1");
    boolean output = string_arithmetic.lessThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "<", rvalue, output);
    assertFalse(output);
  }

  @Test
  public void lessThan_equal() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("1");
    boolean output = string_arithmetic.lessThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "<", rvalue, output);
    assertFalse(output);
  }

  @Test
  public void lessThan_true() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("2");
    lvalue.add("2");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("3");
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.lessThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "<", rvalue, output);
    assertTrue(output);
  }

  @Test
  public void lessThan_false() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("3");
    lvalue.add("2");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.lessThan(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "<", rvalue, output);
    assertFalse(output);
  }

  @Test
  public void equal_less_digits() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.equal(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "==", rvalue, output);
    assertFalse(output);
  }

  @Test
  public void equal_more_digits() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("2");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("1");
    boolean output = string_arithmetic.equal(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "==", rvalue, output);
    assertFalse(output);
  }

  @Test
  public void equal_true() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("2");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.equal(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "==", rvalue, output);
    assertTrue(output);
  }

  @Test
  public void equal_false() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("1");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    boolean output = string_arithmetic.equal(lvalue, rvalue);
    print_test(name.getMethodName(), lvalue, "==", rvalue, output);
    assertFalse(output);
  }

  @Test
  public void add() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("4");
    lvalue.add("3");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("6");
    expected.add("4");
    List<String> output = string_arithmetic.add(lvalue, rvalue);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "+", rvalue, output);
  }

  public void print_test(
      String name,
      List<String> lvalue,
      String operation,
      List<String> rvalue,
      List<String> solution) {
    System.out.printf(
        "%s: %s %s %s = %s\n",
        name,
        string_arithmetic.convert(lvalue),
        operation,
        string_arithmetic.convert(rvalue),
        string_arithmetic.convert(solution));
  }

  @Test
  public void add_base_5() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("4");
    lvalue.add("3");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("1");
    expected.add("0");
    expected.add("1");
    List<String> output = string_arithmetic.add(lvalue, rvalue, 5);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "+", rvalue, output);
  }

  @Test
  public void subtract() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("4");
    lvalue.add("3");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("2");
    expected.add("2");
    List<String> output = string_arithmetic.subtract(lvalue, rvalue);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "-", rvalue, output);
  }

  @Test
  public void subtract_base_5() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("3");
    lvalue.add("3");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("4");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("4");
    expected.add("1");
    List<String> output = string_arithmetic.subtract(lvalue, rvalue, 5);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "-", rvalue, output);
  }

  @Test
  public void multiply() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("4");
    lvalue.add("3");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("8");
    expected.add("0");
    expected.add("4");
    List<String> output = string_arithmetic.multiply(lvalue, rvalue);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "*", rvalue, output);
  }

  @Test
  public void multiply_base_5() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("4");
    lvalue.add("3");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("3");
    expected.add("1");
    expected.add("0");
    expected.add("1");
    List<String> output = string_arithmetic.multiply(lvalue, rvalue, 5);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "*", rvalue, output);
  }

  @Test
  public void divide() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("0");
    lvalue.add("0");
    lvalue.add("0");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("3");
    expected.add("8");
    List<String> output = string_arithmetic.divide(lvalue, rvalue);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "/", rvalue, output);
  }

  @Test
  public void divide_base_5() {
    List<String> lvalue = new ArrayList<>();
    lvalue.add("0");
    lvalue.add("0");
    lvalue.add("0");
    lvalue.add("1");
    List<String> rvalue = new ArrayList<>();
    rvalue.add("2");
    rvalue.add("1");
    List<String> expected = new ArrayList<>();
    expected.add("2");
    expected.add("3");
    List<String> output = string_arithmetic.divide(lvalue, rvalue, 5);
    assertEquals(expected, output);
    print_test(name.getMethodName(), lvalue, "/", rvalue, output);
  }
}
