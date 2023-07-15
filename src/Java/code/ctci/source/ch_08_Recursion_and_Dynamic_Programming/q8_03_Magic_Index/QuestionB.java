package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_03_Magic_Index;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class QuestionB {

    /* Creates an array that is sorted */
    public static int[] getSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        return array;
    }

    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    public static int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }
        /* Search left */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }
        /* Search right */
        int rightIndex = Math.max(midIndex + 1, midValue);
        return magicFast(array, rightIndex, end);
    }

    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            int[] array = getSortedArray(size);
            int v2 = magicFast(array);
            if (v2 == -1 && magicSlow(array) != -1) {
                int v1 = magicSlow(array);
                System.out.println("Incorrect value: index = -1, actual = " + v1 + " " + i);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            } else if (v2 > -1 && array[v2] != v2) {
                System.out.println("Incorrect values: index= " + v2 + ", value " + array[v2]);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            }
        }
    }
}
