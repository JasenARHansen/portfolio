package Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_24_Max_Submatrix;

public class SubMatrix {
    private final int row1;
    private final int row2;
    private final int col1;
    private final int col2;
    private final int sum;

    public SubMatrix(int r1, int c1, int r2, int c2, int sm) {
        row1 = r1;
        col1 = c1;
        row2 = r2;
        col2 = c2;
        sum = sm;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "[(" + row1 + "," + col1 + ") -> (" + row2 + "," + col2 + ") = " + sum + "]";
    }
}
