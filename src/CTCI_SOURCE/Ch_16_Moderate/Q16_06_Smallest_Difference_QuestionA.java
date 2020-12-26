package CTCI_SOURCE.Ch_16_Moderate;

public class Q16_06_Smallest_Difference_QuestionA {
    public static int findSmallestDifference(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int j : array1) {
            for (int k : array2) {
                if (Math.abs(j - k) < min) {
                    min = Math.abs(j - k);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        int difference = findSmallestDifference(array1, array2);
        System.out.println(difference);
    }

}
