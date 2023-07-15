package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_08_Othello;

public class Player {
    private final Color color;

    public Player(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return Game.getInstance().getBoard().getScoreForColor(color);
    }

    public boolean playPiece(int row, int column) {
        return Game.getInstance().getBoard().placeColor(row, column, color);
    }
}
