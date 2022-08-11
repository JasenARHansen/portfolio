package Code.Educative;

import java.util.HashMap;
import java.util.Map;

public class StringMinimumAppendsForPalindrome {
  /*
  Given a string s we need to tell minimum characters to be appended (insertion at end) to make a string palindrome.

  Examples:

  Input : s = "abede"
  Output : 2
  We can make string palindrome as "abedeba"
  by adding ba at the end of the string.

  Input : s = "aabb"
  Output : 2
  We can make string palindrome as"aabbaa"
  by adding aa at the end of the string.

  Recommended: Please try your approach on {IDE} first, before moving on to the solution.

  The solution can be achieved by removing characters from the beginning of the string one by one and checking if
   the string is palindrome or not.
  For Example, consider the above string, s = “abede”.
  We check if the string is palindrome or not.
  The result is false, then we remove the character from the beginning of string and now string becomes “bede”.
  We check if the string is palindrome or not. The result is again false, then we remove the character from the
   beginning of string and now string becomes “ede”.
  We check if the string is palindrome or not. The result is true, so the output becomes 2 which is the number of
   characters removed from the string.

  The above approach described and O(n**2) approach.

  Efficient Approach:

  We also have an algorithm taking the help of Knuth Morris Pratt Algorithm which is O(n) Time Complexity.

  The basic idea behind the approach is that we calculate the largest substring from the end can be calculated and
   the length of the string minus this value is the minimum number of appends. The logic is intuitive, we need not
   append the palindrome and only those which do not form the palindrome. To find this largest palindrome from the
   end, we reverse the string, calculate the dfa and reverse the string again(thus gaining back the original string)
   and finding the final state, which represents the number of matches of the string with the revered string and
   hence we get the largest substring that is a palindrome from the end, in O(n) time.

  Below is the implementation of the above approach:
  Output

  3
  0

  Suggestion by:  Pratik Priyadarsan

   Related Article :
  Dynamic Programming | Set 28 (Minimum insertions to form a palindrome)
  This article is contributed by Shubham Chaudhary. If you like GeeksforGeeks and would like to contribute, you can
   also write an article using contribute.geeksforgeeks.org or mail your article to contribute@geeksforgeeks.org.
   See your article appearing on the GeeksforGeeks main page and help other Geeks.
  Please write comments if you find anything incorrect, or you want to share more information about the topic
   discussed above.
  */

  public static int minimumAppends(String string) {
    Map<String, Integer> history = new HashMap<>();
    return _minimumAppends(string, history);
  }

  public static int _minimumAppends(String string, Map<String, Integer> history) {
    if (string == null) {
      return 0;
    }
    if (string.isEmpty() || string.length() == 1) {
      return 0;
    }
    int offset = 0;
    while ((string.charAt(offset) == string.charAt(string.length() - 1 - offset))
        && (offset < string.length() / 2)) {
      offset++;
    }
    if (string.length() - (2 * offset) > 1) {
      String left = string.substring(offset + 1, string.length() - offset);
      int trimLeft;
      if (history.containsKey(left)) {
        trimLeft = history.get(left);
      } else {
        trimLeft = _minimumAppends(left, history);
        history.put(left, trimLeft);
      }
      String right = string.substring(offset, string.length() - offset - 1);
      int trimRight;
      if (history.containsKey(right)) {
        trimRight = history.get(right);
      } else {
        trimRight = _minimumAppends(right, history);
        history.put(right, trimRight);
      }
      return Math.min(trimLeft, trimRight) + 1;
    } else {
      return 0;
    }
  }
}
