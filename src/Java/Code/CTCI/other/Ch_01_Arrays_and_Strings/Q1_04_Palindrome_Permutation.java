package Java.Code.CTCI.other.Ch_01_Arrays_and_Strings;

@SuppressWarnings("DuplicatedCode")
public class Q1_04_Palindrome_Permutation {
  public static boolean palindromePermutation(String input) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    char[] char_array = input.toCharArray();
    int[] char_count = new int[z - a];
    for (char element : char_array) {
      if (Character.isLetter(element)) {
        int index = Character.getNumericValue(element) - a;
        char_count[index]++;
      }
    }
    boolean foundOdd = false;
    for (int element : char_count) {
      if (element % 2 == 1) {
        if (foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  public static boolean palindromePermutation_solution_1(String phrase) {
    int[] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
  }

  public static int[] buildCharFrequencyTable(String phrase) {
    // Builds an int array to count the instances of a character
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : phrase.toCharArray()) {
      // Gets int value of the charter to add to the array
      int x = getCharNumber(c);
      if (x != -1) {
        // Increments the table at index
        table[x]++;
      }
    }
    return table;
  }

  public static int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    // Determines the numeric offset from 'a' for character number
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  public static boolean checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    // for each element in array check for odd values
    for (int count : table) {
      if (count % 2 == 1) {
        if (foundOdd) {
          // if odd already found, return false
          return false;
        }
        // if odd found set found odd flag
        foundOdd = true;
      }
    }
    return true;
  }

  public static boolean palindromePermutation_solution_3(String phrase) {
    int bitVector = createBitVector(phrase);
    // if 0 or 1 bit is set, return true
    return bitVector == 0 || checkExactlyOneBitSet(bitVector);
  }

  public static int createBitVector(String phrase) {
    /* Create bit vector for string. For each letter with value i,
    toggle the ith bit. */
    int bitVector = 0;
    for (char c : phrase.toCharArray()) {
      int x = getCharNumber(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }

  public static int toggle(int bitVector, int index) {
    // If not in range do nothing
    if (index < 0) return bitVector;
    // Generate mask by using bit offset
    int mask = 1 << index;
    // If nof found set bit
    if ((bitVector & mask) == 0) {
      bitVector |= mask;
    } else {
      // Perform the complement of the mask to zero out the bit
      bitVector &= ~mask;
    }
    return bitVector;
  }

  public static boolean checkExactlyOneBitSet(int bitVector) {
    /* Check that exactly one bit is set by subtracting one from the
    integer and ANDing it with the original integer. */
    // when subtracting 1 from a number with only 1 bit set it would look like this: 1000 - 0001 =
    // 0111  When using  and on this you would get a 0000.  But if 2 bits are set it does not work
    // that way: 1001 - 0001 = 1000.  When using and on this you would get 1000 and that is not 0000
    // so this detects single set bits.
    return (bitVector & (bitVector - 1)) == 0;
  }

  public static boolean palindromePermutation_solution_2(String phrase) {
    int countOdd = 0;
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : phrase.toCharArray()) {
      // Ger character value
      int x = getCharNumber(c);
      if (x != -1) {
        // Increment table at index
        table[x]++;
        // Ass characters are assigned
        if (table[x] % 2 == 1) {
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }
    // If more than 1 odd found, this return false
    return countOdd <= 1;
  }

  public static void main(String[] args) {}
}
