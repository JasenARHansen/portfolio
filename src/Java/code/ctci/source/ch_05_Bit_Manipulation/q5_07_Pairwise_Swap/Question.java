package Java.code.ctci.source.ch_05_Bit_Manipulation.q5_07_Pairwise_Swap;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

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
