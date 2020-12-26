package CTCI_SOURCE.Ch_16_Moderate;

import CTCI.CtCILibrary.AssortedMethods;

public class Q16_04_Tic_Tac_Win_QuestionC {
    public static boolean hasWinner(Q16_04_Tic_Tac_Win_Piece p1, Q16_04_Tic_Tac_Win_Piece p2, Q16_04_Tic_Tac_Win_Piece p3) {
        if (p1 == Q16_04_Tic_Tac_Win_Piece.Empty) {
            return false;
        }
        return p1 == p2 && p2 == p3;
    }

    public static Q16_04_Tic_Tac_Win_Piece hasWon(Q16_04_Tic_Tac_Win_Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            /* Check Rows */
            if (hasWinner(board[i][0], board[i][1], board[i][2])) {
                return board[i][0];
            }

            /* Check Columns */
            if (hasWinner(board[0][i], board[1][i], board[2][i])) {
                return board[0][i];
            }
        }

        /* Check Diagonal */
        if (hasWinner(board[0][0], board[1][1], board[2][2])) {
            return board[0][0];
        }

        if (hasWinner(board[0][2], board[1][1], board[2][0])) {
            return board[0][2];
        }

        return Q16_04_Tic_Tac_Win_Piece.Empty;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
        Q16_04_Tic_Tac_Win_Piece[][] board = new Q16_04_Tic_Tac_Win_Piece[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = board_t[i][j];
                board[i][j] = Q16_04_Tic_Tac_Win_Tester.convertIntToPiece(x);
            }
        }

        Q16_04_Tic_Tac_Win_Piece p1 = hasWon(board);

        System.out.println(p1);
        AssortedMethods.printMatrix(board_t);
    }

}
