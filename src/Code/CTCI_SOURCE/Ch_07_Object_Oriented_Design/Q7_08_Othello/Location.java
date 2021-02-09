package Code.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_08_Othello;

public class Location {
    private final int row;
    private final int column;

    public Location(int r, int c) {
        row = r;
        column = c;
    }

    public boolean isSameAs(int r, int c) {
        return row == r && column == c;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
