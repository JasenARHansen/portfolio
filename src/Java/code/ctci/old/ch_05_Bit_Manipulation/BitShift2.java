package Java.code.ctci.old.ch_05_Bit_Manipulation;

@SuppressWarnings("DuplicatedCode")
public class BitShift2 {

    public static String convertBinaryLessThanOne1(double num) {
        if (num >= 1 || num <= 0) {
            return "Error";
        }
        StringBuilder binary = new StringBuilder("0");
        binary.append(".");
        while (num > 0) {
            /* Setting a limit on length: 32 characters. */
            if (binary.length() > 32) {
                return "Error";
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static String convertBinaryLessThanOne2(double num) {
        if (num >= 1 || num <= 0) {
            return "Error";
        }
        StringBuilder binary = new StringBuilder("0");
        double frac = 0.5;
        binary.append(".");
        while (num > 0) {
            /* Setting a limit on length: 32 characters. */
            if (binary.length() >= 32) {
                return "Error";
            }
            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }
            frac /= 2;
        }
        return binary.toString();
    }

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
}
