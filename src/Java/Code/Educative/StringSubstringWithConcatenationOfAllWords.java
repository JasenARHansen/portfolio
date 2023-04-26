package Java.Code.Educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSubstringWithConcatenationOfAllWords {
  /*
  You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

  You can return the answer in any order.

  Example 1:

  Input: s = "barfoothefoobarman", words = ["foo","bar"]
  Output: [0,9]
  Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
  The output order does not matter, returning [9,0] is fine too.

  Example 2:

  Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
  Output: []

  Example 3:

  Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
  Output: [6,9,12]

  Constraints:
      1 <= s.length <= 104
      s consists of lower-case English letters.
      1 <= words.length <= 5000
      1 <= words[i].length <= 30
      words[i] consists of lower-case English letters.
  */

  public static List<Integer> findSubstring(String string, String[] words) {
    List<Integer> returnList = new ArrayList<>();
    if ((words.length > 0) && (words[0] != null) && (!words[0].isEmpty())) {
      int length = words[0].length();
      List<String> available = new ArrayList<>(Arrays.asList(words));
      for (int start = 0; start < (string.length() - words.length * length); start++) {
        int offset = 0;
        while (available.contains(string.substring(start + offset, start + offset + length))) {
          available.remove(string.substring(start + offset, start + offset + length));
          offset += length;
        }
        if (available.isEmpty()) {
          returnList.add(start);
        }
        if (available.size() != words.length) {
          available = new ArrayList<>(Arrays.asList(words));
        }
      }
    }
    return returnList;
  }
}
