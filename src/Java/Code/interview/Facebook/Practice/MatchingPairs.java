package Java.code.interview.Facebook.practice;

@SuppressWarnings("SpellCheckingInspection")
public class MatchingPairs {
  public static void getDescription() {
    System.out.println(
        """
                Matching Pairs
                Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
                A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
                Note: This means you must swap two characters at different indices.
                Signature
                 int matchingPairs(String s, String t)
                Input
                 s and t are strings of length N
                 N is between 2 and 1,000,000
                Output
                Return an integer denoting the maximum number of matching pairs
                Example 1
                 s = "abcd"
                 t = "adcb"
                 output = 4
                Explanation:
                Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
                Therefore, the number of matching pairs of s and t will be 4.
                Example 2
                 s = "mno"
                 t = "mno"
                 output = 1
                Explanation:
                Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.
                """
            .indent(2));
  }

  public static int matchingPairs(String s, String t) {
    int characters = 0;
    char[] longer;
    char[] shorter;
    // Strings may be different length so this will make sure swaps happen on the longer string
    if (s.length() > t.length()) {
      longer = s.toCharArray();
      shorter = t.toCharArray();
    } else {
      longer = t.toCharArray();
      shorter = s.toCharArray();
    }
    char swap;
    int count;
    for (int indexOuter = 0; indexOuter < longer.length; indexOuter++) {
      for (int indexInner = indexOuter + 1; indexInner < longer.length; indexInner++) {
        swap = longer[indexOuter];
        longer[indexOuter] = longer[indexInner];
        longer[indexInner] = swap;
        count = countMatching(shorter, longer);
        if (count > characters) {
          characters = count;
        }
        // restoration is cheaper than recursion
        swap = longer[indexOuter];
        longer[indexOuter] = longer[indexInner];
        longer[indexInner] = swap;
      }
    }
    return characters;
  }

  public static int countMatching(char[] left, char[] right) {
    int count = 0;
    // Strings may be different length so this will prevent out of bounds errors
    for (int index = 0; index < Math.min(left.length, right.length); index++) {
      if (left[index] == right[index]) {
        count++;
      }
    }
    return count;
  }
}
