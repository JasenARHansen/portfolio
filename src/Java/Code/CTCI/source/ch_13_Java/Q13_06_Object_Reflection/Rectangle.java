package Java.code.ctci.source.ch_13_Java.q13_06_Object_Reflection;

@SuppressWarnings("unused")
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
