package CTCI.other.Ch_05_Bit_Manipulation;

public class BitShift {

  public static int SEQUENCE_LENGTH = 32;

  public BitShift() {
  }

  public static int updateBits(int base, int insert, int indexStart, int indexStop) {
    // Validation
    // This is a 32 bit number so indexStop must be <= 32
    // This is array referencing numbers so the start index must be >= 0
    // The stop index must be greater than the start index
    if ((indexStart < 0) || (indexStop >= SEQUENCE_LENGTH) || (indexStart > indexStop)) {
      return 0;
    }
    // The insert number must fit in the range
    int lengthTest = insert;
    while (lengthTest > 0) {
      lengthTest = lengthTest >> 1;
    }
    //noinspection ConstantConditions
    if ((indexStop - indexStart + 1) < lengthTest) {
      return 0;
    }
    // zero out the bits that will be replaced

    int allOnes =
            ~0; // Taking advantage of the "~x equals (-x)-1" but I could have used -1 as well.
    //  But -1 would require signed ints to work
    // Build left mask
    int leftMask =
            indexStop < 31
                    ? (allOnes << (indexStop + 1))
                    : 0; // This is needed because the arithmetic shift
    // preserves the sign bit
    // build right mask
    int rightMask =
            allOnes
                    >>> (SEQUENCE_LENGTH
                    - indexStart); // Using the logical shift to get rid of the sign bit
    // Or the 2 to make the full mask
    int fullMask = leftMask | rightMask;
    // Clear the bits with an AND using the mask
    base = base & fullMask;
    // insert new bits
    int insertShifted = insert << indexStart;
    return base | insertShifted;
  }

  public static String convertBinaryLessThanOne(double input) {
    StringBuilder returnBinary = new StringBuilder();
    returnBinary.append("0.");
    int count = 0;
    while ((input > 0) && (input < 1) && (count++ < SEQUENCE_LENGTH)) {
      input *= 2;
      if (input >= 1) {
        input -= 1;
        returnBinary.append("1");
      } else {
        returnBinary.append("0");
      }
    }
    if (count >= SEQUENCE_LENGTH) {
      return "Error";
    }
    return returnBinary.toString();
  }

  public static int longestSequence(int input) {
    int mask = 1;
    int currentMax = 0;
    int countLeft = 0;
    int countRight = 0;
    int padValue = 0;
    int zeroCount = 0;

    for (int i = 0; i < SEQUENCE_LENGTH; i++) {
      // First, apply mask
      int bit = mask & input;
      if (bit > 0) {
        countRight++;
        zeroCount = 0;
      } else {
        zeroCount++;
        padValue = 1;
      }

      if (currentMax < (countLeft + countRight + padValue)) {
        currentMax = countLeft + countRight + padValue;
      }

      if (zeroCount > 0) {
        countLeft = countRight;
        countRight = 0;
      }

      mask = mask << 1;
    }

    return currentMax;
  }

  public static int getNext(int input) {
    // Find the rightmost non training zero.
    int mask = 1;
    int count = 0;
    while ((mask & input) == 0) {
      mask = mask << 1;
    }
    while ((mask & input) != 0) {
      mask = mask << 1;
      count++;
    }
    // Add the new leading 1
    input = input | mask;
    // Trim the last digits so I can add new 1's
    mask = mask - 1;
    mask = ~mask;
    input = input & mask;
    // Make new mask of 1's to add
    mask = 1;
    mask = mask << (count - 1);
    mask = mask - 1;
    return input | mask;
  }

  public static int getPrev(int input) {
    // Find the rightmost non training zero.
    int mask = 1;
    int count = 1;
    int index = 0;
    while ((mask & input) != 0) {
      mask = mask << 1;
      count++;
      index++;
    }
    while ((mask & input) == 0) {
      mask = mask << 1;
      index++;
    }
    // Add 1 more digit to the mask to trim the leading 1
    mask = mask << 1;
    // Trim the last digits so I can add new 1's
    mask = mask - 1;
    mask = ~mask;
    input = input & mask;
    // Rebuild the 1's string with trailing zeros
    mask = 1;
    mask = mask << (count);
    mask = mask - 1;
    // Append the the 0's string with trailing zeros
    mask = mask << (index - count);

    return input | mask;
  }

  public static int bitSwapRequired(int left, int right) {
    int xor = left ^ right;
    int count = 0;
    int mask = 1;

    while (xor != 0) {
      // First, apply mask
      int bit = mask & xor;
      xor >>>= 1;
      if (bit > 0) {
        count++;
      }
    }

    return count;
  }

  public static int swapOddEvenBits(int input) {
    // a = 1010  5 = 0101
    // a -> 1 spot and 5 <- spot
    int leftMask = 0xaaaaaaaa;
    int left = leftMask & input;
    left >>>= 1;

    int rightMask = 0x55555555;
    int right = rightMask & input;
    right <<= 1;
    return left | right;
  }

  public static void drawLine(byte[] screen, int width, int start, int stop, int y) {
    // Print a line segment on a NxM screen where M = width and N is defined as the length of screen
    // divided by width
    // Start and Stop are bit references so they are there are 8 bites to a byte.  Keep in mind the
    // scaling difference when determining indexes to alter.
    int height = screen.length / width;
    // Verify that the line is actually on the screen
    if (y > height) {
      return;
    }
    // Test to make sure line segment is in line.
    if ((start < 0) || (start >= (8 * width))) {
      return;
    }
    // we want to make the line segment to be represented by 1's so we need a left and a right mask.
    // A line can start in 1 byte and end in a different byte.  Any whole number between startByte
    // and stopByte is full.
    int startByte = start / 8;
    // startByteIndex is how far into the first byte printing starts
    int startByteIndex = start % 8;

    // Handle the left side
    int stopByte = stop / 8;
    // stopByteIndex is how far into the last byte printing stops
    int stopByteIndex = stop % 8;

    // Set left byte
    byte leftMask = (byte) (0xFF >> startByteIndex);
    byte rightMask = (byte) ((0xFF << stopByteIndex) & 0xFF);

    if (startByte == stopByte) {
      screen[startByte] = (byte) (leftMask & rightMask);
    } else {
      // set left byte
      screen[startByte] = leftMask;
      // Set full bytes
      for (int index = startByte + 1; index < stopByte; index++) {
        screen[index] = (byte) 0xFF;
      }
      // Set right byte
      screen[stopByte] = rightMask;
    }

    // Print the screen
    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        int index = row * width + column;
        for (int i = 7; i >= 0; i--) {
          // This line is not my code but I am not going to bother reimplementing.
          char c = ((screen[index] >> i) & 1) == 1 ? '1' : '_';
          System.out.print(c);
        }
        System.out.println();
      }
    }
  }
}
