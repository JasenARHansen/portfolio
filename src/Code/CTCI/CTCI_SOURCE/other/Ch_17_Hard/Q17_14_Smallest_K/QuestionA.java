package Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_14_Smallest_K;

import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class QuestionA {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 9, 1, 11, 6, 13, 15};
        int[] smallest = smallestK(array, 3);
        System.out.println(AssortedMethods.arrayToString(smallest));
    }

    public static int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        /* Sort array. */
        Arrays.sort(array);

        /* Copy first k elements. */
        int[] smallest = new int[k];
        System.arraycopy(array, 0, smallest, 0, k);
        return smallest;
    }

}
