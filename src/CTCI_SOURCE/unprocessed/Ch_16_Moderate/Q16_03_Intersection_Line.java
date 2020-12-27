package CTCI_SOURCE.unprocessed.Ch_16_Moderate;

public class Q16_03_Intersection_Line {
    public double slope;
    public double yintercept;

    public Q16_03_Intersection_Line(Q16_03_Intersection_Point start, Q16_03_Intersection_Point end) {
        double deltaY = end.y - start.y;
        double deltaX = end.x - start.x;
        slope = deltaY / deltaX; // Will be Infinity (not exception) when deltaX = 0
        yintercept = end.y - slope * end.x;
    }

    public void print() {
        System.out.print("y = " + slope + "x + " + yintercept);
    }
}