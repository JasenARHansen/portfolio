package CTCI_SOURCE.Ch_16_Moderate;

public class Q16_06_Smallest_Difference_Tester {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        int diffA = Q16_06_Smallest_Difference_QuestionA.findSmallestDifference(array1, array2);
        int diffB = Q16_06_Smallest_Difference_QuestionB.findSmallestDifference(array1, array2);
        System.out.println(diffA);
        System.out.println(diffB);
    }
}
