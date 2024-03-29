package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_02_Check_Permutation;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
public class QuestionB {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "cat"}, {"carrot", "fish"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false; // Permutations must be same length
        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true; // letters array has no negative values, and therefore no positive values either
    }
}
