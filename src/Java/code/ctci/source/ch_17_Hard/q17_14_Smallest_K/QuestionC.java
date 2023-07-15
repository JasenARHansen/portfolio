package Java.code.ctci.source.ch_17_Hard.q17_14_Smallest_K;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.Random;

public class QuestionC {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 9, -1, 11, 6, 13, 15};
        int[] smallest = smallestK(array, 3);
        System.out.println(AssortedMethods.arrayToString(smallest));
    }

    public static int max(int[] array, int left, int right) {
        /* Get the largest element in array between left and right indices. */
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    public static int partition(int[] array, int left, int right, int pivot) {
    /* Partition array around pivot such that all elements <= pivot
    come before all elements > pivot. */
        while (left <= right) {
            if (array[left] > pivot) {
        /* Left is bigger than pivot. Swap it to the right
        side, where we know it should be. */
                swap(array, left, right);
                right--;
            } else if (array[right] <= pivot) {
        /* Right is smaller than the pivot. Swap it to the
        left side, where we know it should be. */
                swap(array, left, right);
                left++;
            } else {
        /* Left and right are in correct places. Expand both
        sides. */
                left++;
                right--;
            }
        }
        return left - 1;
    }

    public static int randomIntInRange(int min, int max) {
        /* Get random integer within range, inclusive. */
        Random rand = new Random();
        return rand.nextInt(max + 1 - min) + min;
    }

    public static int rank(int[] array, int rank) {
        /* Get item with rank. */
        return rank(array, 0, array.length - 1, rank);
    }

    public static int rank(int[] array, int left, int right, int rank) {
        /* Get element with rank between left and right indices. */
        int pivot = array[randomIntInRange(left, right)];
        int leftEnd = partition(array, left, right, pivot); // returns end of left partition
        int leftSize = leftEnd - left + 1;
        if (rank == leftSize - 1) {
            return max(array, left, leftEnd);
        } else if (rank < leftSize) {
            return rank(array, left, leftEnd, rank);
        } else {
            return rank(array, leftEnd + 1, right, rank - leftSize);
        }
    }

    public static int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }
        int threshold = rank(array, k - 1);
        int[] smallest = new int[k];
        int count = 0;
        for (int a : array) {
            if (a <= threshold) {
                smallest[count] = a;
                count++;
            }
        }
        return smallest;
    }

    public static void swap(int[] array, int i, int j) {
        /* Swap values at index i and j. */
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
