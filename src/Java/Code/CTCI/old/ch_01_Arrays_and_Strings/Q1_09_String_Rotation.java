package Java.code.ctci.old.ch_01_Arrays_and_Strings;

public class Q1_09_String_Rotation {
  public static boolean isRotation(String left, String right) {
    if ((left == null)
        || (right == null)
        || (left.length() == 0)
        || (left.length() != right.length())) {
      return false;
    }
    String tempString = left + left;
    return tempString.contains(right);
  }

  public static boolean isRotation_solution_1(String s1, String s2) {
    int len = s1.length();
    /* check that s1 and s2 are equal length and not empty. */
    if (len == s2.length() && len > 0) {
      /* concatenate s1 and s1 within new buffer. */
      String s1s1 = s1 + s1;
      return isSubstring(s1s1, s2);
    }
    return false;
  }

  public static boolean isSubstring(String big, String small) {
    return big.contains(small);
  }
}
