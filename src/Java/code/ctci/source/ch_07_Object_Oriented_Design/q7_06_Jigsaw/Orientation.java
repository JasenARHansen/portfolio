package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_06_Jigsaw;

public enum Orientation {
  LEFT,
  TOP,
  RIGHT,
  BOTTOM; // Should stay in this order

  public Orientation getOpposite() {
    return switch (this) {
      case LEFT -> RIGHT;
      case RIGHT -> LEFT;
      case TOP -> BOTTOM;
      case BOTTOM -> TOP;
    };
  }
}
