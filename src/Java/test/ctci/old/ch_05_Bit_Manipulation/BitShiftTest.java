package Java.test.ctci.old.ch_05_Bit_Manipulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.old.ch_05_Bit_Manipulation.BitShift;
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
    System.out.format("%s:\n", name.getMethodName());
    BitShift bitShift = new BitShift();
    assertNotNull(bitShift);
  }

  @Test
  public void updateBits() {
    System.out.format("%s:\n", name.getMethodName());
    int base = ~23423;
    int insert = 5;
    int indexStart = 28;
    int indexStop = 30;
    int result = BitShift.updateBits(base, insert, indexStart, indexStop);
    System.out.format(
        "\tbase %d insert %d start index %d stop index %d results with %d\n",
        base, insert, indexStart, indexStop, result);
  }

  @Test
  public void convertBinaryLessThanOne() {
    String[] expected = {"0.001", "Error", "0.01", "0.1", "0.11"};
    System.out.format("%s:\n", name.getMethodName());
    double[] values = {.125, 0.1, 0.25, 0.5, 0.75};
    for (int i = 0; i < values.length; i++) {
      String result = BitShift.convertBinaryLessThanOne(values[i]);
      assertEquals(expected[i], result);
      System.out.format("\t%.3f converted to binary is %s\n", values[i], result);
    }
  }

  @Test
  public void longestSequence() {
    int[] expected = {5, 7, 8, 5, 8};
    System.out.format("%s:\n", name.getMethodName());
    int[] values = {15, 3003, 9694, 9945, 1775};
    for (int i = 0; i < values.length; i++) {
      int result = BitShift.longestSequence(values[i]);
      assertEquals(expected[i], result);
      System.out.format(
          "\tThe largest bit sequence in %s allowing a single bit skip %d\n",
          Integer.toBinaryString(values[i]), result);
    }
  }

  @Test
  public void getNext() {
    int[] expected = {207, 198, 7735, 13967};
    System.out.format("%s:\n", name.getMethodName());
    int[] values = {190, 197, 7727, 13948};
    for (int i = 0; i < values.length; i++) {
      int result = BitShift.getNext(values[i]);
      assertEquals(expected[i], result);
      System.out.format("\tInitial number is %d with %d as next\n", values[i], result);
    }
  }

  @Test
  public void getPrev() {
    int[] expected = {189, 195, 7711, 13946};
    System.out.format("%s:\n", name.getMethodName());
    int[] values = {190, 197, 7727, 13948};
    for (int i = 0; i < values.length; i++) {
      int result = BitShift.getPrev(values[i]);
      assertEquals(expected[i], result);
      System.out.format("\tInitial number is %d with %d as previous\n", values[i], result);
    }
  }

  @Test
  public void bitSwapRequired() {
    int[] expected = {10, 15, 13, 14, 13, 0, 23};
    System.out.format("%s:\n", name.getMethodName());
    int left = 512132;
    int[] data = {15, 3003, 9694, 9945, 1775, 512132, -23432};
    int index = 1;
    for (int i = 0; i < data.length; i++) {
      int result = BitShift.bitSwapRequired(left, data[i]);
      assertEquals(expected[i], result);
      System.out.format(
          "\t%d: It takes %d bit flips to convert %d (%s) to %d (%s)\n",
          index++,
          result,
          left,
          Integer.toBinaryString(left),
          data[i],
          Integer.toBinaryString(data[i]));
    }
  }

  @Test
  public void swapOddEvenBits() {
    int[] expected = {15, 1911, 6893, 6630, 2527, 778312, -42828};
    System.out.format("%s:\n", name.getMethodName());
    int[] values = {15, 3003, 9694, 9945, 1775, 512132, -23432};
    for (int i = 0; i < values.length; i++) {
      int result = BitShift.swapOddEvenBits(values[i]);
      assertEquals(expected[i], result);
      System.out.format(
          "\t%d (%s) converts to %d (%s)\n",
          values[i], Integer.toBinaryString(values[i]), result, Integer.toBinaryString(result));
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
