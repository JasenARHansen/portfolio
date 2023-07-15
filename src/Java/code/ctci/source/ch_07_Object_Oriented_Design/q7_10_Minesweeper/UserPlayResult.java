package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_10_Minesweeper;

public class UserPlayResult {
    private final Game.GameState resultingState;
    private final boolean successful;

    public UserPlayResult(boolean success, Game.GameState state) {
        successful = success;
        resultingState = state;
    }

    public Game.GameState getResultingState() {
        return resultingState;
    }

    public boolean successfulMove() {
        return successful;
    }
}
