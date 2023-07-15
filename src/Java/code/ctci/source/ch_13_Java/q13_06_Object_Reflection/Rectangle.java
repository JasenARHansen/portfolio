package Java.code.ctci.source.ch_13_Java.q13_06_Object_Reflection;

@SuppressWarnings("unused")
public class Rectangle {
    private final double height;
    private final double width;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public double area() {
        return width * height;
    }
}
