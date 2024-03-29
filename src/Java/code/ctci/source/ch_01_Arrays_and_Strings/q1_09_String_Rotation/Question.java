package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_09_String_Rotation;

@SuppressWarnings("SpellCheckingInspection")
public class Question {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* check that s1 and s2 are equal length and not empty. */
        if (len == s2.length() && len > 0) {
            /* concatenate s1 and s1 within new buffer. */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static boolean isSubstring(String big, String small) {
        return big.contains(small);
    }
}
