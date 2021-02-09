package Code.CTCI_SOURCE.other.Introduction;

public class Ex_10 {
    public static void main(String[] args) {
        int[] arrayA = {0, 1, 2, 3};
        int[] arrayB = {4, 5, 6};
        printUnorderedPairs(arrayA, arrayB);
    }

    public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int j : arrayA) {
            for (int value : arrayB) {
                for (int k = 0; k < 1000; k++) {
                    System.out.println(j + "," + value);
                }
            }
        }
    }
}
