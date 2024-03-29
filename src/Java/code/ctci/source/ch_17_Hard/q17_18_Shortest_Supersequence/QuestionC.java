package Java.code.ctci.source.ch_17_Hard.q17_18_Shortest_Supersequence;

public class QuestionC {
    public static void main(String[] args) {
        int[] array = {9, 2, 4, 6, 2, 5, 9};
        int[] set = {1, 5, 9};
        System.out.println(array.length);
        Range shortest = shortestSuperSequence(array, set);
        if (shortest == null) {
            System.out.println("No valid subsequence.");
        } else {
            System.out.println(shortest.getStart() + ", " + shortest.getEnd());
        }
    }

    public static Range shortestSuperSequence(int[] big, int[] small) {
        int[] closures = getClosures(big, small);
        return getShortestClosure(closures);
    }

    public static int[] getClosures(int[] big, int[] small) {
        /* Get closure for each index. */
        int[] closure = new int[big.length];
        for (int j : small) {
            sweepForClosure(big, closure, j);
        }
        return closure;
    }

    public static Range getShortestClosure(int[] closures) {
        /* Get shortest closure. */
        if (closures == null || closures.length == 0) return null;
        Range shortest = new Range(0, closures[0]);
        for (int i = 1; i < closures.length; i++) {
            if (closures[i] == -1) {
                break;
            }
            Range range = new Range(i, closures[i]);
            if (!shortest.shorterThan(range)) {
                shortest = range;
            }
        }
        if (shortest.length() <= 0) return null;
        return shortest;
    }

    public static void sweepForClosure(int[] big, int[] closures, int value) {
        /* Do backwards sweep and update the closures list with the next occurrence of value, if it's later than the current closure. */
        int next = -1;
        for (int i = big.length - 1; i >= 0; i--) {
            if (big[i] == value) {
                next = i;
            }
            if ((next == -1 || closures[i] < next) && (closures[i] != -1)) {
                closures[i] = next;
            }
        }
    }
}
