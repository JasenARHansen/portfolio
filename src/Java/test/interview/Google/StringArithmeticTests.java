package Java.test.interview.Google;

import Java.code.interview.Google.string_arithmetic;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings({"DuplicatedCode", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringArithmeticTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void add() {
        List<String> expected = new ArrayList<>();
        expected.add("6");
        expected.add("4");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("4");
        lvalue.add("3");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        List<String> result = string_arithmetic.add(lvalue, rvalue);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "+",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void add_base_5() {
        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("0");
        expected.add("1");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("4");
        lvalue.add("3");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        List<String> result = string_arithmetic.add(lvalue, rvalue, 5);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "+",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void convert_number() {
        List<String> expected = new ArrayList<>();
        expected.add("4");
        expected.add("3");
        expected.add("2");
        expected.add("1");
        printTestHeader(name.getMethodName());
        int source = 1234;
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %d, Result: %s\n", source, result);
    }

    @Test
    public void convert_number_list() {
        List<String> expected = new ArrayList<>();
        expected.add("4");
        expected.add("3");
        expected.add("2");
        expected.add("1");
        printTestHeader(name.getMethodName());
        List<Integer> source = new ArrayList<>();
        source.add(4);
        source.add(3);
        source.add(2);
        source.add(1);
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void convert_number_list_empty() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        printTestHeader(name.getMethodName());
        List<Integer> source = new ArrayList<>();
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void convert_number_list_null() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        printTestHeader(name.getMethodName());
        List<String> result = string_arithmetic.convert(null);
        assertEquals(expected, result);
        System.out.format("\tSource: nll, Result: %s\n", result);
    }

    @Test
    public void convert_number_list_padded_zeros() {
        List<String> expected = new ArrayList<>();
        expected.add("4");
        expected.add("3");
        expected.add("2");
        expected.add("1");
        printTestHeader(name.getMethodName());
        List<Integer> source = new ArrayList<>();
        source.add(4);
        source.add(3);
        source.add(2);
        source.add(1);
        source.add(0);
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void convert_number_zero() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        printTestHeader(name.getMethodName());
        int source = 0;
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %d, Result: %s\n", source, result);
    }

    @Test
    public void convert_string() {
        List<String> expected = new ArrayList<>();
        expected.add("4");
        expected.add("3");
        expected.add("2");
        expected.add("1");
        printTestHeader(name.getMethodName());
        String source = "1234";
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void convert_string_empty() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        printTestHeader(name.getMethodName());
        String source = "";
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void convert_string_padded_zeros() {
        List<String> expected = new ArrayList<>();
        expected.add("1");
        printTestHeader(name.getMethodName());
        String source = "000001";
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void convert_string_zero() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        printTestHeader(name.getMethodName());
        String source = "0";
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void convert_string_zeros() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        printTestHeader(name.getMethodName());
        String source = "00000";
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void divide() {
        List<String> expected = new ArrayList<>();
        expected.add("3");
        expected.add("8");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("0");
        lvalue.add("0");
        lvalue.add("0");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        List<String> result = string_arithmetic.divide(lvalue, rvalue);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "/",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void divide_base_5() {
        List<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("3");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("0");
        lvalue.add("0");
        lvalue.add("0");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        List<String> result = string_arithmetic.divide(lvalue, rvalue, 5);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "/",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void equal_false() {
        List<String> lvalue = new ArrayList<>();
        lvalue.add("1");
        lvalue.add("1");
        printTestHeader(name.getMethodName());
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.equal(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "==", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void equal_less_digits() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.equal(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "==", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void equal_more_digits() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("2");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("1");
        boolean result = string_arithmetic.equal(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "==", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void equal_true() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("2");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.equal(lvalue, rvalue);
        assertTrue(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "==", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void greaterThan_equal() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("2");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.greaterThan(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), ">", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void greaterThan_false() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("1");
        lvalue.add("2");
        lvalue.add("3");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("1");
        rvalue.add("2");
        rvalue.add("2");
        boolean result = string_arithmetic.greaterThan(lvalue, rvalue);
        assertTrue(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), ">", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void greaterThan_less_digits() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.greaterThan(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), ">", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void greaterThan_more_digits() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("1");
        lvalue.add("2");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("1");
        boolean result = string_arithmetic.greaterThan(lvalue, rvalue);
        assertTrue(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), ">", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void greaterThan_true() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("2");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("1");
        boolean result = string_arithmetic.greaterThan(lvalue, rvalue);
        assertTrue(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), ">", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void lessThan_equal() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("1");
        boolean result = string_arithmetic.lessThan(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "<", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void lessThan_false() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("3");
        lvalue.add("2");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.lessThan(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "<", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void lessThan_less_digits() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.lessThan(lvalue, rvalue);
        assertTrue(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "<", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void lessThan_more_digits() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("2");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("1");
        boolean result = string_arithmetic.lessThan(lvalue, rvalue);
        assertFalse(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "<", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void lessThan_true() {
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("2");
        lvalue.add("2");
        lvalue.add("1");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("3");
        rvalue.add("2");
        rvalue.add("1");
        boolean result = string_arithmetic.lessThan(lvalue, rvalue);
        assertTrue(result);
        System.out.printf(
                "\t%s %s %s = %b\n",
                string_arithmetic.convert(lvalue), "<", string_arithmetic.convert(rvalue), result);
    }

    @Test
    public void multiply() {
        List<String> expected = new ArrayList<>();
        expected.add("8");
        expected.add("0");
        expected.add("4");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("4");
        lvalue.add("3");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        List<String> result = string_arithmetic.multiply(lvalue, rvalue);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "*",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void multiply_base_5() {
        List<String> expected = new ArrayList<>();
        expected.add("3");
        expected.add("1");
        expected.add("0");
        expected.add("1");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("4");
        lvalue.add("3");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        List<String> result = string_arithmetic.multiply(lvalue, rvalue, 5);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "*",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void subtract() {
        List<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("2");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("4");
        lvalue.add("3");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("2");
        rvalue.add("1");
        List<String> result = string_arithmetic.subtract(lvalue, rvalue);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "-",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void subtract_base_5() {
        List<String> expected = new ArrayList<>();
        expected.add("4");
        expected.add("1");
        printTestHeader(name.getMethodName());
        List<String> lvalue = new ArrayList<>();
        lvalue.add("3");
        lvalue.add("3");
        List<String> rvalue = new ArrayList<>();
        rvalue.add("4");
        rvalue.add("1");
        List<String> result = string_arithmetic.subtract(lvalue, rvalue, 5);
        assertEquals(expected, result);
        System.out.printf(
                "\t%s %s %s = %s\n",
                string_arithmetic.convert(lvalue),
                "-",
                string_arithmetic.convert(rvalue),
                string_arithmetic.convert(result));
    }

    @Test
    public void trimZeros_number() {
        List<String> expected = new ArrayList<>();
        expected.add("4");
        expected.add("3");
        expected.add("2");
        expected.add("1");
        printTestHeader(name.getMethodName());
        List<Integer> source = new ArrayList<>();
        source.add(4);
        source.add(3);
        source.add(2);
        source.add(1);
        source.add(0);
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }

    @Test
    public void trimZeros_string() {
        List<String> expected = new ArrayList<>();
        expected.add("4");
        expected.add("3");
        expected.add("2");
        expected.add("1");
        printTestHeader(name.getMethodName());
        List<String> source = new ArrayList<>();
        source.add("4");
        source.add("3");
        source.add("2");
        source.add("1");
        source.add("0");
        List<String> result = string_arithmetic.convert(source);
        assertEquals(expected, result);
        System.out.format("\tSource: %s, Result: %s\n", source, result);
    }
}
