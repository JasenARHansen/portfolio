package Java.Code.Educative;

import java.util.Stack;

public class StackLargestRectangleInHistogram {
  /*
  Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
          6
        5 6
        5 6
        5 6   3
    2   5 6 2 3
    2 1 5 6 2 3

  Example 1:

  Input: heights = [2,1,5,6,2,3]
  Output: 10
  Explanation: The above is a histogram where width of each bar is 1.
  The largest rectangle is shown in the red area, which has an area = 10 units.
  All of column 5 and 5 elements of column 6
          6
        X X
        X X
        X X   3
    2   X X 2 3
    2 1 X X 2 3

  Example 2:
    4
    4
  2 4
  2 4

  Input: heights = [2,4]
  Output: 4
    4       X
    4       X
  X X     2 X
  X X  or 2 X
  Constraints:
      1 <= heights.length <= 105
      0 <= heights[i] <= 104
  */

  public static int largestRectangleAreaBrute(int[] heights) {
    int area;
    int max_area = -1;
    int index = 0;

    while (index < heights.length) {
      if (heights[index] > 0) {
        for (int height = 1; height <= heights[index]; height++) {
          int width = 0;
          while (((width + index) < heights.length) && (heights[width + index] >= height)) {
            width++;
          }
          area = height * width;
          if (area > max_area) {
            max_area = area;
          }
        }
      }
      index++;
    }
    return max_area;
  }

  public static int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int area;
    int max_area = -1;
    int index = 0;

    while (index < heights.length) {
      if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
        stack.add(index);
        index++;
      } else {
        area = get_area(stack, heights, index);
        if (area > max_area) {
          max_area = area;
        }
      }
    }
    while (!stack.isEmpty()) {
      area = get_area(stack, heights, index);
      if (area > max_area) {
        max_area = area;
      }
    }
    return max_area;
  }

  private static int get_area(Stack<Integer> stack, int[] heights, int index) {
    int top = stack.pop();
    if (stack.isEmpty()) {
      return heights[top] * index;
    } else {
      return heights[top] * (index - stack.peek() - 1);
    }
  }
}
