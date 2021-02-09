package Code.interview.Facebook.interview.Feb_8_2021;

import java.util.HashMap;
import java.util.Map;

public class question_1 {
  /*
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
  O(M*N)
  */

    public static boolean sorted(char[] ordering, String[] words) {
        if (words.length == 0) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < ordering.length; index++) {
            map.put(ordering[index], index);
        }
        String last = words[0];
        for (int i = 1; i < words.length; i++) {
            int index = 0;
            while ((index < last.length()) && (index < words[i].length())) {
                if (last.charAt(index) != words[i].charAt(index)) {
                    if (map.get(last.charAt(index)) > map.get(words[i].charAt(index))) {
                        return false;
                    } else if (map.get(last.charAt(index)) < map.get(words[i].charAt(index))) {
                        break;
                    }
                }
                index++;
            }
            if (last.length() > words[i].length()) {
                return false;
            }
            last = words[i];
        }
        return true;
    }
}
