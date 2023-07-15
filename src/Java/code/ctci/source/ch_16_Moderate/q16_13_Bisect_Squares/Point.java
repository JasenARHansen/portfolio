package Java.code.ctci.source.ch_16_Moderate.q16_13_Bisect_Squares;

@SuppressWarnings("unused")
public record Point(double x, double y) {

    public boolean isEqual(Point p) {
        return (p.x == this.x && p.y == this.y);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }
}
