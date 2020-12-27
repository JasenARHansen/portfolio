package CTCI_SOURCE.unprocessed.Ch_16_Moderate;

public class Q16_03_Intersection_Question {
    public static Q16_03_Intersection_Point createPoint(int[] coordinates) {
        return new Q16_03_Intersection_Point(coordinates[0], coordinates[1]);
    }

    /* Checks if middle is between start and end. */
    public static boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    /* Checks if middle is between start and end. */
    public static boolean isBetween(Q16_03_Intersection_Point start, Q16_03_Intersection_Point middle, Q16_03_Intersection_Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    public static void swap(Q16_03_Intersection_Point one, Q16_03_Intersection_Point two) {
        double x = one.x;
        double y = one.y;
        one.setLocation(two.x, two.y);
        two.setLocation(x, y);
    }

    public static Q16_03_Intersection_Point intersection(Q16_03_Intersection_Point start1, Q16_03_Intersection_Point end1, Q16_03_Intersection_Point start2, Q16_03_Intersection_Point end2) {
        /* Rearranging these so that, in order of x values: start is before end and point 1 is before point 2.
         * This will make some of the later logic simpler. */
        if (start1.x > end1.x) swap(start1, end1);
        if (start2.x > end2.x) swap(start2, end2);
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        /* Compute lines (including slope and y-intercept). */
        Q16_03_Intersection_Line line1 = new Q16_03_Intersection_Line(start1, end1);
        Q16_03_Intersection_Line line2 = new Q16_03_Intersection_Line(start2, end2);

        /* If the lines are parallel, they intercept only if they have the same y intercept and start 2 is on line 1. */
        if (line1.slope == line2.slope) {
            if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
                return start2;
            }
            return null;
        }

        /* Get intersection coordinate. */
        double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
        double y = x * line1.slope + line1.yintercept;
        Q16_03_Intersection_Point intersection = new Q16_03_Intersection_Point(x, y);

        /* Check if within line segment range. */
        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return intersection;
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] coordinates = {
                {8, 8}, {8, 16},
                {1, 1}, {1, 10}};
        Q16_03_Intersection_Point[] points = {createPoint(coordinates[0]), createPoint(coordinates[1]), createPoint(coordinates[2]), createPoint(coordinates[3])};
        Q16_03_Intersection_Point intersection = intersection(points[0], points[1], points[2], points[3]);
        if (intersection == null) {
            System.out.println("No intersection.");
        } else {
            System.out.println("Intersection: " + intersection.x + ", " + intersection.y);
        }
    }

}
