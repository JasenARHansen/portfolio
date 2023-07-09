package Java.Code.CTCI.other.Ch_01_Arrays_and_Strings;

import java.util.HashSet;

@SuppressWarnings("DuplicatedCode")
public class Q1_01_Is_Unique {
  public static boolean isUnique(String input) {
    HashSet<Character> hash_set = new HashSet<>();
    char[] data = input.toCharArray();
    for (char element : data) {
      if (!hash_set.add(element)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isUnique_solution_1(String str) {
    // This assumes the ASCII character set of 128 characters
    if (str.length() > 128) {
      return false;
    }
    // This creates a boolean array with 1 space per character
    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      // Gets teh ASCII value of the character at the selected index
      int val = str.charAt(i);
      // Checks to see if the array is set at the given index.  If it is set the character has been
      // seen before.
      if (char_set[val]) {
        return false;
      }
      // If the character has not been seen the index is set
      char_set[val] = true;
    }
    return true;
  }

  public static boolean isUnique_solution_2(String str) {
    // This assumes a reduced set of  the ASCII characters representing the lower case letters.
    if (str.length() > 26) { // Only 26 characters
      return false;
    }
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      // This finds the ASCII offset from the 'a' character
      int val = str.charAt(i) - 'a';
      // This shifts the number 1 by the ASCII offset.  A bitwise AND us done with this new number.
      // This is  acting like the boolean array above.  If the result of the AND is not 0 than the
      // character  has been seen.
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      // If the character has not been seen a bitwise OR is done to mark the bit with the selected
      // offset.
      checker |= (1 << val);
    }
    return true;
  }

  public static void main(String[] args) {}
}
