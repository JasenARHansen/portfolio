package Java.code.ctci.source.ch_16_Moderate.q16_03_Intersection;

@SuppressWarnings("SpellCheckingInspection")
public class Line {
  public final double slope;
  public final double yintercept;
  public final Point start;
  public final Point end;

  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
    if (start.x() == end.x()) {
      slope = Double.POSITIVE_INFINITY;
      yintercept = Double.POSITIVE_INFINITY;
    } else {
      slope = (end.y() - start.y()) / (end.x() - start.x());
      yintercept = end.y() - slope * end.x();
    }
  }

  @Override
  public String toString() {
    return "Line [slope="
        + slope
        + ", yintercept="
        + yintercept
        + ", start="
        + start
        + ", end="
        + end
        + "]";
  }

  public double getYFromX(double x) {
    if (isVertical()) {
      return Double.POSITIVE_INFINITY;
    }
    return slope * x + yintercept;
  }

  public boolean isVertical() {
    return slope == Double.POSITIVE_INFINITY;
  }
}
