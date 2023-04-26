package Java.Code.CTCI.CTCI_SOURCE.other.Ch_10_Sorting_and_Searching.Q10_01_Sorted_Merge;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class Question {


    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }

    /**
     * Merges array
     *
     * @param a      first array
     * @param b      second array
     * @param countA number of "real" elements in a
     * @param countB number of "real" elements in b
     */
    public static void merge(int[] a, int[] b, int countA, int countB) {
        int indexMerged = countB + countA - 1; /* Index of last location of merged array */
        int indexA = countA - 1; /* Index of last element in array b */
        int indexB = countB - 1; /* Index of last element in array a */

        /* Merge a and b, starting from the last element in each */
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of A is bigger than end of B */
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }

}
