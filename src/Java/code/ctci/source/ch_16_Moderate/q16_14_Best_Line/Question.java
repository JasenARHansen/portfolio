package Java.code.ctci.source.ch_16_Moderate.q16_14_Best_Line;

import Java.code.ctci.source.ctciLibrary.HashMapList;

import java.util.ArrayList;
import java.util.Set;

public class Question {
    public static void main(String[] args) {
        GraphPoint[] points = createPoints();
        Line line = findBestLine(points);
        line.Print();
        System.out.println(validate(line, points));
    }

    public static GraphPoint[] createPoints() {
        int n_points = 100;
        System.out.println("Points on Graph\n***************");
        GraphPoint[] points = new GraphPoint[n_points - 1];
        for (int i = 0; i < n_points / 2; i++) {
            GraphPoint p = new GraphPoint(i, 2.3 * ((double) i) + 20.0);
            points[i] = p;
            System.out.println(p);
        }
        for (int i = 0; i < n_points / 2 - 1; i++) {
            GraphPoint p = new GraphPoint(i, 3.0 * ((double) i) + 1.0);
            points[n_points / 2 + i] = p;
            System.out.println(p);
        }
        System.out.println("****************\n");
        return points;
    }

    public static Line findBestLine(GraphPoint[] points) {
        /* Find line that goes through most number of points. */
        HashMapList<Double, Line> linesBySlope = getListOfLines(points);
        return getBestLine(linesBySlope);
    }

    public static int validate(Line line, GraphPoint[] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line other = new Line(points[i], points[j]);
                if (line.isEquivalent(other)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static HashMapList<Double, Line> getListOfLines(GraphPoint[] points) {
        /* Add each pair of points as a line to the list. */
        HashMapList<Double, Line> linesBySlope = new HashMapList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                double key = Line.floorToNearestEpsilon(line.slope);
                linesBySlope.put(key, line);
            }
        }
        return linesBySlope;
    }

    public static Line getBestLine(HashMapList<Double, Line> linesBySlope) {
        /* Return the line with the most equivalent other lines. */
        Line bestLine = null;
        int bestCount = 0;
        Set<Double> slopes = linesBySlope.keySet();
        for (double slope : slopes) {
            ArrayList<Line> lines = linesBySlope.get(slope);
            for (Line line : lines) {
                /* count lines that are equivalent to current line. */
                int count = countEquivalentLines(linesBySlope, line);
                /* if better than current line, replace it. */
                if (count > bestCount) {
                    bestLine = line;
                    bestCount = count;
                    bestLine.Print();
                    System.out.println(bestCount);
                }
            }
        }
        return bestLine;
    }

    public static int countEquivalentLines(HashMapList<Double, Line> linesBySlope, Line line) {
    /* Check hashmap for lines that are equivalent. Note that we need to check one epsilon above and below the actual slope
    since we're defining two lines as equivalent if they're within an epsilon of each other. */
        double key = Line.floorToNearestEpsilon(line.slope);
        int count = countEquivalentLines(linesBySlope.get(key), line);
        count += countEquivalentLines(linesBySlope.get(key - Line.epsilon), line);
        count += countEquivalentLines(linesBySlope.get(key + Line.epsilon), line);
        return count;
    }

    public static int countEquivalentLines(ArrayList<Line> lines, Line line) {
        /* Count lines within an array of lines which are "equivalent" (slope and y-intercept are within an epsilon value) to a given line. */
        if (lines == null) {
            return 0;
        }
        int count = 0;
        for (Line parallelLine : lines) {
            if (parallelLine.isEquivalent(line)) {
                count++;
            }
        }
        return count;
    }
}
