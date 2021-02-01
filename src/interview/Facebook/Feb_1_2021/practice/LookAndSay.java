package interview.Facebook.Feb_1_2021.practice;

public class LookAndSay {
  /*
  Question 2: Look and Say
  Implement a function that outputs the Look and Say sequence:
  1
  11
  21
  1211
  111221
  312211
  13112221
  1113213211
  31131211131221
  13211311123113112211

  To generate a member of the sequence from the previous member, read off the digits of the previous member, counting the number of digits in groups of the same digit. For example:
      1 is read off as "one 1" or 11.
      11 is read off as "two 1s" or 21.
      21 is read off as "one 2, then one 1" or 1211.
      1211 is read off as "one 1, one 2, then two 1s" or 111221.
      111221 is read off as "three 1s, two 2s, then one 1" or 312211.
  */

  public static String lookAndSay(int start) {
    return lookAndSay(String.valueOf(start));
  }

  public static String lookAndSay(String start) {
    char[] values = start.toCharArray();
    String output = "";
    int count;
    char character;
    for (int index = 0; index < values.length; index++) {
      count = 1;
      character = values[index];
      while ((index < values.length - 1) && (values[index] == values[index + 1])) {
        count++;
        index++;
      }
      output += String.valueOf(count) + Character.valueOf(character);
    }
    return output;
  }
}
