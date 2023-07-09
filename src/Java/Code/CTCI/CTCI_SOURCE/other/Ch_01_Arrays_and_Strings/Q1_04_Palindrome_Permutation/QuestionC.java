package Java.Code.CTCI.CTCI_SOURCE.other.Ch_01_Arrays_and_Strings.Q1_04_Palindrome_Permutation;

public class QuestionC {
  public static void main(String[] args) {
    String pali = "Rats live on no evil star";
    System.out.println(isPermutationOfPalindrome(pali));
  }

  public static boolean isPermutationOfPalindrome(String phrase) {
    int bitVector = createBitVector(phrase);
    return checkAtMostOneBitSet(bitVector);
  }

  public static int createBitVector(String phrase) {
    /* Create bit vector for string. For each letter with value i,
    toggle the ith bit. */
    int bitVector = 0;
    for (char c : phrase.toCharArray()) {
      int x = Common.getCharNumber(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  public static int toggle(int bitVector, int index) {
    /* Toggle the ith bit in the integer. */
    if (index < 0) return bitVector;
    int mask = 1 << index;
    if ((bitVector & mask) == 0) {
      bitVector |= mask;
    } else {
      bitVector &= ~mask;
    }
    return bitVector;
  }

  public static boolean checkAtMostOneBitSet(int bitVector) {
    /* Check that at most one bit is set by subtracting one from the
    integer and ANDing it with the original integer. */
    return (bitVector & (bitVector - 1)) == 0;
  }
}
