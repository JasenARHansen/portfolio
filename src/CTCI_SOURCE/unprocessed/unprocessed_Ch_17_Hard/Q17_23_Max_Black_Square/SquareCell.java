package CTCI_SOURCE.unprocessed.unprocessed_Ch_17_Hard.Q17_23_Max_Black_Square;

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
