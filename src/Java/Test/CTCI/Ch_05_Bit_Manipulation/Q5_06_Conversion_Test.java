package Java.Test.CTCI.Ch_05_Bit_Manipulation;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Java.Code.CTCI.other.Ch_05_Bit_Manipulation.BitShift;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_06_Conversion_Test {
  @Rule public TestName name = new TestName();

  public static int bitSwapRequired_solution_1(int a, int b) {
    int count = 0;
    int c = a ^ b;
    while (c != 0) {
      count += c & 1; // Increment count if c ends with a 1
      c >>>= 1; // Shift right by 1
    }
    return count;
  }

  public static int bitSwapRequired(int a, int b) {
    int count = 0;
    int c = a ^ b;
    System.out.println("****");
    System.out.println(c + ": " + AssortedMethods.toFullBinaryString(c));
    while (c != 0) {
      System.out.println("c - 1: " + c + ": " + AssortedMethods.toFullBinaryString(c - 1));
      c = c & (c - 1);
      System.out.println("c: " + c + ": " + AssortedMethods.toFullBinaryString(c));
      count++;
      System.out.println("****");
    }
    return count;
  }

  @Test
  public void bitSwapRequired() {
    System.out.format("%s: \n", name.getMethodName());
    int left = 512132;
    ArrayList<Integer> values =
        new ArrayList<>(Arrays.asList(15, 3003, 9694, 9945, 1775, 512132, -23432));
    for (Integer value : values) {
      int conversionCount = BitShift.bitSwapRequired(left, value);
      System.out.format(
          "%s: It takes %d bit flips to convert %d (%s) to %d (%s)\n",
          name.getMethodName(),
          conversionCount,
          left,
          Integer.toBinaryString(left),
          value,
          Integer.toBinaryString(value));
    }
  }

  @Test
  public void bitSwapRequired_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    int a = -23432;
    int b = 512132;
    System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
    System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
    System.out.println("Required number of bits: " + bitSwapRequired_solution_1(a, b));
  }

  @Test
  public void bitSwapRequired_solution_2() {
    System.out.format("%s: \n", name.getMethodName());
    int a = -23432;
    int b = 512132;
    System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
    System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
    System.out.println("Required number of bits: " + bitSwapRequired(a, b));
  }
}
