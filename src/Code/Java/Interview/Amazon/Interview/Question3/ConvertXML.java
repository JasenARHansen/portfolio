package Code.Java.Interview.Amazon.Interview.Question3;

import java.util.*;

public class ConvertXML {


    public static void getDescription() {
        System.out.println("""
                Implement a function that given rules will convert a string into valid XML
                                
                String hello
                                
                rules:
                  [
                    ["b", "1", "4"],
                    ["i", "2", "4"]
                  ]
                                
                  output: h<b>e<i>ll<\\i><\\b>o""".indent(2));
    }

    public static String convert(String input, String[][] rules) {
        Stack<String> applied = new Stack<>();
        Stack<String> swap = new Stack<>();
        Map<String, List<Integer>> processed = new HashMap<>();
        // Process rules
        for (String[] rule : rules) {
            processed.put(rule[0], new ArrayList<>());
            processed.get(rule[0]).add(Integer.parseInt(rule[1]));
            processed.get(rule[0]).add(Integer.parseInt(rule[2]));
        }
        // Create tag order
        List<String> keyList = new ArrayList<>(processed.keySet());
        // Reverse to make end tag order match
        List<String> keyListReversed = new ArrayList<>(processed.keySet());
        Collections.reverse(keyListReversed);

        StringBuilder returnString = new StringBuilder();

        for (int index = 0; index < input.length(); index++) {
            for (String key : keyList) {
                if (processed.get(key).get(0) == index) {
                    applied.push(key);
                    returnString.append(String.format("<%s>", key));
                }
            }
            returnString.append(input.charAt(index));
            for (String key : keyListReversed) {
                if (processed.get(key).get(1) == index) {
                    while (!applied.peek().equals(key)) {
                        returnString.append(String.format("</%s>", applied.peek()));
                        swap.push(applied.pop());
                    }
                    returnString.append(String.format("</%s>", applied.pop()));
                }
                while (!swap.isEmpty()) {
                    returnString.append(String.format("<%s>", swap.peek()));
                    applied.push(swap.pop());
                }
            }
        }

        return returnString.toString();
    }
}
