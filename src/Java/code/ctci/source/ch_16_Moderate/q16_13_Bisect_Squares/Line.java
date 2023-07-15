package Java.code.ctci.source.ch_16_Moderate.q16_13_Bisect_Squares;

public record Line(Point start, Point end) {

    public Point end() {
        return this.end;
    }

    public Point start() {
        return this.start;
    }

    public String toString() {
        return "Line from " + this.start.toString() + " to " + this.end.toString();
    }
}
