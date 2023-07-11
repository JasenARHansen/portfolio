package Java.code.interview.Facebook.practice;

public class LookAndSay {
  public static void getDescription() {
    System.out.println(
        """
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
                """
            .indent(2));
  }

  public static String lookAndSay(int start) {
    return lookAndSay(String.valueOf(start));
  }

  public static String lookAndSay(String start) {
    char[] values = start.toCharArray();
    StringBuilder output = new StringBuilder();
    int count;
    char character;
    for (int index = 0; index < values.length; index++) {
      count = 1;
      character = values[index];
      while ((index < values.length - 1) && (values[index] == values[index + 1])) {
        count++;
        index++;
      }
      output.append(count).append(character);
    }
    return output.toString();
  }

  public static String lookAndSayReverse(int start) {
    return lookAndSayReverse(String.valueOf(start));
  }

  public static String lookAndSayReverse(String start) {
    StringBuilder output = new StringBuilder();
    if (start.length() <= 1) {
      return output.toString();
    }
    int index = 0;
    char character;
    while (index < start.length()) {
      character = start.charAt(index + 1);
      output.append(
          String.valueOf(character)
              .repeat(Math.max(0, Character.getNumericValue(start.charAt(index)))));
      index += 2;
    }
    return output.toString();
  }
}
