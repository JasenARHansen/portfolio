package Java.code.interview.Google.jan_14_2021.interview_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"DuplicatedCode", "DataFlowIssue"})
public class Sequence {
  /*
  Assume you have a deck of cards, each with an integer number on it (no suits).
  Define "X of a kind" as X cards of the same number.
  (X>=2) Define an algorithm to determine if the deck can be fully divided into "X of a kind"s. */
  public static boolean XofAKind(ArrayList<Integer> input) throws Exception {
    // When I asked an empty list should return true
    if (input == null) {
      throw new Exception("No values provided");
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int value : input) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else {
        map.put(value, 1);
      }
    }
    for (Integer key : map.keySet()) {
      if (map.get(key) < 2) {
        return false;
      }
    }
    return true;
  }

  public static boolean straights(ArrayList<Integer> input) throws Exception {
    /*
    Define "Straight" as 5 cards with consecutive numbers.
    Define an algorithm to determine if the deck can be fully divided into "Straight"s. */
    if (input == null) {
      throw new Exception("No values provided");
    }
    if ((input.size() % 5) != 0) {
      return false;
    }
    Map<Integer, Integer> values = new HashMap<>();
    for (int value : input) {
      if (values.containsKey(value)) {
        values.put(value, values.get(value) + 1);
      } else {
        values.put(value, 1);
      }
    }
    List<Integer> sortedKeys = values.keySet().stream().sorted().toList();
    for (int index = 0; index < sortedKeys.size(); index++) {
      int base = sortedKeys.get(index);
      while (values.get(base) != 0) {
        // This shows that it is impossible to complete a sequence
        if ((index + 4) >= sortedKeys.size()) {
          return false;
        }
        values.put(base, values.get(base) - 1);
        for (int i = 1; i < 5; i++) {
          if (!values.containsKey(base + i)) {
            return false;
          }
          values.put(base + i, values.get(base + i) - 1);
          if (values.get(base + i) < 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
  // If I had time I would have sorted the key-set
  // from there I was going to start at the first element of the sorted keys and find if that led to
  // a  straight.
  // As I hit each number I would decrement the value of the count of that number
  // I would repeat the above until the count of the start bucket was 0 and then move to the next
  // start bucket.
  // if I ever hist a sequence that did not have 5 consecutive elements it would terminate as false
  // if the false never happened, return true
}
