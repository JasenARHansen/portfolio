package Java.code.interview.Facebook.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RevenueMilestones {
    public static void getDescription() {
        System.out.println(
                """
                        Revenue Milestones
                        We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue milestones.
                        Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days on which Facebook reached every milestone.
                        Signature
                         int[] getMilestoneDays(int[] revenues, int[] milestones)
                        Input
                         revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N).
                         milestones is a length-K array of total revenue milestones.
                        Output
                         Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue.
                         If the milestone is never met, return -1.
                        Example
                         revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
                         milestones = [100, 200, 500]
                         output = [4, 6, 10]
                        Explanation
                         On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively.
                         Day 6 is the first time that FB has >= $200 of total revenue.
                        """
                        .indent(2));
    }

    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] returnArray = new int[milestones.length];
        Map<Integer, Integer> milestonesMap = new HashMap<>();
        Queue<Integer> milestonesQueue = new PriorityQueue<>();
        for (int index = 0; index < milestones.length; index++) {
            milestonesMap.put(milestones[index], index);
            milestonesQueue.add(milestones[index]);
        }
        int day = 0;
        int total = 0;
        while (!milestonesQueue.isEmpty()) {
            int milestone = milestonesQueue.poll();
            while ((total < milestone) && (day < revenues.length)) {
                total += revenues[day];
                day++;
            }
            if (total >= milestone) {
                returnArray[milestonesMap.get(milestone)] = day;
            } else if ((day == revenues.length) && (returnArray[milestonesMap.get(milestone)] == 0)) {
                returnArray[milestonesMap.get(milestone)] = -1;
            }
        }
        return returnArray;
    }
}
