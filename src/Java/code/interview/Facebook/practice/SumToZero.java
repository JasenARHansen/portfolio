package Java.code.interview.Facebook.practice;

import java.util.*;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
public class SumToZero {
  /*
  Given an array of integers, determine if any three elements sum to zero.
  Input #1: int[]
  boolean threeSumToZero(int[] array);
  ----------
  Example #1
  ----------
  Input #1: [3, 5, 8, 10, -9, -11, 16, 2]
  Output:   true
  ----------
  Example #2
  ----------
  Input #1: [3, 5, 4, 9, -16, -10]
  Output:   false
  ----------
  Example #3
  ----------
  Input #1: [3, -3, 4, 8, -13]
  Output:   false. */

    public static boolean sumTo(int number, int sum, int[] array) {
        Map<Integer, Integer> values = new HashMap<>();
        List<Integer> unused = new ArrayList<>();
        for (Integer element : array) {
            unused.add(element);
            if (values.containsKey(element)) {
                values.put(element, values.get(element) + 1);
            } else {
                values.put(element, 1);
            }
        }
        Stack<Integer> current = new Stack<>();
        return sumTo(number, sum, current, unused, values);
    }

    private static boolean sumTo(
            int number,
            int sum,
            Stack<Integer> current,
            List<Integer> unused,
            Map<Integer, Integer> values) {
        if (current.size() < number - 1) {
            for (int index = 0; index < unused.size(); index++) {
                current.push(unused.remove(0));
                if (sumTo(number, sum, current, unused, values)) {
                    return true;
                } else {
                    unused.add(current.pop());
                }
            }
        } else {
            int total = 0;
            for (int element : current) {
                total += element;
            }
            if (values.containsKey(sum - total)) {
                // This is a separate step because most executions it will not be needed
                Map<Integer, Integer> processing = new HashMap<>();
                // Add expected value
                if (processing.containsKey(sum - total)) {
                    processing.put(sum - total, processing.get(sum - total) + 1);
                } else {
                    processing.put(sum - total, 1);
                }
                // Add other testing values
                for (Integer element : current) {
                    if (processing.containsKey(element)) {
                        processing.put(element, processing.get(element) + 1);
                    } else {
                        processing.put(element, 1);
                    }
                }
                // Check that there are actually enough source values to make this work
                for (Integer key : processing.keySet()) {
                    if (values.get(key) < processing.get(key)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean threeSumToZero(int[] array) {
        Map<Integer, Integer> values = new HashMap<>();
        for (Integer element : array) {
            if (values.containsKey(element)) {
                values.put(element, values.get(element) + 1);
            } else {
                values.put(element, 1);
            }
        }
        for (int leftIndex = 0; leftIndex < array.length - 1; leftIndex++) {
            for (int rightIndex = leftIndex + 1; rightIndex < array.length; rightIndex++) {
                int sum = array[leftIndex] + array[rightIndex];
                if (values.containsKey(-sum)) {
                    if ((array[leftIndex] == -sum) || (array[rightIndex] == -sum)) {
                        if (values.get(-sum) > 1) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
