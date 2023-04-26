package Java.Code.Interview.Facebook.Practice;

import java.util.*;

public class SeatingArrangements {

    public static void getDescription() {
        System.out.println("""
                Seating Arrangements
                There are n guests attending a dinner party, numbered from 1 to n. The ith guest has a height of arr[i-1] inches.
                The guests will sit down at a circular table which has n seats, numbered from 1 to n in clockwise order around the table.
                As the host, you will choose how to arrange the guests, one per seat.
                Note that there are n! possible permutations of seat assignments.
                Once the guests have sat down, the awkwardness between a pair of guests sitting in adjacent seats is defined as the absolute difference between their two heights.
                Note that, because the table is circular, seats 1 and n are considered to be adjacent to one another, and that there are therefore n pairs of adjacent guests.
                The overall awkwardness of the seating arrangement is then defined as the maximum awkwardness of any pair of adjacent guests. Determine the minimum possible overall awkwardness of any seating arrangement.
                Signature
                 int minOverallAwkwardness(int[] arr)
                Input
                 n is in the range [3, 1000].
                 Each height arr[i] is in the range [1, 1000].
                Output
                 Return the minimum achievable overall awkwardness of any seating arrangement.
                Example
                 n = 4
                 arr = [5, 10, 6, 8]
                 output = 4
                If the guests sit down in the permutation [3, 1, 4, 2] in clockwise order around the table (having heights [6, 5, 8, 10], in that order), then the four awkwardness between pairs of adjacent guests will be |6-5| = 1, |5-8| = 3, |8-10| = 2, and |10-6| = 4, yielding an overall awkwardness of 4. It's impossible to achieve a smaller overall awkwardness.
                """.indent(2));
    }

    public static int minOverallAwkwardness(int[] arr) {
        int awkwardness = 0;
        if (arr.length == 0) {
            return awkwardness;
        }
        int[] working = new int[arr.length];
        // a bell curve seems best for this
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int person : arr) {
            priorityQueue.add(person);
        }
        int left = 0;
        int right = arr.length - 1;
        for (int index = 0; index < arr.length; index++) {
            if ((index % 2) == 0) {
                // [left] = priorityQueue.poll();
                working[left] = priorityQueue.remove();
                left++;
            } else {
                // working[right] = priorityQueue.poll();
                working[right] = priorityQueue.remove();
                right--;
            }
        }
        for (int seat = 0; seat < arr.length; seat++) {
            int current = Math.abs(working[seat] - working[(seat + 1) % arr.length]);
            if (current > awkwardness) {
                awkwardness = current;
            }
        }
        return awkwardness;
    }

    public static int minOverallAwkwardness_brute(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        Stack<Integer> seating = new Stack<>();
        List<Integer> toSeat = new ArrayList<>();
        for (int person : arr) {
            toSeat.add(person);
        }
        return processPermutations(seating, toSeat);
    }

    private static int processPermutations(Stack<Integer> seating, List<Integer> toBeSeated) {
        int awkwardness = Integer.MAX_VALUE;
        if (!toBeSeated.isEmpty()) {
            for (int index = 0; index < toBeSeated.size(); index++) {
                seating.add(toBeSeated.remove(0));
                int awkwardnessLocal = processPermutations(seating, toBeSeated);
                toBeSeated.add(seating.pop());
                if (awkwardnessLocal < awkwardness) {
                    awkwardness = awkwardnessLocal;
                }
            }
        } else {
            int running = 0;
            for (int index = 0; index < seating.size(); index++) {
                int working = Math.abs(seating.get(index) - seating.get((index + 1) % seating.size()));
                if (working > running) {
                    running = working;
                }
            }
            awkwardness = running;
        }
        return awkwardness;
    }
}
