package Code.Interview.Amazon.Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question_4 {

  /*
  Implement a string shortening function using the following prototype
  string Shorten(string input_string, int prefix_size)

  The shortening process has 3 parts.
      - Part 1 : The first prefix_size characters of the input string
      - Part 2 : An integer reprentation of the count of internal characters // Non displayed characters
      - Part 3 : The last character of the input string

  Examples:
  Shorten("internationalization", 1) = i18n
  Shorten("internationalization", 2) = in17n
  */

    // Question 1: if input is "in" is the output "in" or "i0n"
    // Question 2: if input is "i" is the output "i" "i0"
    // Question 3: if input is null Output is "Not valid"
    // Question 4: if p[refix size is greater than string, return string]

    // input_string "AB" prefix_size = 1
    // input_string "ABC" prefix_size = 1

    public static String Shorten(String input_string, int prefix_size) {
        if ((input_string == null) || (prefix_size < 0)) {
            return "Not valid";
        }

        if ((prefix_size > input_string.length() - 2)) {
            return input_string;
        }

        String returnString = input_string.substring(0, prefix_size); // A
        returnString += input_string.length() - prefix_size - 1; // A1
        returnString += input_string.charAt(input_string.length() - 1); // A0C

        return returnString;
    }

  /*
  Using the Shorten function from Part 1 of the problem, implement a string array shortening function using the following prototype.
  Array<String> ShortenAll(Array<String> input_array)

  The value returned by ShortenAll must adhere to two constraints.
      -Uniqueness: Every value in the output should uniquely reference only 1 input
      -Shortness: Every value in the output should be the shortest representation possible of the input

  Example:
  ShortenAll(["abbbc", "adbbc", "abcccd"]) = ["ab2c", "ad2c", "a4d"]
  Note that the shortest representation for the first two elements is "a3c" but we cannot return that value as it
   violates the uniqueness constraint.
  */

    public static List<String> ShortenAll(List<String> input_array) {
        return ShortenAll(input_array, 1);
    }

    public static List<String> ShortenAll(List<String> input_array, int prefix_size) {
        List<String> returnVal = new ArrayList<>();
        Map<String, List<String>> myMap = new HashMap<>();
        for (String input_string : input_array) {
            String working = Shorten(input_string, prefix_size);
            if (!myMap.containsKey(working)) {
                myMap.put(working, new ArrayList<>());
            }
            myMap.get(working).add(input_string);
        }

        for (String key : myMap.keySet()) {
            if (myMap.get(key).size() == 1) {
                returnVal.add(key);
            } else {
                returnVal.addAll(ShortenAll(myMap.get(key), prefix_size + 1));
            }
        }

        return returnVal;
    }
}
