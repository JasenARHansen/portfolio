package Java.code.interview.Facebook.practice;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("SpellCheckingInspection")
public class MinimumLengthSubstrings {
    public static void getDescription() {
        System.out.println(
                """
                        Minimum Length Substrings
                        You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
                        Signature
                        int minLengthSubstring(String s, String t)
                        Input
                         s and t are non-empty strings that contain less than 1,000,000 characters each
                        Output
                         Return the minimum length of the substring of s. If it is not possible, return -1
                        Example
                         s = "dcbefebce"
                         t = "fd"
                         output = 5
                        Explanation:
                        Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the
                         minimum length required is 5.
                        """
                        .indent(2));
    }

    public static int minLengthSubstring(String s, String t) {
        int returnValue = -1;
        if (!(t.length() > s.length()) && (!s.isEmpty())) {
            List<Character> chars = t.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            int index = 0;
            while ((index < s.length()) && !chars.isEmpty()) {
                chars.remove(Character.valueOf(s.charAt(index)));
                index++;
            }
            if (chars.isEmpty()) {
                returnValue = index;
            }
            int compare = minLengthSubstring(s.substring(1), t);
            if ((compare >= 0) && (compare < index)) {
                returnValue = compare;
            }
        }
        return returnValue;
    }
}
