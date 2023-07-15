package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_08_Othello;

public class Location {
    private final int column;
    private final int row;

    public Location(int r, int c) {
        row = r;
        column = c;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isSameAs(int r, int c) {
        return row == r && column == c;
    }
}
