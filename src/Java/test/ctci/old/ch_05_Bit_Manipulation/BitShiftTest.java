package Java.test.ctci.old.ch_05_Bit_Manipulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"InstantiationOfUtilityClass", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BitShiftTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void BitShift() {
    BitShift bitShift = new BitShift();
    assertNotNull(bitShift);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void updateBits() {
    int base = ~23423;
    int insert = 5;
    int indexStart = 28;
    int indexStop = 30;
    int result = BitShift.updateBits(base, insert, indexStart, indexStop);
    System.out.format(
        "%s: base %d insert %d start index %d stop index %d results with %d\n",
        name.getMethodName(), base, insert, indexStart, indexStop, result);
  }

  @Test
  public void convertBinaryLessThanOne() {
    ArrayList<Double> values = new ArrayList<>(Arrays.asList(0.5, 0.1, 0.25, 0.75));
    System.out.format("%s:\n", name.getMethodName());
    int index = 1;
    for (Double value : values) {
      String result = BitShift.convertBinaryLessThanOne(value);
      System.out.format("\t%d: %f converted to binary is %s\n", index++, value, result);
    }
  }

  @Test
  public void longestSequence() {
    int base = 28;
    int result = BitShift.longestSequence(base);
    assertEquals(4, result);
    System.out.format("%s: base %d longestSequence %d\n", name.getMethodName(), base, result);
  }

  @Test
  public void getNext() {
    int base = 28;
    int result = BitShift.getNext(base);
    assertEquals(35, result);
    System.out.format("%s: base %d getNext %d\n", name.getMethodName(), base, result);
  }

  @Test
  public void getPrev() {
    int base = 28;
    int result = BitShift.getPrev(base);
    assertEquals(26, result);
    System.out.format("%s: base %d getNext %d\n", name.getMethodName(), base, result);
  }

  @Test
  public void bitSwapRequired() {
    System.out.format("%s:\n", name.getMethodName());
    int left = 512132;
    ArrayList<Integer> values =
        new ArrayList<>(Arrays.asList(15, 3003, 9694, 9945, 1775, 512132, -23432));
    int index = 1;
    for (Integer value : values) {
      int conversionCount = BitShift.bitSwapRequired(left, value);
      System.out.format(
          "\t%d: It takes %d bit flips to convert %d (%s) to %d (%s)\n",
          index++,
          conversionCount,
          left,
          Integer.toBinaryString(left),
          value,
          Integer.toBinaryString(value));
    }
  }

  @Test
  public void swapOddEvenBits() {
    System.out.format("%s:\n", name.getMethodName());
    ArrayList<Integer> values =
        new ArrayList<>(Arrays.asList(15, 3003, 9694, 9945, 1775, 512132, -23432));
    int index = 1;
    for (Integer value : values) {
      int converted = BitShift.swapOddEvenBits(value);
      System.out.format(
          "\t%d: %d (%s) converts to %d (%s)\n",
          index++,
          value,
          Integer.toBinaryString(value),
          converted,
          Integer.toBinaryString(converted));
    }
  }

  @Test
  public void drawLine() {
    System.out.format("%s:\n", name.getMethodName());
    int height = 4;
    // Width is a byte so if you wanted to know pixel width multiply by 8
    int width = 2;
    int y = 3;
    int startBit = 2;
    int stopBit = 27;
    byte[] screen = new byte[height * width];
    BitShift.drawLine(screen, width, startBit, stopBit, y);
  }
}
