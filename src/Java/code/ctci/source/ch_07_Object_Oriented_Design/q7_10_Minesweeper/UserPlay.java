package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_10_Minesweeper;

@SuppressWarnings("InfiniteRecursion")
public class UserPlay {
    private final boolean isGuess;
    private int column;
    private int row;

    private UserPlay(int r, int c, boolean guess) {
        setRow(r);
        setColumn(c);
        isGuess = guess;
    }

    public static UserPlay fromString(String input) {
        boolean isGuess = false;
        if (input.length() > 0 && input.charAt(0) == 'B') {
            isGuess = true;
            input = input.substring(1);
        }
        if (!input.matches("\\d* \\d+")) {
            return null;
        }
        String[] parts = input.split(" ");
        try {
            int r = Integer.parseInt(parts[0]);
            int c = Integer.parseInt(parts[1]);
            return new UserPlay(r, c, isGuess);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isGuess() {
        return isGuess;
    }

    public boolean isMove() {
        return !isMove();
    }
}
