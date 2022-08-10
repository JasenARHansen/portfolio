package Code.interview.Alt;

import java.util.ArrayList;
import java.util.List;

public class Checkers {

    public static String first_Player = "X";
    public static String first_initial = "x";
    public static String second_Player = "O";
    public static String second_initial = "o";

    public static String[][] setup(int x, int y, int rows) {
        String[][] board = new String[x][y];
        if (rows * 2 > x) {
            return board;
        }

        for (int row = 0; row < rows; row++) {
            // Setup First Player
            int Y;
            if (row % 2 == 0) {
                Y = 0;
            } else {
                Y = 1;
            }
            while (Y < y) {
                board[row][Y] = first_initial;
                Y = Y + 2;
            }
            // Setup Second Player
            if ((x - row) % 2 == 1) {
                Y = 0;
            } else {
                Y = 1;
            }
            while (Y < y) {
                board[x - row - 1][Y] = second_initial;
                Y = Y + 2;
            }
        }

        return board;
    }

    public static void printBoard(String[][] board) {
        // Display a desired board
        for (int x = 0; x < board.length; x++) {
            String line = "";
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == null) {
                    line += "_ ";
                } else {
                    line += board[x][y] + " ";
                }
            }
            System.out.println(line);
        }
    }

    public static List<int[]> getMoves(String[][] board, String player) {
        // Doing X player moves if selected.
        List<int[]> moves = new ArrayList<>();
        if (player.equals(first_Player)) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if ((board[x][y] != null) && (board[x][y].equals(first_initial))) {
                        // Worry about going over the edge of the board
                        // Can it go down?
                        if ((x + 1) <= board.length) {
                            // Can it go left?
                            if (((y - 1) >= 0) && (board[x + 1][y - 1] == null)) {
                                int[] move = {x, y, x + 1, y - 1};
                                moves.add(move);
                            }
                            // Can it go right?
                            if (((y + 1) < board[x].length) && (board[x + 1][y + 1] == null)) {
                                int[] move = {x, y, x + 1, y + 1};
                                moves.add(move);
                            }
                        }
                    }
                }
            }
        } else if (player.equals(second_Player)) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if ((board[x][y] != null) && (board[x][y].equals(second_initial))) {
                        // Worry about going over the edge of the board
                        // Can it go up?
                        if ((x - 1) >= 0) {
                            // Can it go left?
                            if (((y - 1) >= 0) && (board[x - 1][y - 1] == null)) {
                                int[] move = {x, y, x - 1, y - 1};
                                moves.add(move);
                            }
                            // Can it go right?
                            if (((y + 1) < board[x].length) && (board[x - 1][y + 1] == null)) {
                                int[] move = {x, y, x - 1, y + 1};
                                moves.add(move);
                            }
                        }
                    }
                }
            }
        }
        return moves;
    }

    public static void applyMove(int move, List<int[]> moves, String[][] board) {
        int[] the_move = moves.get(move);
        board[the_move[2]][the_move[3]] = board[the_move[0]][the_move[1]];
        board[the_move[0]][the_move[1]] = null;
    }

    public void main(String[] args) {
        String[][] board = setup(8, 8, 1);
        printBoard(board);
        getMoves(board, first_initial);
    }
}
