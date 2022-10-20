package Code.Java.Educative;

import java.util.HashSet;
import java.util.Set;

public class StringsStringSegmentation {
  /*
  You are given a dictionary of words and a large input string. You have to find out whether the input
   string can be completely segmented into the words of a given dictionary. The following example
   elaborates on the problem further.
  Given a dictionary of words:
    apple,apple, pear, pie
  Input string of "applepie" can be segmented into dictionary words "apple" "pie"
  Input string of "applepeer" cannotbe segmented into dictionary words

  Runtime complexity: Exponential, O(2^n), if we only use recursion. With memoization, the runtime
   complexity of this solution can be improved to be polynomial, O(n^2).

  Memory Complexity: Polynomial, O(n^2)

  You can solve this problem by segmenting the large string at each possible position to see if the
   string can be completely segmented to words in the dictionary. If you write the algorithm in steps
   it will be as follows:

  n = length of input string
  for i = 0 to n - 1
    first_word = substring (input string from index [0, i] )
    second_word = substring (input string from index [i + 1, n - 1] )
    if dictionary has first_word
      if second_word is in dictionary OR second_word is of zero length, then return true
      recursively call this method with second_word as input and return true if it can be segmented

  The algorithm will compute two strings from scratch in each iteration of the loop. Worst case scenario,
   there would be a recursive call of the second_word each time. This shoots the time complexity up to
   2^n.

  You can see that you may be computing the same substring multiple times, even if it doesn’t exist in the
   dictionary. This redundancy can be fixed by memoization, where you remember which substrings have
   already been solved.

  To achieve memoization, you can store the second string in a new set each time. This will reduce both time
   and memory complexities.
  */

  public static boolean can_segment_string(String sentence, Set<String> dictionary) {
    Set<String> failed = new HashSet<>();
    return testString(sentence, dictionary, failed);
  }

  private static boolean testString(String subString, Set<String> dictionary, Set<String> failed) {
    // Test base string
    if (dictionary.contains(subString)) {
      return true;
    }
    if (subString.length() == 1) {
      return false;
    }

    for (int index = 1; index < subString.length(); index++) {
      String leftSubString = subString.substring(0, index);
      boolean containsLeft = false;
      if (dictionary.contains(leftSubString)) {
        containsLeft = true;
      } else if (failed.contains(leftSubString)) {
        containsLeft = false;
      } else {
        containsLeft = testString(leftSubString, dictionary, failed);
      }

      if (containsLeft) {
        dictionary.add(leftSubString);
      } else {
        failed.add(leftSubString);
      }

      String rightSubString = subString.substring(index);
      boolean containsRight = false;
      if (dictionary.contains(rightSubString)) {
        containsRight = true;
      } else if (failed.contains(rightSubString)) {
        containsRight = false;
      } else {
        containsRight = testString(rightSubString, dictionary, failed);
      }
      if (containsRight) {
        dictionary.add(rightSubString);
      } else {
        failed.add(rightSubString);
      }
      if (containsLeft && containsRight) {
        return true;
      }
    }
    return false;
  }
}
