package CTCI_SOURCE.other.Ch_07_Object_Oriented_Design.Q7_10_Minesweeper;

public class Question {
    public static void main(String[] args) {
        Game game = new Game(7, 7, 3);
        game.initialize();
        game.start();
    }

}
