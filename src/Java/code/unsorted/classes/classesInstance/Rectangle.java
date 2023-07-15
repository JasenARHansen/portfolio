package Java.code.unsorted.classes.classesInstance;

@SuppressWarnings({"unused", "SuspiciousNameCombination"})
public class Rectangle {
    public final Tuple<Integer, Integer> point1;
    public final Tuple<Integer, Integer> point2;

    public Rectangle(int point1X, int point1Y, int point2X, int point2Y) {
        this.point1 = new Tuple<>(point1X, point1Y);
        this.point2 = new Tuple<>(point2X, point2Y);
    }

    public int getArea() {
        return width() * height();
    }

    public int width() {
        return this.point2.leftData() - this.point1.leftData();
    }

    public int height() {
        return this.point2.rightData() - this.point1.rightData();
    }

    public Tuple<Integer, Integer> getPoint1() {
        return this.point1;
    }

    public Tuple<Integer, Integer> getPoint2() {
        return this.point2;
    }

    @Override
    public String toString() {
        return String.format(
                "[(%s, %s), (%s, %s)]",
                this.getXMinimum(), this.getYMinimum(), this.getXMaximum(), this.getYMaximum());
    }

    public int getXMinimum() {
        return Math.min(point1.leftData(), point2.leftData());
    }

    public int getYMinimum() {
        return Math.min(point1.rightData(), point2.rightData());
    }

    public int getXMaximum() {
        return Math.max(point1.leftData(), point2.leftData());
    }

    public int getYMaximum() {
        return Math.max(point1.rightData(), point2.rightData());
    }
}
