package Java.test.interview.Alt;

import Java.code.interview.Alt.Checkers;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Random;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckersTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Checkers.getDescription();
    }

    @Test
    public void getMoves() {
        printTestHeader(name.getMethodName());
        Checkers.setup(8, 7, 3);
        Checkers.printBoard();
        List<int[]> moves = Checkers.getMoves(Checkers.first_Player);
        for (int move = 0; move < moves.size(); move++) {
            System.out.format(
                    "\tPlayer %s possible move %d: (%d, %d) -> (%d, %d)\n",
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
                    "\tPlayer %s possible move %d: (%d, %d) -> (%d, %d)\n",
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
        printTestHeader(name.getMethodName());
        Random ran = new Random();
        Checkers.setup(8, 8, 3);
        System.out.format("\tBegin Game\n");
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
