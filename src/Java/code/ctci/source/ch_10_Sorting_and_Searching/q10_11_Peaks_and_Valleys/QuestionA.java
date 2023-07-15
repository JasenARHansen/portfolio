package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_11_Peaks_and_Valleys;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
    public static void main(String[] args) {
        int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
        System.out.println(AssortedMethods.arrayToString(array));
        sortValleyPeak(array);
        System.out.println(AssortedMethods.arrayToString(array));
        System.out.println(Tester.confirmValleyPeak(array));
    }

    public static void sortValleyPeak(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i += 2) {
            swap(array, i - 1, i);
        }
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
