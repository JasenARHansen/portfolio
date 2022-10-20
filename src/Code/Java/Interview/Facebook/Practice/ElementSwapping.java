package Code.Java.Interview.Facebook.Practice;

public class ElementSwapping {

    public static void getDescription() {
        System.out.println("""
                Element Swapping
                Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be obtained from it after performing at most k element swaps, each involving a pair of consecutive elements in the sequence.
                Note: A list x is lexicographically smaller than a different equal-length list y if and only if, for the earliest index at which the two lists differ, x's element at that index is smaller than y's element at that index.
                Signature
                 int[] findMinArray(int[] arr, int k)
                Input
                 n is in the range [1, 1000].
                 Each element of arr is in the range [1, 1,000,000].
                 k is in the range [1, 1000].
                Output
                 Return an array of n integers output, the lexicographically smallest sequence achievable after at most k swaps.
                Example 1
                 n = 3
                 k = 2
                 arr = [5, 3, 1]
                 output = [1, 5, 3]
                We can swap the 2nd and 3rd elements, followed by the 1st and 2nd elements, to end up with the sequence [1, 5, 3].
                This is the lexicographically smallest sequence achievable after at most 2 swaps.
                Example 2
                 n = 5
                 k = 3
                 arr = [8, 9, 11, 2, 1]
                 output = [2, 8, 9, 11, 1]
                We can swap [11, 2], followed by [9, 2], then [8, 2].
                """.indent(2));
    }

    public static int[] findMinArray(int[] arr, int k) {
        int[] returnArray = arr;
        int swap;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int[] newArr = arr.clone();
                swap = newArr[i];
                newArr[i] = newArr[i + 1];
                newArr[i + 1] = swap;
                if (k > 1) {
                    newArr = findMinArray(newArr, k - 1);
                }
                if (compare(returnArray, newArr) == 1) {
                    returnArray = newArr;
                }
            }
        }
        return returnArray;
    }

    public static int compare(int[] a1, int[] a2) {
        // requirement of bothe arrays being equal length
        // 0 indicates ==
        // 1 indicates >
        // -1 indicates <
        for (int index = 0; index < a1.length; index++) {
            if (a1[index] > a2[index]) {
                return 1;
            }
            if (a1[index] < a2[index]) {
                return -1;
            }
        }
        return 0;
    }
}
