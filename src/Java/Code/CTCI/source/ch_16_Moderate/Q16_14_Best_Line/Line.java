package Java.code.ctci.source.ch_16_Moderate.q16_14_Best_Line;

public class Line {
  public static final double epsilon = .5;
  public final double intercept;
  public double slope;
  private boolean infinite_slope = false;

  public Line(GraphPoint p, GraphPoint q) {
    if (Math.abs(p.x - q.x) > epsilon) { // if x�s are different
      slope = (p.y - q.y) / (p.x - q.x); // compute slope
      intercept = p.y - slope * p.x; // y intercept from y=mx+b
    } else {
      infinite_slope = true;
      intercept = p.x; // x-intercept, since slope is infinite
    }
  }

  public static double floorToNearestEpsilon(double d) {
    int r = (int) (d / epsilon);
    return ((double) r) * epsilon;
  }

  public void Print() {
    System.out.println("y = " + slope + "x + " + intercept);
  }

  public boolean isEquivalent(Object o) {
    Line l = (Line) o;
    return isEquivalent(l.slope, slope)
        && isEquivalent(l.intercept, intercept)
        && (infinite_slope == l.infinite_slope);
  }

  public boolean isEquivalent(double a, double b) {
    return (Math.abs(a - b) < epsilon);
  }
}