package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_09_Sorted_Matrix_Search;

@SuppressWarnings({"BooleanMethodIsAlwaysInverted", "MethodDoesntCallSuperMethod", "unused"})
public class Coordinate implements Cloneable {
    public int column;
    public int row;

    public Coordinate(int r, int c) {
        row = r;
        column = c;
    }

    public Object clone() {
        return new Coordinate(row, column);
    }

    public boolean inbounds(int[][] matrix) {
        return row >= 0 && column >= 0 && row < matrix.length && column < matrix[0].length;
    }

    public boolean isBefore(Coordinate p) {
        return row <= p.row && column <= p.column;
    }

    public void moveDownRight() {
        row++;
        column++;
    }

    public void setToAverage(Coordinate min, Coordinate max) {
        row = (min.row + max.row) / 2;
        column = (min.column + max.column) / 2;
    }
}
