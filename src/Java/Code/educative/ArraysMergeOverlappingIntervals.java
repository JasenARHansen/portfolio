package Java.code.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMergeOverlappingIntervals {
  public static void getDescription() {
    System.out.println(
        """
                You are given an array (list) of interval pairs as input where each interval
                 has a start and end timestamp.
                The input array is sorted by starting timestamps.
                You are required to merge overlapping intervals and return a new output array.
                Consider the input array below.
                 Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping, so they should be
                 merged to one big interval (1, 8).
                Similarly, intervals (10, 12) and (12, 15) are also overlapping and should be merged to (10, 15).
                Try it yourself before reviewing the solution and explanation.
                  (1, 5), (3, 7), (4, 6), (6, 8) -> (1, 8)
                  (10, 12) and (12, 15) -> (10, 15)
                Runtime complexity: Linear, O(n)
                Memory Complexity: Linear, O(n)
                This problem can be solved in a simple linear scan algorithm.
                We know that input is sorted by starting timestamps.
                Here is the approach we are following:
                  List of input intervals is given, and we’ll keep merged intervals in the output list.
                  For each interval in the input list:
                  If the input interval is overlapping with the last interval in the output list then
                   we’ll merge these two intervals and update the last interval of the output list with
                   the merged interval.
                  Otherwise, we’ll add an input interval to the output list."""
            .indent(2));
  }

  public static int[][] mergeIntervalsArray(int[][] array) {
    List<int[]> returnList = new ArrayList<>(Arrays.asList(array));
    returnList = mergeIntervalsList(returnList);
    int[][] returnArray = new int[returnList.size()][2];
    for (int index = 0; index < returnList.size(); index++) {
      returnArray[index] = returnList.get(index);
    }
    return returnArray;
  }

  public static List<int[]> mergeIntervalsList(List<int[]> list) {
    List<int[]> returnList = new ArrayList<>();
    int start = list.get(0)[0];
    int stop = list.get(0)[1];
    for (int index = 1; index < list.size(); index++) {
      if (list.get(index)[0] > stop) {
        returnList.add(new int[] {start, stop});
        start = list.get(index)[0];
        stop = list.get(index)[1];
      } else if (list.get(index)[1] > stop) {
        stop = list.get(index)[1];
      }
    }
    returnList.add(new int[] {start, stop});
    return returnList;
  }
}
