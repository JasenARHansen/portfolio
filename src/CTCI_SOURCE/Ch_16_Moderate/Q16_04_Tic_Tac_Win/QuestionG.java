package CTCI_SOURCE.Ch_16_Moderate.Q16_04_Tic_Tac_Win;

import CTCI_SOURCE.CtCILibrary.AssortedMethods;

import java.util.ArrayList;

public class QuestionG {
    public static Piece hasWon(Piece[][] board) {
        if (board.length != board[0].length) return Piece.Empty;
        int size = board.length;

        /* Create list of things to check. */
        ArrayList<Check> instructions = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            instructions.add(new Check(0, i, 1, 0));
            instructions.add(new Check(i, 0, 0, 1));
        }
        instructions.add(new Check(0, 0, 1, 1));
        instructions.add(new Check(0, size - 1, 1, -1));

        /* Check them. */
        for (Check instr : instructions) {
            Piece winner = hasWon(board, instr);
            if (winner != Piece.Empty) {
                return winner;
            }
        }
        return Piece.Empty;
    }

    public static Piece hasWon(Piece[][] board, Check instr) {
        Piece first = board[instr.row][instr.column];
        while (instr.inBounds(board.length)) {
            if (board[instr.row][instr.column] != first) {
                return Piece.Empty;
            }
            instr.increment();
        }
        return first;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
        Piece[][] board = new Piece[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = board_t[i][j];
                board[i][j] = Tester.convertIntToPiece(x);
            }
        }

        Piece p1 = hasWon(board);

        System.out.println(p1);
        AssortedMethods.printMatrix(board_t);
    }

    public static class Check {
        private final int rowIncrement;
        private final int columnIncrement;
        public int row, column;

        public Check(int row, int column, int rowI, int colI) {
            this.row = row;
            this.column = column;
            this.rowIncrement = rowI;
            this.columnIncrement = colI;
        }

        public void increment() {
            row += rowIncrement;
            column += columnIncrement;
        }

        public boolean inBounds(int size) {
            return row >= 0 && column >= 0 &&
                    row < size && column < size;
        }
    }

}
