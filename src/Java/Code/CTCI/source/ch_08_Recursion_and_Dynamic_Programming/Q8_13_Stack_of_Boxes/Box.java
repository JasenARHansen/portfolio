package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_13_Stack_of_Boxes;

@SuppressWarnings("unused")
public class Box {
  public final int width;
  public final int height;
  public final int depth;

  public Box(int w, int h, int d) {
    width = w;
    height = h;
    depth = d;
  }

  public boolean canBeUnder(Box b) {
    return width > b.width && height > b.height && depth > b.depth;
  }

  public boolean canBeAbove(Box b) {
    if (b == null) {
      return true;
    }
    return width < b.width && height < b.height && depth < b.depth;
  }

  public String toString() {
    return "Box(" + width + "," + height + "," + depth + ")";
  }
}
