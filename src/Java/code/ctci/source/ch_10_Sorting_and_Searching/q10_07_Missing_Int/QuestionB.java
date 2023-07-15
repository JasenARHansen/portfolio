package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_07_Missing_Int;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuestionB {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "Ch 10. Scalability and Memory Limits/Q10_04_Missing_Int/input.txt";
        int max = 10000000;
        int missing = 1234325;
        System.out.println("Generating file...");
        generateFile(filename, max, missing);
        System.out.println("Generated file from 0 to " + max + " with " + missing + " missing.");
        System.out.println("Searching for missing number...");
        System.out.println("Missing value: " + findOpenNumber(filename));
    }

    public static void generateFile(String filename, int max, int missing)
            throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        for (int i = 0; i < max && i >= 0; i++) {
            if (i != missing) {
                writer.println(i);
            }
            if (i % 10000 == 0) {
                System.out.println("Now at location: " + i);
            }
        }
        writer.flush();
        writer.close();
    }

    public static int findOpenNumber(String filename) throws FileNotFoundException {
        int rangeSize = (1 << 20); // 2^20 bits (2^17 bytes)
        /* Get count of number of values within each block. */
        int[] blocks = getCountPerBlock(filename, rangeSize);
        /* Find a block with a missing value. */
        int blockIndex = findBlockWithMissing(blocks, rangeSize);
        if (blockIndex < 0) return -1;
        /* Create bit vector for items within this range. */
        byte[] bitVector = getBitVectorForRange(filename, blockIndex, rangeSize);
        /* Find a zero in the bit vector. */
        int offset = findZero(bitVector);
        if (offset < 0) return -1;
        /* Compute missing value. */
        return blockIndex * rangeSize + offset;
    }

    public static int[] getCountPerBlock(String filename, int rangeSize)
            throws FileNotFoundException {
        /* Get count of items within each range. */
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] blocks = new int[arraySize];
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            blocks[value / rangeSize]++;
        }
        in.close();
        return blocks;
    }

    public static int findBlockWithMissing(int[] blocks, int rangeSize) {
        for (int i = 0; i < blocks.length; i++) {
            /* Find a block whose count is low. */
            if (blocks[i] < rangeSize) {
                return i;
            }
        }
        return -1;
    }

    public static byte[] getBitVectorForRange(String filename, int blockIndex, int rangeSize)
            throws FileNotFoundException {
        /* Create a bit vector for the values within a specific range. */
        int startRange = blockIndex * rangeSize;
        int endRange = startRange + rangeSize;
        byte[] bitVector = new byte[rangeSize / Byte.SIZE];
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
      /* If the number is inside the block that's missing
      numbers, we record it. */
            if (startRange <= value && value < endRange) {
                int offset = value - startRange;
                int mask = (1 << (offset % Byte.SIZE));
                bitVector[offset / Byte.SIZE] |= mask;
            }
        }
        in.close();
        return bitVector;
    }

    public static int findZero(byte[] bitVector) {
        /* Find a zero within the bit vector and return the index. */
        for (int i = 0; i < bitVector.length; i++) {
            if (bitVector[i] != ~0) { // If not all 1s
                int bitIndex = findZero(bitVector[i]);
                return i * Byte.SIZE + bitIndex;
            }
        }
        return -1;
    }

    public static int findZero(byte b) {
        /* Find bit index that is 0 within byte. */
        for (int i = 0; i < Byte.SIZE; i++) {
            int mask = 1 << i;
            if ((b & mask) == 0) {
                return i;
            }
        }
        return -1;
    }
}
