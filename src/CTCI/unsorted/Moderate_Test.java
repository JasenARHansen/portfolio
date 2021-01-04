package CTCI.unsorted;

import CTCI.unsorted.Moderate.ConvertNumberToString;
import CTCI.unsorted.Moderate.ProcessBook;
import CTCI.unsorted.Moderate.Tic_Tac_Toe;
import CTCI.unsorted.Moderate.Tic_Tac_Toe_Piece;
import classes.classesInstance.Line;
import classes.classesInstance.Tuple;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Moderate_Test {

  private final String testSuite = "Moderate";
  @Rule
  public TestName name = new TestName();

  // @Test
  public void getWordFrequency() {

    String[] words = {
            "the", "Lara", "and", "outcropping", "career", "It", "outcropping", "career", "it"
    };
    Moderate container = new Moderate();
    ProcessBook processBook = new ProcessBook(words);

    for (String word : words) {
      System.out.format(
              "ProcessBook: word '%s' found '%s' times\n", word, processBook.getWordFrequency(word));
    }
  }

  // @Test
  public void lineIntersection() {
    Line segment1 = new Line(0, 0, 3, 3);
    Line segment2 = new Line(0, 3, 3, 0);
    Tuple<Double, Double> intersection = Moderate.lineIntersection(segment1, segment2);

    System.out.format("Intersection of '%s' and '%s' is '%s'\n", segment1, segment2, intersection);
  }

  // @Test
  public void minimumDistance() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());

    int[] array1 = {1, 3, 15, 11, 2};
    int[] array2 = {23, 127, 234, 19, 8};
    Moderate.minimumDistance(array1, array2);
    System.out.format(
            "Smallest difference between '%s' and '%s' is '%s'\n",
            Arrays.toString(array1), Arrays.toString(array2), Moderate.minimumDistance(array1, array2));
  }

  // @Test
  public void numberSwapInPlace() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    int left = 5;
    int right = 9;
    System.out.println("Start left: " + left);
    System.out.println("Start right: " + right);
    Moderate.numberSwapInPlace(left, right);
  }

  // @Test
  public void playTicTacToe() {
    int size = 3;
    Moderate container = new Moderate();
    Tic_Tac_Toe game = new Tic_Tac_Toe(size);
    game.placePiece(Tic_Tac_Toe_Piece.X, 0, 0);
    game.placePiece(Tic_Tac_Toe_Piece.O, 0, 1);
    game.placePiece(Tic_Tac_Toe_Piece.X, 1, 1);
    game.placePiece(Tic_Tac_Toe_Piece.X, 0, 2);
    game.placePiece(Tic_Tac_Toe_Piece.O, 2, 0);
    game.placePiece(Tic_Tac_Toe_Piece.X, 0, 2);
    game.placePiece(Tic_Tac_Toe_Piece.O, 2, 1);
    game.placePiece(Tic_Tac_Toe_Piece.X, 2, 2);
    game.placePiece(Tic_Tac_Toe_Piece.O, 1, 1);
  }

  // @Test
  public void processNumber() {
    System.out.format("\n%s '%s'\n", testSuite, name.getMethodName());
    Moderate container = new Moderate();
    ConvertNumberToString convertNumberToString = new ConvertNumberToString();
    int number = 1234;
    System.out.format(
            "'%s' converted to a string is '%s'\n",
            number, convertNumberToString.processNumber(number));
    number = 100234;
    System.out.format(
            "'%s' converted to a string is '%s'\n",
            number, convertNumberToString.processNumber(number));
    number = 1200034;
    System.out.format(
            "'%s' converted to a string is '%s'\n",
            number, convertNumberToString.processNumber(number));
    number = -1000020304;
    System.out.format(
            "'%s' converted to a string is '%s'\n",
            number, convertNumberToString.processNumber(number));
  }
}
