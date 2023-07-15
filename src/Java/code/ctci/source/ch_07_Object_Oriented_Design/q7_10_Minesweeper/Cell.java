package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_10_Minesweeper;

public class Cell {
    private int column;
    private boolean isBomb;
    private boolean isExposed = false;
    private boolean isGuess = false;
    private int number;
    private int row;

    public Cell(int r, int c) {
        isBomb = false;
        number = 0;
        row = r;
        column = c;
    }

    public boolean flip() {
        isExposed = true;
        return !isBomb;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getSurfaceState() {
        if (isExposed) {
            return getUndersideState();
        } else if (isGuess) {
            return "B ";
        } else {
            return "? ";
        }
    }

    public void incrementNumber() {
        number++;
    }

    public boolean isBlank() {
        return number == 0;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
        number = -1;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public boolean isGuess() {
        return isGuess;
    }

    public void setRowAndColumn(int r, int c) {
        row = r;
        column = c;
    }

    @Override
    public String toString() {
        return getUndersideState();
    }

    public String getUndersideState() {
        if (isBomb) {
            return "* ";
        } else if (number > 0) {
            return number + " ";
        } else {
            return "  ";
        }
    }

    public boolean toggleGuess() {
        if (!isExposed) {
            isGuess = !isGuess;
        }
        return isGuess;
    }
}
