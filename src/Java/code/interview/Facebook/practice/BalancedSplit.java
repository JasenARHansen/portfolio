package Java.code.interview.Facebook.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class BalancedSplit {
    public static boolean balancedSplitExists(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted().toList();
        for (int index = 0; index < arr.length - 1; index++) {
            while ((index < arr.length - 1) && (Objects.equals(list.get(index), list.get(index + 1)))) {
                index++;
            }
            if (subListSum(list, 0, index) == subListSum(list, index + 1, arr.length - 1)) {
                return true;
            }
        }
        return false;
    }

    private static int subListSum(List<Integer> list, int start, int stop) {
        int sum = 0;
        for (int index = start; index <= stop; index++) {
            sum += list.get(index);
        }
        return sum;
    }

    public static boolean balancedSplitExistsNonRestricted(int[] arr) {
        int[] left;
        int[] right;
        int size = arr.length;
        for (int count = 0; count < Math.pow(2, size); count++) {
            boolean[] bits = getBooleanBitArray(size, count);
            left = new int[size];
            right = new int[size];
            for (int index = 0; index < size; index++) {
                if (bits[index]) {
                    left[index] = arr[index];
                } else {
                    right[index] = arr[index];
                }
            }
            if (arraySum(left) == arraySum(right)) {
                return true;
            }
        }
        return false;
    }

    private static boolean[] getBooleanBitArray(int size, int value) {
        boolean[] bits = new boolean[size];
        for (int i = size - 1; i >= 0; i--) {
            bits[i] = (value & (1 << i)) != 0;
        }
        return bits;
    }

    private static int arraySum(int[] arr) {
        int sum = 0;
        for (int number : arr) {
            sum += number;
        }
        return sum;
    }

    public static void getDescription() {
        System.out.println(
                """
                        Balanced Split
                        Given an array of integers (which may include repeated integers), determine if
                         there's a way to split the array into two subsequences A and B such that the
                         sum of the integers in both arrays is the same, and all of the integers in A
                         are strictly smaller than all of the integers in B.
                        Note: Strictly smaller denotes that every integer in A must be less than, and
                         not equal to, every integer in B.
                        Signature
                         bool balancedSplitExists(int[] arr)
                        Input
                         All integers in array are in the range [0, 1,000,000,000].
                        Output
                         Return true if such a split is possible, and false otherwise.
                        Example 1
                         arr = [1, 5, 7, 1]
                         output = true
                        We can split the array into A = [1, 1, 5] and B = [7].
                        Example 2
                         arr = [12, 7, 6, 7, 6]
                         output = false
                        We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't
                         satisfy the requirement that all integers in A are smaller than all integers in B.
                        """
                        .indent(2));
    }
}
