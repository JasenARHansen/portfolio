package Code.CTCI.CTCI_SOURCE.other.Ch_10_Sorting_and_Searching.Q10_11_Peaks_and_Valleys;

import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class QuestionC {
    public static void main(String[] args) {
        int[] array = {5, 3, 1, 2, 3};
        System.out.println(AssortedMethods.arrayToString(array));
        sortValleyPeak(array);
        System.out.println(AssortedMethods.arrayToString(array));
        System.out.println(Tester.confirmValleyPeak(array));
    }

    public static void sortValleyPeak(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            if (array[i - 1] < array[i]) {
                swap(array, i - 1, i);
            }
            if (i + 1 < array.length && array[i + 1] < array[i]) {
                swap(array, i + 1, i);
            }
        }
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
