package Java.code.ctci.old.ch_01_Arrays_and_Strings;

@SuppressWarnings("DuplicatedCode")
public class Q1_06_String_Compression {
    public static String stringCompression(String input) {
        // Base case for short-circuiting
        if (input == null) {
            return null;
        }
        StringBuilder returnString = new StringBuilder();
        char[] char_array = input.toCharArray();
        int nextPointer = 1;
        int comparePointer = 0;
        int compareCount = 1;
        while (nextPointer < input.length()) {
            if (char_array[comparePointer] == char_array[nextPointer]) {
                compareCount++;
            } else {
                returnString.append(char_array[comparePointer]).append(compareCount);
                comparePointer = nextPointer;
                compareCount = 1;
            }
            nextPointer++;
        }
        // Add items still being processed
        returnString.append(char_array[comparePointer]).append(compareCount);
        return (returnString.length() < input.length()) ? returnString.toString() : input;
    }

    public static String stringCompression_solution_1(String str) {
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different then current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString.append(str.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

    public static String stringCompression_solution_2(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different then current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static String stringCompression_solution_3(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;
        StringBuilder compressed = new StringBuilder(finalLength); // initialize capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different then current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    public static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different then current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}
