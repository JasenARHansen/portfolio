package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_10_Rank_from_Stream;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

@SuppressWarnings("unused")
public class Question {
    private static RankNode root = null;

    public static int getRankOfNumber(int number) {
        return root.getRank(number);
    }

    public static void main(String[] args) {
        int size = 100;
        int[] list = AssortedMethods.randomArray(size, -100, 100);
        for (int j : list) {
            track(j);
        }
        int[] tracker = new int[size];
        for (int v : list) {
            int rank1 = root.getRank(v);
            tracker[rank1] = v;
        }
        for (int i = 0; i < tracker.length - 1; i++) {
            if (tracker[i] != 0 && tracker[i + 1] != 0) {
                if (tracker[i] > tracker[i + 1]) {
                    System.out.println("ERROR at " + i);
                }
            }
        }
        System.out.println("Array: " + AssortedMethods.arrayToString(list));
        System.out.println("Ranks: " + AssortedMethods.arrayToString(tracker));
    }

    public static void track(int number) {
        if (root == null) {
            root = new RankNode(number);
        } else {
            root.insert(number);
        }
    }
}
