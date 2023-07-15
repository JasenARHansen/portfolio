package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_02_Robot_in_a_Grid;

public record Point(int row, int column) {

    public int column() {
        return this.column;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Point)
                && (((Point) o).row == this.row)
                && (((Point) o).column == this.column);
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    public int row() {
        return this.row;
    }
}
