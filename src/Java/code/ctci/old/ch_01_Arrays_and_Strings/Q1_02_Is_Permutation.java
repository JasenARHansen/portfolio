package Java.code.ctci.old.ch_01_Arrays_and_Strings;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Q1_02_Is_Permutation {
    public static boolean isPermutation(String left, String right) {
        return convertAndSort(left).equals(convertAndSort(right));
    }

    public static String convertAndSort(String input) {
        char[] content = input.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutation_solution_1(String s, String t) {
        // They did the same thing I did.
        return convertAndSort(s).equals(convertAndSort(t));
    }

    public static boolean isPermutation_solution_2(String s, String t) {
        // They added short-circuiting.
        if (s.length() != t.length()) return false; // Permutations must be same length
        // They created an int array to count the numbers of character occurrences
        int[] letters = new int[128]; // Assumption: ASCII
        // They count the character occurrences by incrementing the location corresponding to the
        // character.
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        // They perform the inverse logic by processing the second string and decrementing the character
        // location.
        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            // If a character count goes negative they know that they have used more of a character than
            // the first / string had.
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true; // letters array has no negative values, and therefore no positive values either
    }
}
