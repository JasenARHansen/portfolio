package Code.Interview.Alt;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Checkers_tests {

    @Rule
    public TestName name = new TestName();

    // @Test
    public void runMe() {
        String[][] board = Checkers.setup(8, 7, 3);
        Checkers.printBoard(board);
        List<int[]> moves = Checkers.getMoves(board, Checkers.first_Player);
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
        Checkers.applyMove(0, moves, board);
        Checkers.printBoard(board);
        moves = Checkers.getMoves(board, Checkers.second_Player);
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
        Checkers.applyMove(0, moves, board);
        Checkers.printBoard(board);
    }

    @Test
    public void runGame() {
        Random ran = new Random();
        String[][] board = Checkers.setup(8, 8, 3);
        System.out.format("%s: Begin Game\n", name.getMethodName());
        Checkers.printBoard(board);
        while (true) {
            List<int[]> moves = Checkers.getMoves(board, Checkers.first_Player);
            if (!moves.isEmpty()) {
                int move = ran.nextInt(moves.size());
                System.out.format(
                        "\tPlayer %s move: (%d, %d) -> (%d, %d)\n",
                        Checkers.first_Player,
                        moves.get(move)[0],
                        moves.get(move)[1],
                        moves.get(move)[2],
                        moves.get(move)[3]);
                Checkers.applyMove(move, moves, board);
                Checkers.printBoard(board);
            } else {
                break;
            }
            moves = Checkers.getMoves(board, Checkers.second_Player);
            if (!moves.isEmpty()) {
                int move = ran.nextInt(moves.size());
                System.out.format(
                        "\tPlayer %s move: (%d, %d) -> (%d, %d)\n",
                        Checkers.second_Player,
                        moves.get(move)[0],
                        moves.get(move)[1],
                        moves.get(move)[2],
                        moves.get(move)[3]);
                Checkers.applyMove(move, moves, board);
                Checkers.printBoard(board);
            } else {
                break;
            }
            int foo = 1;
        }
    }
}
