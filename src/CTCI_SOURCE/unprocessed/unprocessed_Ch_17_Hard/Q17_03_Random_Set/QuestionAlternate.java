package CTCI_SOURCE.unprocessed.unprocessed_Ch_17_Hard.Q17_03_Random_Set;

import CTCI.CtCILibrary.AssortedMethods;

public class QuestionAlternate {

    /* Random number between lower and higher, inclusive */
    public static int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

    /* pick M elements from original array, using only elements 0 through i (inclusive).*/
    public static int[] pickMRecursively(int[] original, int m, int i) {
        if (i + 1 < m) { // Not enough elements
            return null;
        } else if (i + 1 == m) { // Base case -- copy first m elements into array
            int[] set = new int[m];
            if (m >= 0) System.arraycopy(original, 0, set, 0, m);
            return set;
        } else {
            int[] set = pickMRecursively(original, m, i - 1);
            int k = rand(0, i);
            if (k < m) {
                set[k] = original[i];
            }
            return set;
        }
    }

    /* pick M elements from original array.*/
    public static int[] pickMIteratively(int[] original, int m) {
        int[] subset = new int[m];

        /* Fill in subset array with first part of original array */
        if (m >= 0) System.arraycopy(original, 0, subset, 0, m);

        /* Go through rest of original array. */
        for (int i = m; i < original.length; i++) {
            int k = rand(0, i);
            if (k < m) {
                subset[k] = original[i];
            }
        }

        return subset;
    }

    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(AssortedMethods.arrayToString(cards));
        int[] set = pickMIteratively(cards, 4);
        System.out.println(AssortedMethods.arrayToString(set));
    }

}
