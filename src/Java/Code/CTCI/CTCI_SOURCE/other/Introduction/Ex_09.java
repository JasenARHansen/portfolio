package Java.Code.CTCI.CTCI_SOURCE.other.Introduction;

public class Ex_09 {
    public static void main(String[] args) {
        int[] arrayA = {0, 1, 2, 3};
        int[] arrayB = {4, 5, 6};
        printUnorderedPairs(arrayA, arrayB);
    }

    public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int j : arrayA) {
            for (int k : arrayB) {
                if (j < k) {
                    System.out.println(j + "," + k);
                }
            }
        }
    }
}
