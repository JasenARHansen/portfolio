package Java.code.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Sequence {

    public static void getDescription() {
        System.out.println(
                """
                        The Fibonacci sequence is a series of numbers where a number is the addition of the last
                         two numbers, starting with 0, and 1.
                        The Fibonacci Sequence: ..., -8, 5, -3, 2, -1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
                        Written as a rule, the expression is:
                         Positive values of n:  Xn = Xn-1 + Xn-2
                         Negative values of n:  Xn-2 = Xn - Xn-1"""
                        .indent(2));
    }

    public static int getFibonacci(int count) {
        int even = 0;
        int odd = 1;
        boolean flip = true;
        if (count > 1) {
            int iterate = count - 1;
            while (iterate > 0) {
                if (flip) {
                    even += odd;
                } else {
                    odd += even;
                }
                flip = !flip;
                iterate--;
            }
        } else if (count < 0) {
            int iterate = count;
            while (iterate < 0) {
                if (flip) {
                    even -= odd;
                } else {
                    odd -= even;
                }
                flip = !flip;
                iterate++;
            }
        }
        return (count % 2 == 0) ? even : odd;
    }

    public static List<Integer> getPascalTriangleRow(int row) {
        List<Integer> returnList = new ArrayList<>(Collections.singletonList(1));
        while (row > 0) {
            row--;
            List<Integer> rowList = new ArrayList<>();
            // first entry
            rowList.add(returnList.get(0));
            // middle entries
            if (returnList.size() > 1) {
                for (int index = 0; index < returnList.size() - 1; index++) {
                    rowList.add(returnList.get(index) + returnList.get(index + 1));
                }
            }
            // last entry
            rowList.add(returnList.get(returnList.size() - 1));
            returnList = rowList;
        }
        return returnList;
    }
}
