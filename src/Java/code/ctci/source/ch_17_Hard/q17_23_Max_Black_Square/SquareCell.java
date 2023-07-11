package Java.code.ctci.source.ch_17_Hard.q17_23_Max_Black_Square;

@SuppressWarnings("unused")
public class SquareCell {
  public int zerosRight;
  public int zerosBelow;

  public SquareCell(int right, int below) {
    zerosRight = right;
    zerosBelow = below;
  }

  public void setZerosRight(int right) {
    zerosRight = right;
  }

  public void setZerosBelow(int below) {
    zerosBelow = below;
  }
}
