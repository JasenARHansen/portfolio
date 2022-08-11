package Code.Interview.Amazon.Interview;

import java.util.*;

public class question_3 {


  /*
   Implement a function that given rules will convert a string into valid XML


  String hello

  rules:
    [
      ["b", "1", "4"],
      ["i", "2", "4"]
    ]

    output: h<b>e<i>ll<\i><\b>o
  * */

    public static String convert(String input, String[][] rules) {
        Stack applied = new Stack();
        Stack swap = new Stack();
        Map<String, List<Integer>> processed = new HashMap<>();
        for (String[] rule : rules) {
            processed.put(rule[0], new ArrayList<>());
            processed.get(rule[0]).add(Integer.parseInt(rule[1]));
            processed.get(rule[0]).add(Integer.parseInt(rule[2]));
        }

        List<String> keyList = new ArrayList<>(processed.keySet());
        List<String> keyListReversed = new ArrayList<>(processed.keySet());
        Collections.reverse(keyListReversed);

        String returnString = "";

        for (int index = 0; index < input.length(); index++) {
            for (String key : keyList) {
                if (processed.get(key).get(0) == index) {
                    applied.push(key);
                    returnString += String.format("<%s>", key);
                }
            }
            returnString += input.charAt(index);
            for (String key : keyListReversed) {
                if (processed.get(key).get(1) == index) {
                    while (!applied.peek().equals(key)) {
                        returnString += String.format("</%s>", applied.peek());
                        swap.push(applied.pop());
                    }
                    returnString += String.format("</%s>", applied.pop());
                }
                while (!swap.isEmpty()) {
                    returnString += String.format("<%s>", swap.peek());
                    applied.push(swap.pop());
                }
            }
        }

        return returnString;
    }
}
