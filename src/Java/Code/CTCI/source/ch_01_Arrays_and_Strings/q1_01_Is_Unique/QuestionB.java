package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_01_Is_Unique;

@SuppressWarnings({"SpellCheckingInspection", "DuplicatedCode"})
public class QuestionB {
  public static void main(String[] args) {
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};
    for (String word : words) {
      System.out.println(word + ": " + isUniqueChars(word));
    }
  }

  public static boolean isUniqueChars(String str) {
    /* Assumes only letters a through z. */
    if (str.length() > 26) { // Only 26 characters
      return false;
    }
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
    }
    return true;
  }
}
