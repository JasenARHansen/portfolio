package Java.code.unsorted.classes.classesInstance;

@SuppressWarnings({"unused", "SpellCheckingInspection", "SuspiciousNameCombination"})
public class Line {
    private final Tuple<Double, Double> point1;
    private final Tuple<Double, Double> point2;

    public Line(double point1X, double point1Y, double point2X, double point2Y) {
        this.point1 = new Tuple<>(point1X, point1Y);
        this.point2 = new Tuple<>(point2X, point2Y);
    }

    public Tuple<Double, Double> getPoint1() {
        return this.point1;
    }

    public Tuple<Double, Double> getPoint2() {
        return this.point2;
    }

    public double getXfromY(double y) {
        return (y - this.getYIntercept()) / this.getYIntercept();
    }

    public double getYIntercept() {
        // y = mx +b
        // b = y - mx
        return this.getPoint1Y() - (this.getSlope() * this.getPoint1X());
    }

    public Double getPoint1Y() {
        return this.point1.rightData();
    }

    public double getSlope() {
        return (this.getPoint2Y() - this.getPoint1Y()) / (this.getPoint2X() - this.getPoint1X());
    }

    public Double getPoint1X() {
        return this.point1.leftData();
    }

    public Double getPoint2Y() {
        return this.point2.rightData();
    }

    public Double getPoint2X() {
        return this.point2.leftData();
    }

    public double getYfromX(double x) {
        return (this.getSlope() * x) + this.getYIntercept();
    }

    @Override
    public String toString() {
        return String.format("<%sx + %s>", this.getSlope(), this.getYIntercept());
    }
}
