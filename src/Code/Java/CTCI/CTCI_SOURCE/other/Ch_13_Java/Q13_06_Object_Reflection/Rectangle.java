package Code.Java.CTCI.CTCI_SOURCE.other.Ch_13_Java.Q13_06_Object_Reflection;

public class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public double area() {
        return width * height;
    }
}
