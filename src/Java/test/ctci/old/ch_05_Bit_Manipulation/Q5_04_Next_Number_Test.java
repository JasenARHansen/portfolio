package Java.test.ctci.old.ch_05_Bit_Manipulation;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import Java.code.ctci.source.ch_05_Bit_Manipulation.q5_04_Next_Number.Tester;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"unused", "DuplicatedCode", "NewClassNamingConvention"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_04_Next_Number_Test {
  @Rule public final TestName name = new TestName();

  public static int countZeros(int i) {
    return 32 - countOnes(i);
  }

  public static int countOnes(int i) {
    int count = 0;
    while (i > 0) {
      if ((i & 1) == 1) {
        count++;
      }
      i = i >> 1;
    }
    return count;
  }

  public static void binPrint(int i) {
    System.out.println(i + ": " + Integer.toBinaryString(i));
  }

  @Test
  public void nextNumber() {
    System.out.format("%s:\n", name.getMethodName());
    ArrayList<Integer> values = new ArrayList<>(Arrays.asList(190, 197, 7727, 13948));
    for (Integer value : values) {
      int next = BitShift.getNext(value);
      int previous = BitShift.getPrev(value);
      System.out.format(
          "%s: Initial number is %d with %d as previous and %d as next\n",
          name.getMethodName(), value, previous, next);
    }
  }

  @Test
  public void nextNumber_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
    int i = 13948;
    int p1 = getPrevSlow(i);
    int n1 = getNextSlow(i);
    Tester.binPrint(p1);
    Tester.binPrint(i);
    Tester.binPrint(n1);
    System.out.format(
        "%s: Initial number is %d with %d as previous and %d as next\n",
        name.getMethodName(), i, p1, n1);
  }

  public static int getPrevSlow(int i) {
    if (!hasValidPrev(i)) {
      return -1;
    }
    int num_ones = countOnes(i);
    i--;
    while (countOnes(i) != num_ones) {
      i--;
    }
    return i;
  }

  public static int getNextSlow(int i) {
    if (!hasValidNext(i)) {
      return -1;
    }
    int num_ones = countOnes(i);
    i++;
    while (countOnes(i) != num_ones) {
      i++;
    }
    return i;
  }

  public static boolean hasValidPrev(int i) {
    while ((i & 1) == 1) {
      i >>= 1;
    }
    return i != 0;
  }

  public static boolean hasValidNext(int i) {
    if (i == 0) {
      return false;
    }
    int count = 0;
    while ((i & 1) == 0) {
      i >>= 1;
      count++;
    }
    while ((i & 1) == 1) {
      i >>= 1;
      count++;
    }
    return count != 31;
  }

  @Test
  public void nextNumber_solution_2() {
    System.out.format("%s:\n", name.getMethodName());
    int i = 13948;
    int p1 = getPrev(i);
    int n1 = getNext(i);
    Tester.binPrint(p1);
    Tester.binPrint(i);
    Tester.binPrint(n1);
    System.out.format(
        "%s: Initial number is %d with %d as previous and %d as next\n",
        name.getMethodName(), i, p1, n1);
  }

  public static int getPrev(int n) {
    int temp = n;
    int c0 = 0;
    int c1 = 0;
    while ((temp & 1) == 1) {
      c1++;
      temp >>= 1;
    }
    /* If temp is 0, then the number is a sequence of 0s followed by a sequence of 1s. This is already
    the smallest number with c1 ones. Return -1 for an error. */
    if (temp == 0) {
      return -1;
    }
    while (((temp & 1) == 0) && (temp != 0)) {
      c0++;
      temp >>= 1;
    }
    int p = c0 + c1; // position of right-most non-trailing one (where the right most bit is bit 0)
    /* Flip right-most non-trailing one.
      Example: n = 00011100011.
      c1 = 2
      c0 = 3
      pos = 5
    *
      Build up a mask as follows:
      (1) ~0 will be a sequence of 1s
      (2) shifting left by p + 1 will give you 11.111000000 (six 0s)
      (3) ANDing with n will clear the last 6 bits
      n is now 00011000000. */
    n &= ((~0) << (p + 1)); // clears from bit p onwards (to the right)
    /* Create a sequence of (c1+1) 1s as follows
    (1) Shift 1 to the left (c1+1) times. If c1 is 2, this will give you 0..001000
    (2) Subtract one from that. This will give you 0..00111. */
    int mask = (1 << (c1 + 1)) - 1; // Sequence of (c1+1) ones
    /* Move the ones to be right up next to bit p
    Since this is a sequence of (c1+1) ones, and p = c1 + c0, we just need to
    shift this over by (c0-1) spots.
    If c0 = 3 and c1 = 2, then this will look like 00...0011100
    Then, finally, we OR this with n. */
    n |= mask << (c0 - 1);
    return n;
  }

  public static int getNext(int n) {
    int c = n;
    int c0 = 0;
    int c1 = 0;
    while (((c & 1) == 0) && (c != 0)) {
      c0++;
      c >>= 1;
    }
    while ((c & 1) == 1) {
      c1++;
      c >>= 1;
    }
    /* If c is 0, then n is a sequence of 1s followed by a sequence of 0s. This is already the biggest
    number with c1 ones. Return error. */
    if (c0 + c1 == 31 || c0 + c1 == 0) {
      return -1;
    }
    int pos =
        c0 + c1; // position of right-most non-trailing zero (where the right most bit is bit 0)
    /* Flip the right-most non-trailing zero (which will be at position pos). */
    n |= (1 << pos); // Flip right-most non-trailing zero
    /* Clear all bits to the right of pos.
    Example with pos = 5
    (1) Shift 1 over by 5 to create 0..0100000           [ mask = 1 << pos ]
    (2) Subtract 1 to get 0..0011111                     [ mask = mask - 1 ]
    (3) Flip all the bits by using '~' to get 1..1100000 [ mask = ~mask    ]
    (4) AND with n. */
    n &= -(1 << pos); // Clear all bits to the right of pos
    /* Put (ones-1) 1s on the right by doing the following:
    (1) Shift 1 over by (ones-1) spots. If ones = 3, this gets you 0..0100
    (2) Subtract one from that to get 0..0011
    (3) OR with n. */
    n |= (1 << (c1 - 1)) - 1;
    return n;
  }

  @Test
  public void nextNumber_solution_3() {
    System.out.format("%s:\n", name.getMethodName());
    int i = 13948;
    int p1 = getPrevArithmetic(i);
    int n1 = getNextArithmetic(i);
    Tester.binPrint(p1);
    Tester.binPrint(i);
    Tester.binPrint(n1);
    System.out.format(
        "%s: Initial number is %d with %d as previous and %d as next\n",
        name.getMethodName(), i, p1, n1);
  }

  public static int getPrevArithmetic(int n) {
    int temp = n;
    int c0 = 0;
    int c1 = 0;
    while (((temp & 1) == 1) && (temp != 0)) {
      c1++;
      temp >>= 1;
    }
    /* If temp is 0, then the number is a sequence of 0s followed by a sequence of 1s. This is already
    the smallest number with c1 ones. Return -1 for an error. */
    if (temp == 0) {
      return -1;
    }
    while ((temp & 1) == 0 && (temp != 0)) {
      c0++;
      temp >>= 1;
    }
    /* Arithmetic:
    2^c1 = 1 << c1
    2^(c0 - 1) = 1 << (c0 - 1). */
    return n - (1 << c1) - (1 << (c0 - 1)) + 1;
  }

  public static int getNextArithmetic(int n) {
    int c = n;
    int c0 = 0;
    int c1 = 0;
    while (((c & 1) == 0) && (c != 0)) {
      c0++;
      c >>= 1;
    }
    while ((c & 1) == 1) {
      c1++;
      c >>= 1;
    }
    /* If c is 0, then n is a sequence of 1s followed by a sequence of 0s. This is already the biggest
    number with c1 ones. Return error. */
    if (c0 + c1 == 31 || c0 + c1 == 0) {
      return -1;
    }
    /* Arithmetically:
    2^c0 = 1 << c0
    2^(c1-1) = 1 << (c0 - 1)
    next = n + 2^c0 + 2^(c1-1) - 1; */
    return n + (1 << c0) + (1 << (c1 - 1)) - 1;
  }
}
