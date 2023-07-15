package Java.code.educative;

public class DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers {
    private static int _longest_increasing_subsequence(int index, int[] values) {
        int returnLength = 0;
        int local;
        // Start path
        if (index < 0) {
            for (int i = 0; i < values.length; i++) {
                local = _longest_increasing_subsequence(i, values);
                if (local > returnLength) {
                    returnLength = local;
                }
            }
            return returnLength;
        }
        // recursive path
        else {
            for (int i = index + 1; i < values.length; i++) {
                if (values[index] < values[i]) {
                    local = _longest_increasing_subsequence(i, values);
                    if (local > returnLength) {
                        returnLength = local;
                    }
                }
            }
            return returnLength + 1;
        }
    }

    public static void getDescription() {
        System.out.println(
                """
                        The Longest Increasing Subsequence (LIS) problem is to find the length
                         of the longest subsequence of a given sequence such that all elements
                         of the subsequence are sorted in increasing order.
                        For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80}
                         is 6 and LIS is {10, 22, 33, 50, 60, 80}.
                        Input: arr[] = {3, 10, 2, 1, 20}
                        Output: Length of LIS = 3
                        The longest increasing subsequence is 3, 10, 20
                        Input: arr[] = {3, 2}
                        Output: Length of LIS = 1
                        The longest increasing subsequences are {3} and {2}
                        Input: arr[] = {50, 3, 10, 7, 40, 80}
                        Output: Length of LIS = 4
                        The longest increasing subsequence is {3, 7, 40, 80}"""
                        .indent(2));
    }

    public static int longest_increasing_subsequence_dynamic(int[] values) {
        int[] paths = new int[values.length];
        for (int i = 1; i < values.length; i++) {
            for (int j = 0; j < i; j++) {
                if (values[j] < values[i]) {
                    paths[i] = Math.max((paths[j] + 1), paths[i]);
                }
            }
        }
        int local = 0;
        for (int number : paths) {
            if (number > local) {
                local = number;
            }
        }
        return local + 1;
    }

    public static int longest_increasing_subsequence_recursion(int[] values) {
        return _longest_increasing_subsequence(-1, values);
    }
}
