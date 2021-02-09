package Code.interview.Google.Jan_14_2021.interview_5; // Write a function that, given a list of
// strings,
// returns the
// longest common prefix for more than half of the strings.

/*
Example:

["abc", "bc", "ab", "abdabz123", "abe", "bz"]  →  "ab"
["a", "b"] → ""
*/

// Let n be the size of 'inputs'
// Let m be the size of the largest string

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prefix {
  private static Object HashMap;

  public static String longestPrefix(@SuppressWarnings("ConstantConditions") List<String> inputs)
          throws Exception {
    if (inputs == null) {
      throw new Exception("No values provided");
    }
    Map<String, Integer> map = new HashMap<>();
    for (String input : inputs) {
      for (int stopindex = 1; stopindex <= input.length(); stopindex++) {
        String subString = input.substring(0, stopindex);
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
// Runtime: O(n*m)
// Space: O(n*m)
