package Java.code.unsorted.classes.classesInstance;

public class Circle {
    final int radius;
    final int xCoordinate;
    final int yCoordinate;

    public Circle(int xCoordinate, int yCoordinate, int radius) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.radius = radius;
    }

    public int getXMaximum() {
        return this.xCoordinate + this.radius;
    }

    public int getXMinimum() {
        return this.xCoordinate - this.radius;
    }

    public int getYMaximum() {
        return this.yCoordinate + this.radius;
    }

    public int getYMinimum() {
        return this.yCoordinate - this.radius;
    }

    public boolean intersects(Circle otherCircle) {
        // Distance between 2 points = ((x2 - x1)^2 + (y2 - y1)^2)^(1/2)
        double xValues = Math.pow((this.xCoordinate - otherCircle.xCoordinate), 2);
        double yValues = Math.pow((this.yCoordinate - otherCircle.yCoordinate), 2);
        double distance = Math.pow((xValues + yValues), .5);
        int totalRadius = this.radius + otherCircle.radius;
        return (distance <= totalRadius);
    }
}
