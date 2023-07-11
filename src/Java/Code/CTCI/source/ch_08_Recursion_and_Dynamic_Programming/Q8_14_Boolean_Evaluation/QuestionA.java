package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_14_Boolean_Evaluation;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
  public static int count = 0;

  public static boolean stringToBool(String c) {
    return c.equals("1");
  }

  public static int countEval(String s, boolean result) {
    count++;
    if (s.length() == 0) return 0;
    if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
    int ways = 0;
    for (int i = 1; i < s.length(); i += 2) {
      char c = s.charAt(i);
      String left = s.substring(0, i);
      String right = s.substring(i + 1);
      int leftTrue = countEval(left, true);
      int leftFalse = countEval(left, false);
      int rightTrue = countEval(right, true);
      int rightFalse = countEval(right, false);
      int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
      int totalTrue = 0;
      if (c == '^') { // required: one true and one false
        totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
      } else if (c == '&') { // required: both true
        totalTrue = leftTrue * rightTrue;
      } else if (c == '|') { // required: anything but both false
        totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
      }
      int subWays = result ? totalTrue : total - totalTrue;
      ways += subWays;
    }
    return ways;
  }

  public static void main(String[] args) {
    String expression = "0^0|1&1^1|0|1";
    boolean result = true;
    System.out.println(countEval(expression, result));
    System.out.println(count);
  }
}
