package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_10_Minesweeper;

public class Question {
  public static void main(String[] args) {
    Game game = new Game(7, 7, 3);
    game.initialize();
    game.start();
  }
}
