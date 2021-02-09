package Code.interview.Google;

import java.util.Map;

public class palindrome {

    public static boolean detect(String value) {
        int length = value.length();
        for (int i = 0; i < length / 2; i++) {
            char left = Character.toLowerCase(value.charAt(i));
            char right = Character.toLowerCase(value.charAt(length - 1 - i));
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    public static Map.Entry<String, String> transform(String value) {
        String source;
        String modification;
        if ((value.length() == 0) || (value.length() == 1)) {
            source = value;
            modification = value;
        } else if (Character.toLowerCase(value.charAt(0)) == Character.toLowerCase(value.charAt(value.length() - 1))) {
            // First and last character are the same
            Map.Entry<String, String> return_value = transform(value.substring(1, value.length() - 1));
            source = value.charAt(0) +
                    return_value.getKey() +
                    value.charAt(value.length() - 1);
            modification = value.charAt(0) +
                    return_value.getValue() +
                    value.charAt(value.length() - 1);
        } else {
            // Remove first char
            Map.Entry<String, String> strip_first = transform(value.substring(1));

            // Remove last char
            Map.Entry<String, String> strip_last = transform(value.substring(0, value.length() - 1));

            if (strip_first.getKey().length() < strip_last.getKey().length()) {
                source = value.charAt(0) +
                        strip_first.getKey() +
                        value.charAt(0);

                modification = value.charAt(0) +
                        strip_first.getValue() +
                        "+";
            } else {
                source = value.charAt(value.length() - 1) +
                        strip_last.getKey() +
                        value.charAt(value.length() - 1);

                modification = "+" +
                        strip_last.getValue() +
                        value.charAt(value.length() - 1);

            }
        }

        return Map.entry(source, modification);
    }

    public static String convert(Map.Entry<String, String> value) {
        return value.getKey();
    }

    public static String report(Map.Entry<String, String> value) {
        return value.getValue();
    }

    public static void main(String[] argv) {
        getDescription();
    }

    public static void getDescription() {
        System.out.println("A tool to detect palindromes and convert strings to a palindrome.");
    }

}
