package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_02_Check_Permutation;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
public class QuestionA {
  public static void main(String[] args) {
    String[][] pairs = {{"apple", "cat"}, {"carrot", "fish"}, {"hello", "llloh"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      boolean anagram = permutation(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + anagram);
    }
  }

  public static boolean permutation(String s, String t) {
    return sort(s).equals(sort(t));
  }

  public static String sort(String s) {
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
  }
}
