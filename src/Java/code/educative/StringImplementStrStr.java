package Java.code.educative;

@SuppressWarnings("SpellCheckingInspection")
public class StringImplementStrStr {
  /*
  Implement strStr().
  Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
  Clarification:
  What should we return when needle is an empty string? This is a great question to ask during an interview.
  For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's
   strStr() and Java's indexOf().
  Example 1:
    Input: haystack = "hello", needle = "ll"
    Output: 2
  Example 2:
    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
  Example 3:
    Input: haystack = "", needle = ""
    Output: 0
  Constraints:
      0 <= haystack.length, needle.length <= 5 * 104
      haystack and needle consist of only lower-case English characters.
  */

  public static int strStr(String haystack, String needle) {
    if (needle == null) {
      return -1;
    }
    if (needle.isEmpty()) {
      return 0;
    }
    for (int haystackIndex = 0;
        haystackIndex < haystack.length() - needle.length();
        haystackIndex++) {
      if (haystack.charAt(haystackIndex) == needle.charAt(0)) {
        boolean found = true;
        for (int needleIndex = 1; needleIndex < needle.length() - 1; needleIndex++) {
          if (haystack.charAt(haystackIndex + needleIndex) != needle.charAt(needleIndex)) {
            found = false;
            break;
          }
        }
        if (found) {
          return haystackIndex;
        }
      }
    }
    return -1;
  }
}
