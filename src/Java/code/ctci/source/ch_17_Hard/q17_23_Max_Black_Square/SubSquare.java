package Java.code.ctci.source.ch_17_Hard.q17_23_Max_Black_Square;

public class SubSquare {
    public final int column;
    public final int row;
    public final int size;

    public SubSquare(int r, int c, int sz) {
        row = r;
        column = c;
        size = sz;
    }

    public void print() {
        System.out.println("(" + row + ", " + column + ", " + size + ")");
    }
}
