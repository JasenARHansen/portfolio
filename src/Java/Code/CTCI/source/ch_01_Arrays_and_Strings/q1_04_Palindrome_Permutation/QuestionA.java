package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_04_Palindrome_Permutation;

@SuppressWarnings("SpellCheckingInspection")
public class QuestionA {
  public static void main(String[] args) {
    String pali = "Rats live on no evil star";
    System.out.println(isPermutationOfPalindrome(pali));
  }

  public static boolean isPermutationOfPalindrome(String phrase) {
    int[] table = Common.buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
  }

  public static boolean checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    for (int count : table) {
      if (count % 2 == 1) {
        if (foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }
}
