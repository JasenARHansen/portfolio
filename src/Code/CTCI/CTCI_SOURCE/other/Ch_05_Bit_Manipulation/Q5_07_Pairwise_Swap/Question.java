package Code.CTCI.CTCI_SOURCE.other.Ch_05_Bit_Manipulation.Q5_07_Pairwise_Swap;

import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class Question {

    public static void main(String[] args) {
        int a = 234321;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        int b = swapOddEvenBits(a);
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
    }

    public static int swapOddEvenBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }
}
