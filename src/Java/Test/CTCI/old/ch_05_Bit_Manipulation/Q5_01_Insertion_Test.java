package Java.test.ctci.old.ch_05_Bit_Manipulation;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_01_Insertion_Test {
  @Rule public final TestName name = new TestName();

  public static int updateBits(int n, int m, int i, int j) {
    // Validation
    if (i > j || i < 0 || j >= 32) {
      return 0;
    }
    /* Create a mask to clear bits i through j in n
    /* EXAMPLE: i = 2, j = 4. Result should be 11100011.
       (Using 8 bits for this example.  This is obviously not actually 8 bits.). */
    int allOnes = ~0; // allOnes = 11111111
    int left = j < 31 ? (allOnes << (j + 1)) : 0; // 1s until position j, then 0s. left = 11100000
    int right = ((1 << i) - 1); // 1s after position i.  right = 00000011
    int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011
    /* Clear i through j, then put m in there. */
    int n_cleared = n & mask; // Clear bits j through i.
    int m_shifted = m << i; // Move m into correct position.
    /* OR them, and we're done! */
    return n_cleared | m_shifted;
  }

  @Test
  public void updateBits() {
    System.out.format("%s:\n", name.getMethodName());
    int base = ~23423;
    int insert = 5;
    int indexStart = 29;
    int indexStop = 31;
    System.out.println(AssortedMethods.toFullBinaryString(base));
    System.out.println(AssortedMethods.toFullBinaryString(insert));
    int result = BitShift.updateBits(base, insert, indexStart, indexStop);
    System.out.println(AssortedMethods.toFullBinaryString(result));
  }

  @Test
  public void updateBits2() {
    System.out.format("%s:\n", name.getMethodName());
    int base = ~23423;
    int insert = 5;
    int indexStart = 28;
    int indexStop = 30;
    System.out.println(AssortedMethods.toFullBinaryString(base));
    System.out.println(AssortedMethods.toFullBinaryString(insert));
    int result = BitShift.updateBits(base, insert, indexStart, indexStop);
    System.out.println(AssortedMethods.toFullBinaryString(result));
  }

  @Test
  public void updateBits_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int a = ~23423;
    System.out.println(AssortedMethods.toFullBinaryString(a));
    int b = 5;
    System.out.println(AssortedMethods.toFullBinaryString(b));
    int c = updateBits(a, b, 29, 31);
    System.out.println(AssortedMethods.toFullBinaryString(c));
  }

  @Test
  public void updateBits_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    int a = ~23423;
    System.out.println(AssortedMethods.toFullBinaryString(a));
    int b = 5;
    System.out.println(AssortedMethods.toFullBinaryString(b));
    int c = updateBits(a, b, 28, 30);
    System.out.println(AssortedMethods.toFullBinaryString(c));
  }
}
