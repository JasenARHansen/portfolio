package CTCI_SOURCE.other.Ch_16_Moderate.Q16_13_Bisect_Squares;

public class Square {
    public double left;
    public double top;
    public double bottom;
    public double right;
    public double size;

    public Square(double left, double top, double size) {
        this.left = left;
        this.top = top;
        this.bottom = top + size;
        this.right = left + size;
        this.size = size;
    }

    public Point middle() {
        return new Point((this.left + this.right) / 2.0, (this.top + this.bottom) / 2.0);
    }

    public boolean contains(Square other) {
        return this.left <= other.left && this.right >= other.right && this.top <= other.top && this.bottom >= other.bottom;
    }

    /* Return the point where the line segment connecting mid1 and
     * mid2 intercepts the edge of square 1. That is, draw a line
     * from mid2 to mid1, and continue it out until the edge of
     * the square. */
    public Point extend(Point mid1, Point mid2, double size) {
        /* Find what direction the line mid2 -> mid1 goes */
        double xdir = mid1.x < mid2.x ? -1 : 1;
        double ydir = mid1.y < mid2.y ? -1 : 1;

        /* If mid1 and mid2 have the same x value, then the slope
         * calculation will throw a divide by 0 exception. So, we
         * compute this specially. */
        if (mid1.x == mid2.x) {
            return new Point(mid1.x, mid1.y + ydir * size / 2.0);
        }
        double slope = (mid1.y - mid2.y) / (mid1.x - mid2.x);
        double x1;
        double y1;

        /* Calculate slope using the equation (y1 - y2) / (x1 - x2).
         * Note: if the slope is �steep� (>1) then the end of the
         * line segment will hit size / 2 units away from the middle
         * on the y axis. If the slope is �shallow� (<1) the end of
         * the line segment will hit size / 2 units away from the
         * middle on the x axis. */
        if (Math.abs(slope) == 1) {
            x1 = mid1.x + xdir * size / 2.0;
            y1 = mid1.y + ydir * size / 2.0;
        } else if (Math.abs(slope) < 1) {
            x1 = mid1.x + xdir * size / 2.0;
            y1 = slope * (x1 - mid1.x) + mid1.y;
        } else {
            y1 = mid1.y + ydir * size / 2.0;
            x1 = (y1 - mid1.y) / slope + mid1.x;
        }
        return new Point(x1, y1);
    }

    public Line cut(Square other) {
        /* Calculate where a line between each middle would collide with the edges of the squares */
        Point p1 = extend(this.middle(), other.middle(), this.size);
        Point p2 = extend(this.middle(), other.middle(), -1 * this.size);
        Point p3 = extend(other.middle(), this.middle(), other.size);
        Point p4 = extend(other.middle(), this.middle(), -1 * other.size);

        /* Of above points, find start and end of lines. Start is farthest left (with top most as a tie breaker)
         * and end is farthest right (with bottom most as a tie breaker */
        Point start = p1;
        Point end = p1;
        Point[] points = {p2, p3, p4};
        for (Point point : points) {
            if (point.x < start.x || (point.x == start.x && point.y < start.y)) {
                start = point;
            } else if (point.x > end.x || (point.x == end.x && point.y > end.y)) {
                end = point;
            }
        }

        return new Line(start, end);
    }

    public String toString() {
        return "(" + left + ", " + top + ")|(" + right + "," + bottom + ")";
    }
}
