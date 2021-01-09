package Test.CTCI.Ch_05_Bit_Manipulation;

import CTCI.other.Ch_05_Bit_Manipulation.BitShift;
import CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_07_Pairwise_Swap_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void swapOddEvenBits() {
    System.out.format("%s: \n", name.getMethodName());
    ArrayList<Integer> values =
            new ArrayList<>(Arrays.asList(15, 3003, 9694, 9945, 1775, 512132, -23432));
    for (Integer value : values) {

      int converted = BitShift.swapOddEvenBits(value);
      System.out.format(
              "%s: %d (%s) converts to %d (%s)\n",
              name.getMethodName(),
              value,
              Integer.toBinaryString(value),
              converted,
              Integer.toBinaryString(converted));
    }
  }

  @Test
  public void swapOddEvenBits_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    int a = 234321;
    System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
    int b = swapOddEvenBits(a);
    System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
  }

  public static int swapOddEvenBits(int x) {
    return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
  }


}
