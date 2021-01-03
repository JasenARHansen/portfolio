package classes.unsorted.classesMain;

import java.util.ArrayList;
import java.util.List;

public class PowersOfBase {

    private static void getDescription() {
        System.out.println(
                "Given a string of 0 and 1, if possible, tell that how many splits would be required such that each split part is a number which can be represented as power of 5 in binary and tell the least number of splits.");
    }

    public static void main(String[] argv) {
        getDescription();

        List<String> value;
        int base = 5;

        String input = "101";
        value = splitPowersOfBase(base, input);
        if (value != null) {
            System.out.format("The string '%s' splits '%d' times into  '%s'\n", input, value.size(), value.toString());
        } else {
            System.out.format("The string '%s' does not split\n", input);
        }
        input = "111";
        value = splitPowersOfBase(base, input);
        if (value != null) {
            System.out.format("The string '%s' splits '%d' times into  '%s'\n", input, value.size(), value.toString());
        } else {
            System.out.format("The string '%s' does not split\n", input);
        }
        input = "101011001";
        value = splitPowersOfBase(base, input);
        if (value != null) {
            System.out.format("The string '%s' splits '%d' times into  '%s'\n", input, value.size(), value.toString());
        } else {
            System.out.format("The string '%s' does not split\n", input);
        }
        input = "101011000";
        value = splitPowersOfBase(base, input);
        if (value != null) {
            System.out.format("The string '%s' splits '%d' times into  '%s'\n", input, value.size(), value.toString());
        } else {
            System.out.format("The string '%s' does not split\n", input);
        }

    }

    private static List<String> splitPowersOfBase(int base, String input) {

        List<String> returnList = null;
        // Case 1: String already meets criteria
        if (validatePoserOfBase(base, input)) {
            returnList = new ArrayList<>();
            returnList.add(input);
        } else {
            for (int i = 1; i < input.length() - 1; i++) {
                String left = input.substring(0, i);
                if (validatePoserOfBase(base, left)) {
                    String right = input.substring(i);
                    List<String> newList = splitPowersOfBase(base, right);
                    if (newList != null) {
                        newList.add(0, left);
                        if (returnList == null) {
                            returnList = newList;
                        } else {
                            if (newList.size() < returnList.size()) {
                                returnList = newList;
                            }
                        }
                    } else {
                        returnList = null;
                    }
                }
            }
        }
        return returnList;
    }

    private static boolean validatePoserOfBase(int base, String input) {
        // Convert
        int value = Integer.valueOf(input, 2);
        // http://www.tpub.com/math1/9.htm
        // 5^x = value -> log base 5 of value = x
        // http://www.mathwords.com/c/change_of_base_formula.htm
        // log base 5 of value = x -> ( ln value)/ (ln base) = X
        double variable = Math.log(value) / Math.log(5);
        // Test if result is an integer equivalent. If so it is a power.
        return (variable == Math.floor(variable)) && !Double.isInfinite(variable);
    }

}
