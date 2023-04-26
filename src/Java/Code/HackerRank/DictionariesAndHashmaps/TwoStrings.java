package Java.Code.HackerRank.DictionariesAndHashmaps;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
  /*
  Given two strings, determine if they share a common substring. A substring may be as small as one character.

  Example
    s1 = 'and'
    s2 = 'art'
  These share the common substring 'a'.
    s1 = 'abe'
    s2 = 'cat'
  These do not share a substring.

  Function Description
    Complete the function twoStrings in the editor below.
    twoStrings has the following parameter(s):
      string s1: a string
      string s2: another string

  Returns
      string: either YES or NO

  Input Format
    The first line contains a single integer p, the number of test cases.
    The following p pairs of lines are as follows:
      The first line contains string s1.
      The second line contains string s2.

  Constraints

  and
  consist of characters in the range ascii[a-z].

  Output Format

  For each pair of strings, return YES or NO.

  Sample Input
    2
    hello
    world
    hi
    world

  Sample Output
    YES
    NO

  Explanation
    We have p = 2 pairs to check:
      1. s1 = 'hello', s2 = 'world'. The substrings 'o' and 'l'  are common to both strings.
      2, s1 = 'hi', s2 = 'world'. s1 and s2 share no common substrings.
  */

    public static String twoStrings(String s1, String s2) {
        String left;
        String right;
        if (s1.length() < s2.length()) {
            left = s1;
            right = s2;
        } else {
            left = s2;
            right = s1;
        }
        Set<String> searched = new HashSet<>();
        String substring;
        for (int leftIndex = 0; leftIndex < left.length(); leftIndex++) {
            for (int rightIndex = leftIndex + 1; rightIndex <= left.length(); rightIndex++) {
                substring = left.substring(leftIndex, rightIndex);
                if (searched.add(substring)) {
                    if (right.contains(substring)) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }
}
