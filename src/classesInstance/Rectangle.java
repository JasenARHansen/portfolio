package classesInstance;

public class Rectangle {
    public Tuple<Integer, Integer> point1;
    public Tuple<Integer, Integer> point2;

    public Rectangle(int point1X, int point1Y, int point2X, int point2Y) {
        this.point1 = new Tuple<>(point1X, point1Y);
        this.point2 = new Tuple<>(point2X, point2Y);
    }

    public int getArea() {
        return width() * height();
    }

    public Tuple<Integer, Integer> getPoint1() {
        return this.point1;
    }

    public Tuple<Integer, Integer> getPoint2() {
        return this.point2;
    }

    public int getXMaximum() {
        return Math.max(point1.getLeftData(), point2.getLeftData());
    }

    public int getXMinimum() {
        return Math.min(point1.getLeftData(), point2.getLeftData());
    }

    public int getYMaximum() {
        return Math.max(point1.getRightData(), point2.getRightData());
    }

    public int getYMinimum() {
        return Math.min(point1.getRightData(), point2.getRightData());
    }

    public int height() {
        return this.point2.getRightData() - this.point1.getRightData();
    }

    @Override
    public String toString() {
        return String.format("[(%s, %s), (%s, %s)]", this.getXMinimum(), this.getYMinimum(), this.getXMaximum(),
                this.getYMaximum());
    }

    public int width() {
        return this.point2.getLeftData() - this.point1.getLeftData();
    }

}