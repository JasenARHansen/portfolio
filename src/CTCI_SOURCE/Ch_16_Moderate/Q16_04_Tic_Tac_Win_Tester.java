package CTCI_SOURCE.Ch_16_Moderate;

import CTCI.CtCILibrary.AssortedMethods;

public class Q16_04_Tic_Tac_Win_Tester {
    public static Q16_04_Tic_Tac_Win_Piece convertIntToPiece(int i) {
        if (i == 1) {
            return Q16_04_Tic_Tac_Win_Piece.Blue;
        } else if (i == 2) {
            return Q16_04_Tic_Tac_Win_Piece.Red;
        } else {
            return Q16_04_Tic_Tac_Win_Piece.Empty;
        }
    }


    public static Q16_04_Tic_Tac_Win_Piece hasWonB(Q16_04_Tic_Tac_Win_Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Q16_04_Tic_Tac_Win_Piece winner = Q16_04_Tic_Tac_Win_QuestionB.hasWon(board, i, j);
                if (winner != Q16_04_Tic_Tac_Win_Piece.Empty) {
                    return winner;
                }
            }
        }
        return Q16_04_Tic_Tac_Win_Piece.Empty;
    }

    public static void main(String[] args) {

        for (int k = 0; k < 100; k++) {
            int N = 3;
            int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
            Q16_04_Tic_Tac_Win_Piece[][] board = new Q16_04_Tic_Tac_Win_Piece[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int x = board_t[i][j];
                    board[i][j] = convertIntToPiece(x);
                }
            }
            //AssortedMethods.printMatrix(board_t);
            Q16_04_Tic_Tac_Win_Piece p1 = hasWonB(board);
            Q16_04_Tic_Tac_Win_Piece p2 = Q16_04_Tic_Tac_Win_QuestionC.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p3 = Q16_04_Tic_Tac_Win_QuestionD.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p4 = Q16_04_Tic_Tac_Win_QuestionE.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p5 = Q16_04_Tic_Tac_Win_QuestionF.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p6 = Q16_04_Tic_Tac_Win_QuestionG.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p7 = Q16_04_Tic_Tac_Win_QuestionH.hasWon(board);
            //System.out.println(p + " " + p2);
            if (p1 != p2 || p2 != p3 || p3 != p4 || p4 != p5 || p5 != p6 || p6 != p7) {
                System.out.println(p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7);
                AssortedMethods.printMatrix(board_t);
            }
        }

        for (int k = 0; k < 100; k++) {
            int N = 4;
            int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
            Q16_04_Tic_Tac_Win_Piece[][] board = new Q16_04_Tic_Tac_Win_Piece[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int x = board_t[i][j];
                    board[i][j] = convertIntToPiece(x);
                }
            }
            //AssortedMethods.printMatrix(board_t);
            Q16_04_Tic_Tac_Win_Piece p3 = hasWonB(board);
            Q16_04_Tic_Tac_Win_Piece p4 = Q16_04_Tic_Tac_Win_QuestionE.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p5 = Q16_04_Tic_Tac_Win_QuestionF.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p6 = Q16_04_Tic_Tac_Win_QuestionG.hasWon(board);
            Q16_04_Tic_Tac_Win_Piece p7 = Q16_04_Tic_Tac_Win_QuestionH.hasWon(board);
            //System.out.println(p + " " + p2);
            if (p3 != p4 || p4 != p5 || p5 != p6 || p6 != p7) {
                System.out.println(p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7);
                AssortedMethods.printMatrix(board_t);
            }
        }
    }

}
