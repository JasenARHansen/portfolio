package CTCI_SOURCE.unprocessed.unprocessed_Ch_17_Hard.Q17_23_Max_Black_Square;

public class Subsquare {
    public int row, column, size;

    public Subsquare(int r, int c, int sz) {
        row = r;
        column = c;
        size = sz;
    }

    public void print() {
        System.out.println("(" + row + ", " + column + ", " + size + ")");
    }
}