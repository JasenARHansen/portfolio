package Code.Java.CTCI.CTCI_SOURCE.other.Ch_10_Sorting_and_Searching.Introduction;

import Code.Java.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class MergeSort {
    public static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(array, helper, low, middle); // Sort left half
            mergesort(array, helper, middle + 1, high); // Sort right half
            merge(array, helper, low, middle, high); // Merge them
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /* Copy both halves into a helper array */
        if (high + 1 - low >= 0) System.arraycopy(array, low, helper, low, high + 1 - low);

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /* Iterate through helper array. Compare the left and right
         * half, copying back the smaller element from the two halves
         * into the original array. */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* Copy the rest of the left side of the array into the
         * target array */
        int remaining = middle - helperLeft;
        if (remaining + 1 >= 0) System.arraycopy(helper, helperLeft, array, current, remaining + 1);
    }

    public static void main(String[] args) {
        int size = 20;
        int[] array = AssortedMethods.randomArray(size, 0, size - 1);
        int[] validate = new int[size];
        AssortedMethods.printIntArray(array);
        for (int i = 0; i < size; i++) {
            validate[array[i]]++;
        }
        mergesort(array);
        for (int i = 0; i < size; i++) {
            validate[array[i]]--;
        }
        AssortedMethods.printIntArray(array);
        for (int i = 0; i < size; i++) {
            if (validate[i] != 0 || (i < (size - 1) && array[i] > array[i + 1])) {
                System.out.println("ERROR");
            }
        }
    }

}
