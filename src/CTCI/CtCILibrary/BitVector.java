package CTCI.CtCILibrary;

public class BitVector {
    private static final int DATA_SIZE = 32;
    private final int length;
    private final int[] vector;

    public BitVector(int length) {
        this.length = length;
        if (length % DATA_SIZE == 0) {
            vector = new int[length / DATA_SIZE];
        } else {
            vector = new int[length / DATA_SIZE + 1];
        }
    }

    public int length() {
        return length;
    }

    public boolean get(int i) {
        int b = vector[i / DATA_SIZE];
        int bit_index = i % DATA_SIZE;

        return ((b >> bit_index) & 1) == 1;
    }

    public void print() {
        for (int k : vector) {
            for (int i = 0; i < DATA_SIZE; i++) {
                if ((k >> i & 1) == 1) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    public void set(int i, boolean flag) {
        if (i >= 0 && i < length) {
            int mask = ~(1 << i);
            int b = vector[i / DATA_SIZE] & mask;
            if (flag) {
                vector[i / DATA_SIZE] = b | (1 << i);
            } else {
                vector[i / DATA_SIZE] = b;
            }
        }
    }
}
