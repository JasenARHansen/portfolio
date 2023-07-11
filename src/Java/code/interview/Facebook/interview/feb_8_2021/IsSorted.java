package Java.code.interview.Facebook.interview.feb_8_2021;

import java.util.HashMap;
import java.util.Map;

public class IsSorted {
  public static void getDescription() {
    System.out.println(
        """
                Write a function to verify whether a list of strings is sorted given a specific ordering.
                Input:
                  words = ['cc', 'cb', 'bc', 'ac']
                  ordering = ['c', 'b', 'a']
                Output: True
                Input:
                  words = ['cc', 'cb', 'bc', 'ac']
                  ordering = ['b', 'c', 'a']
                Output: False
                words will always be defined and never null
                words = []
                true
                words = ['', 'cc', 'cb', 'bc', 'ac']
                ['c', 'b', 'a']
                true
                ordering = ['c', 'b', 'a']
                words = ['ccc', 'cb']
                true
                words = ['ccc', 'cc']
                false
                bad input so won't happen
                words = ['cq', 'cc']
                Time complexity
                M = length of largest string
                N = length Strings
                O(M*N)"""
            .indent(2));
  }

  public static boolean isSorted(char[] ordering, String[] words) {
    // If there are 0 or 1 words it is sorted by default
    if (words.length <= 1) {
      return true;
    }
    // Populate rules and assign values
    Map<Character, Integer> map = new HashMap<>();
    for (int index = 0; index < ordering.length; index++) {
      map.put(ordering[index], index);
    }
    String last = words[0];
    for (int i = 1; i < words.length; i++) {
      int index = 0;
      if (last.isEmpty() || last.equals(words[i])) {
        last = words[i];
        continue;
      }
      boolean not_sorted = true;
      while (index < Math.min(last.length(), words[i].length())) {
        if (last.charAt(index) != words[i].charAt(index)) {
          if (map.get(last.charAt(index)) > map.get(words[i].charAt(index))) {
            return false;
          } else if (map.get(last.charAt(index)) < map.get(words[i].charAt(index))) {
            not_sorted = false;
            break;
          }
        }
        index++;
      }
      if (not_sorted && (last.length() > words[i].length())) {
        return false;
      }
      last = words[i];
    }
    return true;
  }
}
