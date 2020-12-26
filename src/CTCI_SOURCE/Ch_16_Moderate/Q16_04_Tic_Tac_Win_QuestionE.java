package CTCI_SOURCE.Ch_16_Moderate;

import CTCI.CtCILibrary.AssortedMethods;

public class Q16_04_Tic_Tac_Win_QuestionE {

    public static Q16_04_Tic_Tac_Win_Piece hasWon(Q16_04_Tic_Tac_Win_Piece[][] board) {
        int size = board.length;
        if (board[0].length != size) return Q16_04_Tic_Tac_Win_Piece.Empty;
        Q16_04_Tic_Tac_Win_Piece first;

        /* Check rows. */
        for (Q16_04_Tic_Tac_Win_Piece[] q16_04_tic_tac_win_pieces : board) {
            first = q16_04_tic_tac_win_pieces[0];
            if (first == Q16_04_Tic_Tac_Win_Piece.Empty) continue;
            for (int j = 1; j < size; j++) {
                if (q16_04_tic_tac_win_pieces[j] != first) {
                    break;
                } else if (j == size - 1) {
                    return first;
                }
            }
        }

        /* Check columns. */
        for (int i = 0; i < size; i++) {
            first = board[0][i];
            if (first == Q16_04_Tic_Tac_Win_Piece.Empty) continue;
            for (int j = 1; j < size; j++) {
                if (board[j][i] != first) {
                    break;
                } else if (j == size - 1) {
                    return first;
                }
            }
        }

        /* Check diagonals. */
        first = board[0][0];
        if (first != Q16_04_Tic_Tac_Win_Piece.Empty) {
            for (int i = 1; i < size; i++) {
                if (board[i][i] != first) {
                    break;
                } else if (i == size - 1) {
                    return first;
                }
            }
        }

        first = board[0][size - 1];
        if (first != Q16_04_Tic_Tac_Win_Piece.Empty) {
            for (int i = 1; i < size; i++) {
                if (board[i][size - i - 1] != first) {
                    break;
                } else if (i == size - 1) {
                    return first;
                }
            }
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
