package Java.code.ctci.source.ch_16_Moderate.q16_03_Intersection;

public record Point(double x, double y) {
  public double x() {
    return this.x;
  }

  public double y() {
    return this.y;
  }

  @Override
  public String toString() {
    return "Point [x=" + this.x + ", y=" + this.y + "]";
  }
}
