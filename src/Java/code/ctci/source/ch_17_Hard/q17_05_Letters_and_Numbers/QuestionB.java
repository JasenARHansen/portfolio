package Java.code.ctci.source.ch_17_Hard.q17_05_Letters_and_Numbers;

import java.util.HashMap;

@SuppressWarnings({"SpellCheckingInspection", "DuplicatedCode"})
public class QuestionB {
    public static void main(String[] args) {
        char b = '1';
        char a = 'a';
        char[] array = {
                a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a
        };
        for (char value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        char[] max = findLongestSubArray(array);
        if (max == null) {
            System.out.println("No equal subArray");
        } else {
            System.out.println(max.length);
            for (char c : max) {
                System.out.print(c + " ");
            }
            System.out.println("\nIs Valid? " + isEqual(max, 0, max.length));
        }
    }

    public static char[] findLongestSubArray(char[] array) {
        /* Compute deltas betw count of numbers and count of letters. */
        int[] deltas = computeDeltaArray(array);
        /* Find pair in deltas with matching values and largest span. */
        int[] match = findLongestMatch(deltas);
    /* Return the subArray. Note that it starts one *after* the
    initial occurrence of this delta. */
        return extract(array, match[0] + 1, match[1]);
    }

    public static boolean isEqual(char[] array, int start, int end) {
        int counter = 0;
        for (int i = start; i < end; i++) {
            if (Character.isLetter(array[i])) {
                counter++;
            } else if (Character.isDigit(array[i])) {
                counter--;
            }
        }
        return counter == 0;
    }

    public static int[] computeDeltaArray(char[] array) {
    /* Compute the difference between the number of letters and
    numbers between the beginning of the array and each index. */
        int[] deltas = new int[array.length];
        int delta = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                delta++;
            } else if (Character.isDigit(array[i])) {
                delta--;
            }
            deltas[i] = delta;
        }
        return deltas;
    }

    public static int[] findLongestMatch(int[] deltas) {
    /* Find the matching pair of values in the deltas array with the
    largest difference in indices. */
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[] max = new int[2];
        for (int i = 0; i < deltas.length; i++) {
            if (!map.containsKey(deltas[i])) {
                map.put(deltas[i], i);
            } else {
                int match = map.get(deltas[i]);
                int distance = i - match;
                int longest = max[1] - max[0];
                if (distance > longest) {
                    max[1] = i;
                    max[0] = match;
                }
            }
        }
        return max;
    }

    public static char[] extract(char[] array, int start, int end) {
        if (start > end) return null;
        char[] subArray = new char[end - start + 1];
        if (end + 1 - start >= 0) System.arraycopy(array, start, subArray, 0, end + 1 - start);
        return subArray;
    }
}
