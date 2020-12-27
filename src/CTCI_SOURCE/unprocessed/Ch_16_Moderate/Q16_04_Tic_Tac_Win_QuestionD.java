package CTCI_SOURCE.unprocessed.Ch_16_Moderate;

import CTCI.CtCILibrary.AssortedMethods;

public class Q16_04_Tic_Tac_Win_QuestionD {
    public static boolean hasWinner(Q16_04_Tic_Tac_Win_Piece p1, Q16_04_Tic_Tac_Win_Piece p2, Q16_04_Tic_Tac_Win_Piece p3) {
        if (p1 == Q16_04_Tic_Tac_Win_Piece.Empty) {
            return false;
        }
        return p1 == p2 && p2 == p3;
    }

    public static Q16_04_Tic_Tac_Win_Piece hasWon(Q16_04_Tic_Tac_Win_Piece[][] board) {
        if (board[0][0] != Q16_04_Tic_Tac_Win_Piece.Empty &&
                (hasWinner(board[0][0], board[0][1], board[0][2]) ||
                        hasWinner(board[0][0], board[1][0], board[2][0]))) {
            return board[0][0];
        }

        if (board[2][2] != Q16_04_Tic_Tac_Win_Piece.Empty &&
                (hasWinner(board[2][0], board[2][1], board[2][2]) ||
                        hasWinner(board[0][2], board[1][2], board[2][2]))) {
            return board[2][2];
        }

        if (board[1][1] != Q16_04_Tic_Tac_Win_Piece.Empty &&
                (hasWinner(board[0][0], board[1][1], board[2][2]) ||
                        hasWinner(board[0][2], board[1][1], board[2][0]) ||
                        hasWinner(board[1][0], board[1][1], board[1][2]) ||
                        hasWinner(board[0][1], board[1][1], board[2][1]))) {
            return board[1][1];
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
