package Test.Java.CTCI.Ch_05_Bit_Manipulation;

import Java.Code.CTCI.other.Ch_05_Bit_Manipulation.BitShift;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5_08_Draw_Line_Test {

  @Rule
  public TestName name = new TestName();

  @Test
  public void testSwitch() {
    System.out.format("%s: \n", name.getMethodName());
    int height = 4;
    // Width is a byte so if you wanted to know pixel width multiply by 8
    int width = 2;
    int y = 3;
    int startBit = 2;
    int stopBit = 27;
    byte[] screen = new byte[height * width];

    BitShift.drawLine(screen, width, startBit, stopBit, y);
  }

  @Test
  public void drawLine() {
    System.out.format("%s: \n", name.getMethodName());
    int height = 4;
    // Width is a byte so if you wanted to know pixel width multiply by 8
    int width = 2;
    int y = 3;
    int startBit = 2;
    int stopBit = 27;
    byte[] screen = new byte[height * width];

    BitShift.drawLine(screen, width, startBit, stopBit, y);
  }

  @Test
  public void drawLine_solution_1() {
    System.out.format("%s: \n", name.getMethodName());
    int width = 8;
    int height = 1;
    for (int r = 0; r < height; r++) {
      for (int c1 = 0; c1 < width; c1++) {
        for (int c2 = c1; c2 < width; c2++) {
          byte[] screen = new byte[width * height / 8];

          System.out.println("row: " + r + ": " + c1 + " -> " + c2);
          drawLine(screen, width, c1, c2, r);
          printScreen(screen, width);
          System.out.println("\n\n");
        }
      }
    }
  }

  public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
    int start_offset = x1 % 8;
    int first_full_byte = x1 / 8;
    if (start_offset != 0) {
      first_full_byte++;
    }

    int end_offset = x2 % 8;
    int last_full_byte = x2 / 8;
    if (end_offset != 7) {
      last_full_byte--;
    }

    // Set full bytes
    for (int b = first_full_byte; b <= last_full_byte; b++) {
      screen[(width / 8) * y + b] = (byte) 0xFF;
    }

    byte start_mask = (byte) (0xFF >> start_offset);
    byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

    // Set start and end of line
    if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
      byte mask = (byte) (start_mask & end_mask);
      screen[(width / 8) * y + (x1 / 8)] |= mask;
    } else {
      if (start_offset != 0) {
        int byte_number = (width / 8) * y + first_full_byte - 1;
        screen[byte_number] |= start_mask;
      }
      if (end_offset != 7) {
        int byte_number = (width / 8) * y + last_full_byte + 1;
        screen[byte_number] |= end_mask;
      }
    }
  }

  public static void printScreen(byte[] screen, int width) {
    int height = screen.length * 8 / width;
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c += 8) {
        byte b = screen[computeByteNum(width, c, r)];
        printByte(b);
      }
      System.out.println();
    }
  }

  public static int computeByteNum(int width, int x, int y) {
    return (width * y + x) / 8;
  }

  public static void printByte(byte b) {
    for (int i = 7; i >= 0; i--) {
      char c = ((b >> i) & 1) == 1 ? '1' : '_';
      System.out.print(c);
    }
  }
}
