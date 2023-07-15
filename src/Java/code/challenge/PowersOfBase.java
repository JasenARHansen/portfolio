package Java.code.challenge;

import java.util.ArrayList;
import java.util.List;

public class PowersOfBase {
    public static void main(String[] argv) {
        getDescription();
    }

    public static void getDescription() {
        System.out.println(
                """
                        Given a string of representing a number, a numeric base, and an exponent base,
                         if possible, tell the minimum number of splits that are required such that each split
                         part is a number which can be represented as power of X in the provided numeric
                         base and tell the least number of splits.
                        Sample:
                         1. The string '101011001' with a numeric base of '2' splits '2' times into values that are a
                             power of '5' '[101, 011001]'
                         2. The string '101011000' with a numeric base of '2' splits '0' times into values that are a
                             power of '5' '[]
                         3. The string '55' with a numeric base of '10' splits '2' times into values that are a power
                             of '5' '[5, 5]'
                         4. The string '56' with a numeric base of '10' splits '0' times into values that are a power
                             of '5' '[]'"""
                        .indent(2));
    }

    public static List<String> splitPowersOfBase(int numberBase, int powerBase, String input) {
        List<String> returnList = new ArrayList<>();
        // Case 1: String already meets criteria
        if (validatePowerOfBase(numberBase, powerBase, input)) {
            returnList.add(input);
        } else {
            // find the smallest number of splits that meets criteria
            for (int i = 1; i < input.length(); i++) {
                String left = input.substring(0, i);
                if (validatePowerOfBase(numberBase, powerBase, left)) {
                    String right = input.substring(i);
                    List<String> newList = splitPowersOfBase(numberBase, powerBase, right);
                    if (!newList.isEmpty()) {
                        newList.add(0, left);
                        if (returnList.isEmpty()) {
                            returnList = newList;
                        } else if (newList.size() < returnList.size()) {
                            returnList = newList;
                        }
                    }
                }
            }
        }
        return returnList;
    }

    public static boolean validatePowerOfBase(int numberBase, int powerBase, String input) {
        // Convert
        int value = Integer.valueOf(input, numberBase);
        return validatePowerOfBase(powerBase, value);
    }

    public static boolean validatePowerOfBase(int powerBase, int input) {
        // Convert
        // http://www.tpub.com/math1/9.htm
        // 5^x = value -> log base 5 of value = x
        // http://www.mathwords.com/c/change_of_base_formula.htm
        // log base y of value = x -> (ln value)/ (ln y) = X
        double variable = Math.log(input) / Math.log(powerBase);
        // Test if result is an integer equivalent. If so it is a power.
        return (variable == Math.floor(variable)) && !Double.isInfinite(variable);
    }
}
