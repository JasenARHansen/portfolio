package interview.google;

import java.util.ArrayList;
import java.util.List;

public class string_arithmetic {

    // https://math.stackexchange.com/questions/975541/what-are-the-formal-names-of-operands-and-results-for-basic-operations

    public static void getDescription() {
        System.out.println("Performs addition of using lists of strings");
    }

    private static List<String> convertString(String input) {
        List<String> string_list = new ArrayList<>();
        input = input.trim();
        if (input.length() > 0) {
            String[] string_array = input.split("");
            for (String value : string_array) {
                string_list.add(0, value);
            }
        } else {
            string_list.add("0");
        }
        return string_list;
    }

    private static List<String> convertNumber(int input) {
        return convertString(Integer.toString(input));
    }

    private static List<String> convertToStringList(List<Integer> numeric_list) {
        List<String> string_list = new ArrayList<>();
        for (Integer value : numeric_list) {
            string_list.add(String.valueOf(value));
        }
        return string_list;
    }

    private static String convertToString(List<String> input) {
        String returnString = "";
        for (String value : input) {
            returnString = value.concat(returnString);
        }
        return returnString;
    }

    private static <E> void trimZeros(List<E> input) {
        while (input.size() > 1 && String.valueOf(input.get(input.size() - 1)).equals("0")) {
            input.remove(input.size() - 1);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<String> convert(Object value) {
        ArrayList<Object> temp_list;
        List<String> return_list = null;
        if (value == null) {
            return_list = new ArrayList<>();
            return_list.add("0");
        } else if (value instanceof String)
            return_list = convertString((String) value);
        else if (value instanceof Integer)
            return_list = convertNumber((Integer) value);
        else if (value instanceof ArrayList) {
            temp_list = (ArrayList<Object>) value;
            if (temp_list.isEmpty()) {
                return_list = new ArrayList<>();
                return_list.add("0");
            } else if (temp_list.get(0) instanceof String)
                return_list = (ArrayList<String>) (Object) temp_list;
            else if (temp_list.get(0) instanceof Integer)
                return_list = convertToStringList((ArrayList<Integer>) (Object) temp_list);
        }
        if (return_list != null)
            trimZeros(return_list);
        return return_list;
    }

    public static boolean greaterThan(Object lvalue, Object rvalue) {
        List<String> left_list = convert(lvalue);
        List<String> right_list = convert(rvalue);

        boolean returnValue = false;
        if (left_list.size() > right_list.size()) {
            returnValue = true;
        } else if (left_list.size() == right_list.size()) {
            for (int index = left_list.size() - 1; index >= 0; index--) {
                if (Integer.parseInt(left_list.get(index)) < Integer.parseInt(right_list.get(index))) {
                    break;
                } else if (Integer.parseInt(left_list.get(index)) > Integer.parseInt(right_list.get(index))) {
                    returnValue = true;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static boolean lessThan(Object lvalue, Object rvalue) {
        List<String> left_list = convert(lvalue);
        List<String> right_list = convert(rvalue);
        boolean returnValue = false;
        if (left_list.size() < right_list.size()) {
            returnValue = true;
        } else if (left_list.size() == right_list.size()) {
            for (int index = left_list.size() - 1; index >= 0; index--) {
                if (Integer.parseInt(left_list.get(index)) > Integer.parseInt(right_list.get(index))) {
                    break;
                } else if (Integer.parseInt(left_list.get(index)) < Integer.parseInt(right_list.get(index))) {
                    returnValue = true;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static boolean equal(Object lvalue, Object rvalue) {
        List<String> left_list = convert(lvalue);
        List<String> right_list = convert(rvalue);
        boolean returnValue = false;
        if (left_list.size() == right_list.size()) {
            returnValue = true;
            for (int index = left_list.size() - 1; index >= 0; index--) {
                if (Integer.parseInt(left_list.get(index)) != Integer.parseInt(right_list.get(index))) {
                    returnValue = false;
                    break;
                }
            }
        }
        return returnValue;
    }

    public static List<String> add(Object augend, Object addend, int... base) {
        // Addition: Augend + Addend = Sum
        List<String> augend_list = convert(augend);
        List<String> addend_list = convert(addend);
        List<Integer> addition = new ArrayList<>();
        int carry = 0;
        int size = Math.max(augend_list.size(), addend_list.size());
        int int_augend;
        int int_addend;
        int numeric_base;
        if (base.length > 0) {
            numeric_base = base[0];
        } else {
            numeric_base = 10;
        }
        for (int index = 0; index < size; index++) {
            if (index < augend_list.size()) {
                int_augend = Integer.parseInt(augend_list.get(index));
            } else {
                int_augend = 0;
            }
            if (index < addend_list.size()) {
                int_addend = Integer.parseInt(addend_list.get(index));
            } else {
                int_addend = 0;
            }
            int sum = int_augend + int_addend + carry;
            carry = sum / numeric_base;
            addition.add(sum % numeric_base);
        }
        if (carry > 0) {
            addition.add(carry);
        }
        return convertToStringList(addition);
    }

    public static List<String> subtract(Object minuend, Object subtrahend, int... base) {
        // Subtraction: Minuend - Subtrahend = Difference
        List<String> minuend_list = convert(minuend);
        List<String> subtrahend_list = convert(subtrahend);
        List<Integer> subtraction = new ArrayList<>();
        if (lessThan(minuend_list, subtrahend_list) || equal(minuend_list, subtrahend_list)) {
            subtraction.add(0);
        } else {
            int borrow = 0;
            int size = Math.max(minuend_list.size(), subtrahend_list.size());
            int int_minuend;
            int int_subtrahend;
            int numeric_base;

            if (base.length > 0) {
                numeric_base = base[0];
            } else {
                numeric_base = 10;
            }

            for (int index = 0; index < size; index++) {
                if (index < minuend_list.size()) {
                    int_minuend = Integer.parseInt(minuend_list.get(index));
                } else {
                    int_minuend = 0;
                }
                if (index < subtrahend_list.size()) {
                    int_subtrahend = Integer.parseInt(subtrahend_list.get(index));
                } else {
                    int_subtrahend = 0;
                }
                int difference = int_minuend - int_subtrahend - borrow;
                borrow = 0;

                if (difference < 0) {
                    borrow = 1;
                    difference += numeric_base;
                }
                subtraction.add(difference);
            }
        }
        // Remove leading zeros
        trimZeros(subtraction);

        return convertToStringList(subtraction);
    }

    public static List<String> multiply(Object multiplicand, Object multiplier, int... base) {
        // Multiplication: Multiplicand * Multiplier = Product
        List<String> multiplicand_list = convert(multiplicand);
        List<String> multiplier_list = convert(multiplier);
        List<String> multiplication = new ArrayList<>();
        int numeric_base;
        if (base.length > 0) {
            numeric_base = base[0];
        } else {
            numeric_base = 10;
        }
        for (int index = 0; index < multiplicand_list.size(); index++) {
            List<Integer> inner_value = new ArrayList<>();
            for (int count = 0; count < index; count++) {
                inner_value.add(0);
            }
            int carry = 0;
            int int_multiplicand = Integer.parseInt(multiplicand_list.get(index));
            for (String digit : multiplier_list) {
                int int_multiplier = Integer.parseInt(digit);
                int sum = int_multiplicand * int_multiplier + carry;
                carry = sum / numeric_base;
                inner_value.add(sum % numeric_base);
            }
            if (carry > 0) {
                inner_value.add(carry);
            }
            multiplication = add(multiplication, convertToStringList(inner_value), numeric_base);
        }
        return multiplication;
    }

    public static List<String> divide(Object dividend, Object divisor, int... base) {
        // Division: Dividend / Divisor = Quotient
        List<String> dividend_list = convert(dividend);
        List<String> divisor_list = convert(divisor);
        List<Integer> division = new ArrayList<>();
        int numeric_base;
        if (base.length > 0) {
            numeric_base = base[0];
        } else {
            numeric_base = 10;
        }

        // divisor 0
        if (divisor_list.isEmpty() || equal(divisor_list, 0) || lessThan(dividend_list, divisor_list)) {
            division.add(0);
        } else {
            List<String> internal = new ArrayList<>();
            int start_index = dividend_list.size() - 1;
            // Setup
            while (greaterThan(divisor_list, internal)) {
                internal.add(0, dividend_list.get(start_index));
                start_index--;
            }
            start_index++;
            for (int index = start_index; index >= 0; index--) {
                division.add(0, 0);
                boolean loop = true;
                while (loop) {
                    internal = subtract(internal, divisor_list, numeric_base);
                    division.set(0, division.get(0) + 1);
                    if (greaterThan(divisor_list, internal)) {
                        loop = false;
                    }
                }
                if (index > 0) {
                    internal.add(0, dividend_list.get(index - 1));
                }
            }
        }

        // Remove leading zeros
        trimZeros(division);

        return convertToStringList(division);
    }

    public static void printOutput(List<String> input) {
        System.out.println(convertToString(input));
    }

    public static void main(String[] argv) {
        getDescription();
    }

}
