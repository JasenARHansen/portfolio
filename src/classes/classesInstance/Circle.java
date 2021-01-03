package classes.classesInstance;

public class Circle {

    int xCordinate;
    int yCordinate;
    int radius;

    public Circle(int xCoordinate, int yCoordinate, int radius) {
        this.xCordinate = xCoordinate;
        this.yCordinate = yCoordinate;
        this.radius = radius;
    }

    public int getXMaximum() {
        return this.xCordinate + this.radius;
    }

    public int getXMinimum() {
        return this.xCordinate - this.radius;
    }

    public int getYMaximum() {
        return this.yCordinate + this.radius;
    }

    public int getYMinimum() {
        return this.yCordinate - this.radius;
    }

    public boolean intersects(Circle otherCircle) {
        //Distance between 2 points = ((x2 - x1)^2 + (y2 - y1)^2)^(1/2)
        double xValues = Math.pow((this.xCordinate - otherCircle.xCordinate), 2);
        double yValues = Math.pow((this.yCordinate - otherCircle.yCordinate), 2);
        double distance = Math.pow((xValues + yValues), .5);
        int totalRadius = this.radius + otherCircle.radius;

        return (distance <= totalRadius);
    }
}
