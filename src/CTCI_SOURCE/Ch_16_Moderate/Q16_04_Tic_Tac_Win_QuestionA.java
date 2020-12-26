package CTCI_SOURCE.Ch_16_Moderate;

public class Q16_04_Tic_Tac_Win_QuestionA {

    public static int convertBoardToInt(Q16_04_Tic_Tac_Win_Piece[][] board) {
        int sum = 0;
        for (Q16_04_Tic_Tac_Win_Piece[] q16_04_tic_tac_win_pieces : board) {
            for (Q16_04_Tic_Tac_Win_Piece q16_04_tic_tac_win_piece : q16_04_tic_tac_win_pieces) {
                int value = q16_04_tic_tac_win_piece.ordinal();
                sum = sum * 3 + value;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Q16_04_Tic_Tac_Win_Piece[][] board = {
                {Q16_04_Tic_Tac_Win_Piece.Empty, Q16_04_Tic_Tac_Win_Piece.Empty, Q16_04_Tic_Tac_Win_Piece.Empty},
                {Q16_04_Tic_Tac_Win_Piece.Empty, Q16_04_Tic_Tac_Win_Piece.Empty, Q16_04_Tic_Tac_Win_Piece.Empty},
                {Q16_04_Tic_Tac_Win_Piece.Blue, Q16_04_Tic_Tac_Win_Piece.Blue, Q16_04_Tic_Tac_Win_Piece.Blue}};

        int v = convertBoardToInt(board);
        System.out.println(v);
    }

}
