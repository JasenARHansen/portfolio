package Java.test.ctci.old.ch_05_Bit_Manipulation;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_03_Flip_Bit_to_Win_Test {
  public static final int SEQUENCE_LENGTH = 32;
  @Rule public final TestName name = new TestName();

  public static int longestSequence_solution_1(int n) {
    int maxSeq = 0;
    for (int i = 0; i < SEQUENCE_LENGTH; i++) {
      maxSeq = Math.max(maxSeq, longestSequenceOf1s(n, i));
    }
    return maxSeq;
  }

  public static int longestSequenceOf1s(int n, int indexToIgnore) {
    int max = 0;
    int counter = 0;
    for (int i = 0; i < SEQUENCE_LENGTH; i++) {
      if (i == indexToIgnore || getBit(n, i)) {
        counter++;
        max = Math.max(counter, max);
      } else {
        counter = 0;
      }
    }
    return max;
  }

  public static boolean getBit(int num, int i) {
    return ((num & (1 << i)) != 0);
  }

  public static int longestSequence_solution_2(int n) {
    if (n == -1) return Integer.BYTES * 8;
    ArrayList<Integer> sequences = getAlternatingSequences(n);
    return findLongestSequence(sequences);
  }

  public static ArrayList<Integer> getAlternatingSequences(int n) {
    /* Return a list of the sizes of the sequences. The sequence starts
    off with the number of 0s (which might be 0) and then alternates
    with the counts of each value. */
    ArrayList<Integer> sequences = new ArrayList<>();
    int searchingFor = 0;
    int counter = 0;
    for (int i = 0; i < Integer.BYTES * 8; i++) {
      if ((n & 1) != searchingFor) {
        sequences.add(counter);
        searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
        counter = 0;
      }
      counter++;
      n >>>= 1;
    }
    sequences.add(counter);
    return sequences;
  }

  public static int findLongestSequence(ArrayList<Integer> seq) {
    int maxSeq = 1;
    for (int i = 0; i < seq.size(); i += 2) {
      int zerosSeq = seq.get(i);
      int onesSeqPrev = i - 1 >= 0 ? seq.get(i - 1) : 0;
      int onesSeqNext = i + 1 < seq.size() ? seq.get(i + 1) : 0;
      int thisSeq = 0;
      if (zerosSeq == 1) { // Can merge
        thisSeq = onesSeqNext + 1 + onesSeqPrev;
      } else if (zerosSeq > 1) { // Just add a one to either side
        thisSeq = 1 + Math.max(onesSeqPrev, onesSeqNext);
      } else if (zerosSeq == 0) { // No zero, but take either side
        thisSeq = Math.max(onesSeqPrev, onesSeqNext);
      }
      maxSeq = Math.max(thisSeq, maxSeq);
    }
    return maxSeq;
  }

  public static int longestSequence_solution_3(int n) {
    int searchingFor = 0;
    int[] sequences = {0, 0, 0}; // Counts of last 3 sequences
    int maxSequence = 1;
    for (int i = 0; i < SEQUENCE_LENGTH; i++) {
      if ((n & 1) != searchingFor) {
        if (searchingFor == 1) { // End of 1s + 0s + 1s sequence
          maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
        }
        searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
        shift(sequences); // Shift sequences
      }
      sequences[0]++;
      n >>>= 1;
    }
    /* Check final set of sequences. */
    if (searchingFor == 0) {
      shift(sequences);
    }
    int finalSequence = getMaxSequence(sequences);
    maxSequence = Math.max(finalSequence, maxSequence);
    return maxSequence;
  }

  public static int getMaxSequence(int[] sequences) {
    /* Given set of three sequences ordered as {0s, then 1s, then 0s},
    find max sequence that can be formed. */
    /* 1s, then 0s, then [old] ones. */
    if (sequences[1] == 1) { // a single 0 -> merge sequences
      return sequences[0] + sequences[2] + 1;
    } else if (sequences[1] == 0) { // no 0s -> take one side
      return Math.max(sequences[0], sequences[2]);
    } else { // many 0s -> take side, add 1 (flip a bit)
      return Math.max(sequences[0], sequences[2]) + 1;
    }
  }

  public static void shift(int[] sequences) {
    sequences[2] = sequences[1];
    sequences[1] = sequences[0];
    sequences[0] = 0;
  }

  public static int flipBit(int a) {
    /* If all 1s, this is already the longest sequence. */
    if (~a == 0) return Integer.BYTES * 8;
    int currentLength = 0;
    int previousLength = 0;
    int maxLength = 1; // We can always have a sequence of at least one 1
    while (a != 0) {
      if ((a & 1) == 1) {
        currentLength++;
      } else if ((a & 1) == 0) {
        /* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
        previousLength = (a & 2) == 0 ? 0 : currentLength;
        currentLength = 0;
      }
      maxLength = Math.max(previousLength + currentLength + 1, maxLength);
      a >>>= 1;
    }
    return maxLength;
  }

  @Test
  public void longestSequence() {
    System.out.format("%s:\n", name.getMethodName());
    ArrayList<Integer> values = new ArrayList<>(Arrays.asList(15, 3003, 9694, 9945, 1775));
    for (Integer value : values) {
      int result = BitShift.longestSequence(value);
      System.out.format(
          "%s: The largest bit sequence in %s allowing a single bit skip %d\n",
          name.getMethodName(), Integer.toBinaryString(value), result);
    }
  }

  @Test
  public void longestSequence_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int original_number = Integer.MAX_VALUE;
    int new_number = longestSequence_solution_1(original_number);
    System.out.println(Integer.toBinaryString(original_number));
    System.out.println(new_number);
  }

  @Test
  public void longestSequence_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    int original_number = 1775;
    int new_number = longestSequence_solution_2(original_number);
    System.out.println(Integer.toBinaryString(original_number));
    System.out.println(new_number);
  }

  @Test
  public void longestSequence_solution_3() {
    System.out.format("%s:\n", name.getMethodName());
    int original_number = Integer.MAX_VALUE;
    int new_number = longestSequence_solution_3(original_number);
    System.out.println(Integer.toBinaryString(original_number));
    System.out.println(new_number);
  }

  @Test
  public void longestSequence_solution_4() {
    System.out.format("%s:\n", name.getMethodName());
    int[][] cases = {
      {-1, 32}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1}, {1, 2}, {15, 5}, {1775, 8}
    };
    for (int[] c : cases) {
      int x = flipBit(c[0]);
      boolean r = (c[1] == x);
      System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
    }
  }
}
