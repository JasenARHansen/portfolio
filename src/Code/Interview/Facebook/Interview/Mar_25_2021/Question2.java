package Code.Interview.Facebook.Interview.Mar_25_2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question2 {

    public static void getDescription() {
        System.out.println("""
                Question:

                Given a list of two-dimensional points, can we identify the presence of a rectangle with any 4 point?

                [(0,0), (50,50), (100,50), (50,200), (100,200), (120, 200), ...]

                Answer: (50,50), (100,50), (50,200), (100,200)

                // Construct new points to test
                (50,50)     50 , 200
                100, 50    (100,200)

                Worst Brute force : O(n^4)""".indent(2));
    }

    public static boolean rectangleFound(int[][] input) {
        Set<String> points = new HashSet<>();

        for (int[] point : input) {
            points.add(Arrays.toString(point));
        }

        for (int first = 0; first < input.length - 1; first++) {
            for (int second = first + 1; second < input.length; second++) {
                int[] p1 = input[first];
                int[] p4 = input[second];
                int[] p2 = {p1[0], p4[1]};
                int[] p3 = {p4[0], p1[1]};
                // validation that this is a rectangle, not a line
                if ((points.contains(Arrays.toString(p2))) && (points.contains(Arrays.toString(p3))) && (p1[0] != p4[0]) && (p1[1] != p4[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}
