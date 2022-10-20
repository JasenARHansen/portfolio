package Code.Java.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_08_Othello;

public class Game {
    private static Game instance;
    private final int ROWS = 10;
    private final int COLUMNS = 10;
    private final Player[] players;
    private final Board board;

    private Game() {
        board = new Board(ROWS, COLUMNS);
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
        Automator.getInstance().initialize(players); // used for testing
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Board getBoard() {
        return board;
    }
}
