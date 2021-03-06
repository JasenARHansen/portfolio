package Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_08_Othello;

public class Question {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.getBoard().initialize();
        game.getBoard().printBoard();
        Automator automator = Automator.getInstance();
        //noinspection StatementWithEmptyBody
        while (!automator.isOver() && automator.playRandom()) {
        }
        automator.printScores();
    }
}
