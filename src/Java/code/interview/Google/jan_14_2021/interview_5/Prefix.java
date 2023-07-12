package Java.code.interview.Google.jan_14_2021.interview_5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SpellCheckingInspection"})
public class Prefix {
  public static void getDescription() {
    System.out.println(
        """
                Write a function that, given a list of strings, returns the longest
                  common prefix for more than half of the strings.
                Example:
                  ["abc", "bc", "ab", "abdabz123", "abe", "bz"]  →  "ab"
                  ["a", "b"] → ""
                Let n be the size of 'inputs'
                Let m be the size of the largest string
                Runtime: O(n*m)
                Space: O(n*m)"""
            .indent(2));
  }

  public static String longestPrefix(List<String> inputs) {
    if (inputs == null) {
      return "No values provided";
    }
    Map<String, Integer> map = new HashMap<>();
    for (String input : inputs) {
      for (int stopIndex = 1; stopIndex <= input.length(); stopIndex++) {
        String subString = input.substring(0, stopIndex);
        if (map.containsKey(subString)) {
          map.put(subString, map.get(subString) + 1);
        } else {
          map.put(subString, 1);
        }
      }
    }
    int minCount = inputs.size() / 2;
    String longestPrefix = "";
    int longestLength = 0;
    for (String key : map.keySet()) {
      int count = map.get(key);
      int currentLength = key.length();
      if (count > minCount) {
        if (longestLength < currentLength) {
          longestLength = currentLength;
          longestPrefix = key;
        }
      }
    }
    return longestPrefix;
  }
}
