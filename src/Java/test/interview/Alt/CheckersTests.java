package Java.test.interview.Alt;

import Java.code.interview.Alt.Checkers;
import java.util.List;
import java.util.Random;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckersTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    Checkers.getDescription();
  }

  @Test
  public void getMoves() {
    Checkers.setup(8, 7, 3);
    Checkers.printBoard();
    List<int[]> moves = Checkers.getMoves(Checkers.first_Player);
    for (int move = 0; move < moves.size(); move++) {
      System.out.format(
          "%s: Player %s possible move %d: (%d, %d) -> (%d, %d)\n",
          name.getMethodName(),
          Checkers.first_Player,
          move,
          moves.get(move)[0],
          moves.get(move)[1],
          moves.get(move)[2],
          moves.get(move)[3]);
    }
    Checkers.applyMove(0, moves);
    Checkers.printBoard();
    moves = Checkers.getMoves(Checkers.second_Player);
    for (int move = 0; move < moves.size(); move++) {
      System.out.format(
          "%s: Player %s possible move %d: (%d, %d) -> (%d, %d)\n",
          name.getMethodName(),
          Checkers.second_Player,
          move,
          moves.get(move)[0],
          moves.get(move)[1],
          moves.get(move)[2],
          moves.get(move)[3]);
    }
    Checkers.applyMove(0, moves);
    Checkers.printBoard();
  }

  @Test
  public void runGame() {
    Random ran = new Random();
    Checkers.setup(8, 8, 3);
    System.out.format("%s: Begin Game\n", name.getMethodName());
    Checkers.printBoard();
    while (true) {
      List<int[]> moves = Checkers.getMoves(Checkers.first_Player);
      if (!moves.isEmpty()) {
        int move = ran.nextInt(moves.size());
        System.out.format(
            "\tPlayer %s move: (%d, %d) -> (%d, %d)\n",
            Checkers.first_Player,
            moves.get(move)[0],
            moves.get(move)[1],
            moves.get(move)[2],
            moves.get(move)[3]);
        Checkers.applyMove(move, moves);
        Checkers.printBoard();
      } else {
        break;
      }
      moves = Checkers.getMoves(Checkers.second_Player);
      if (!moves.isEmpty()) {
        int move = ran.nextInt(moves.size());
        System.out.format(
            "\tPlayer %s move: (%d, %d) -> (%d, %d)\n",
            Checkers.second_Player,
            moves.get(move)[0],
            moves.get(move)[1],
            moves.get(move)[2],
            moves.get(move)[3]);
        Checkers.applyMove(move, moves);
        Checkers.printBoard();
      } else {
        break;
      }
    }
  }
}
