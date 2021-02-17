package Code.educative;

import java.util.ArrayList;
import java.util.List;

public class ListsAddTwoNumbersAsAList {
  /*
    Given two numbers represented by two lists, write a function that returns the sum list. The sum list is list
     representation of the addition of two input numbers.
    Example:
        Input:
        List1: 5->6->3 // represents number 365
        List2: 8->4->2 // represents number 248
        Output:
        Resultant list: 3->1->6 // represents number 613
        Explanation: 365 + 248 = 613
        Input:
        List1: 7->5->9->4->6 // represents number 64957
        List2: 8->4 // represents number 48
        Output:
        Resultant list: 5->0->0->5->6 // represents number 65005
        Explanation: 64957 + 48 = 65005
    Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
    Approach: Traverse both lists and One by one pick nodes of both lists and add the values. If the sum is more than
     10 then make carry as 1 and reduce sum. If one list has more elements than the other then consider remaining
     values of this list as 0.

    The steps are:
        Traverse the two linked lists from start to end
        Add the two digits each from respective linked lists.
        If one of the list has reached the end then take 0 as its digit.
        Continue it until both the lists end.
        If the sum of two digits is greater than 9 then set carry as 1 and the current digit as sum % 10

    Below is the implementation of this approach.
    Output

  First List is 7 5 9 4 6
  Second List is 8 4
  Resultant list is 5 0 0 5 6

  Complexity Analysis:
    Time Complexity: O(m + n), where m and n are number of nodes in first and second lists respectively.
    The lists needs to be traversed only once.
    Space Complexity: O(m + n).
    A temporary linked list is needed to store the output number

  https://www.youtube.com/watch?v=LLPuC5kWD8U
    */

    public static List<String> addTwoLists_most_significant_digit_first(
            List<String> left, List<String> right) {

        List<String> result = new ArrayList<>();
        int padding = Math.abs(left.size() - right.size());
        if (left.size() > right.size()) {
            for (int i = 0; i < padding; i++) {
                right.add(0, "0");
            }
        } else {
            for (int i = 0; i < padding; i++) {
                left.add(0, "0");
            }
        }
        int carry = 0;
        int current;
        for (int index = left.size() - 1; index >= 0; index--) {
            current = Integer.parseInt(left.get(index)) + Integer.parseInt(right.get(index)) + carry;
            result.add(0, Integer.toString(current % 10));
            carry = current / 10;
        }
        if (carry > 0) {
            result.add(0, Integer.toString(carry));
        }

        return result;
    }
}
