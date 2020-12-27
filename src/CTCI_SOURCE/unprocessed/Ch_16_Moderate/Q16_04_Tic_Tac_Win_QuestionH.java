package CTCI_SOURCE.unprocessed.Ch_16_Moderate;

import CTCI.CtCILibrary.AssortedMethods;

import java.util.ArrayList;

public class Q16_04_Tic_Tac_Win_QuestionH {
    public static Q16_04_Tic_Tac_Win_Piece hasWon(Q16_04_Tic_Tac_Win_Piece[][] board) {
        if (board.length != board[0].length) return Q16_04_Tic_Tac_Win_Piece.Empty;
        int size = board.length;

        ArrayList<Q16_04_Tic_Tac_Win_PositionIterator> instructions = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            instructions.add(new Q16_04_Tic_Tac_Win_PositionIterator(new Q16_04_Tic_Tac_Win_Position(0, i), 1, 0, size));
            instructions.add(new Q16_04_Tic_Tac_Win_PositionIterator(new Q16_04_Tic_Tac_Win_Position(i, 0), 0, 1, size));
        }
        instructions.add(new Q16_04_Tic_Tac_Win_PositionIterator(new Q16_04_Tic_Tac_Win_Position(0, 0), 1, 1, size));
        instructions.add(new Q16_04_Tic_Tac_Win_PositionIterator(new Q16_04_Tic_Tac_Win_Position(0, size - 1), 1, -1, size));

        for (Q16_04_Tic_Tac_Win_PositionIterator iterator : instructions) {
            Q16_04_Tic_Tac_Win_Piece winner = hasWon(board, iterator);
            if (winner != Q16_04_Tic_Tac_Win_Piece.Empty) {
                return winner;
            }
        }
        return Q16_04_Tic_Tac_Win_Piece.Empty;
    }

    public static Q16_04_Tic_Tac_Win_Piece hasWon(Q16_04_Tic_Tac_Win_Piece[][] board, Q16_04_Tic_Tac_Win_PositionIterator iterator) {
        Q16_04_Tic_Tac_Win_Position firstPosition = iterator.next();
        Q16_04_Tic_Tac_Win_Piece first = board[firstPosition.row][firstPosition.column];
        while (iterator.hasNext()) {
            Q16_04_Tic_Tac_Win_Position position = iterator.next();
            if (board[position.row][position.column] != first) {
                return Q16_04_Tic_Tac_Win_Piece.Empty;
            }
        }
        return first;
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
