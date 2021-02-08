package CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

public class UserPlayResult {
    private final boolean successful;
    private final Game.GameState resultingState;

    public UserPlayResult(boolean success, Game.GameState state) {
        successful = success;
        resultingState = state;
    }

    public boolean successfulMove() {
        return successful;
    }

    public Game.GameState getResultingState() {
        return resultingState;
    }
}
