package Java.code.ctci.old.unsorted;

import Java.code.unsorted.classes.classesInstance.Line;
import Java.code.unsorted.classes.classesInstance.Tuple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

@SuppressWarnings({"SuspiciousNameCombination", "unused"})
public class Moderate {
    public static void getDescription() {
        System.out.println("Section 16. Moderate");
    }

    public static Tuple<Double, Double> lineIntersection(Line line1, Line line2) {
        // Parallel test
        if (line1.getSlope() == line2.getSlope()) {
            return null;
        }
        // Find an intersection point
        // y = mx +b
        // y = m(1)x +b(1) = m(2)x +b(2)
        // (b(2) - b(1)) /(m(1)- m(2))
        double valueX =
                (line2.getYIntercept() - line1.getYIntercept()) / (line1.getSlope() - line2.getSlope());
        // Test to see if the x value is in the range of both lines
        if ((isBetween(line1.getPoint1X(), valueX, line1.getPoint2X()))
                && (isBetween(line2.getPoint1X(), valueX, line2.getPoint2X()))) {
            double valueY = line1.getYfromX(valueX);
            return new Tuple<>(valueX, valueY);
        }
        return null;
    }

    private static boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    public static int maxNumber(int left, int right) {
        return 0;
    }

    public static int minimumDistance(int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int leftPointer = 0;
        int rightPointer = 0;
        int min = Integer.MAX_VALUE;
        while (leftPointer < left.length && rightPointer < right.length) {
            if (min > Math.abs(left[leftPointer] - right[rightPointer])) {
                min = Math.abs(left[leftPointer] - right[rightPointer]);
                if (min == 0) {
                    break;
                }
            }
            if (left[leftPointer] < right[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer++;
            }
        }
        return min;
    }

    public static void numberSwapInPlace(Integer left, Integer right) {
        left = left - right;
        right = left + right;
        left = right - left;
        System.out.println("Finish left: " + left);
        System.out.println("Finish right: " + right);
    }

    public enum Tic_Tac_Toe_Piece {
        Empty {
            @Override
            public String toString() {
                return "_";
            }
        },
        X {
            @Override
            public String toString() {
                return "X";
            }
        },
        O {
            @Override
            public String toString() {
                return "O";
            }
        }
    }

    public static class ConvertNumberToString {
        private final String[] largeUnits = {"", "Thousand", "Million", "Billion"};
        private final String[] smallUnits = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        private final String[] smalls = {
                "Zero",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten",
                "Eleven",
                "Twelve",
                "Thirteen",
                "Fourteen",
                "Fifteen",
                "Sixteen",
                "Seventeen",
                "Eighteen",
                "Nineteen"
        };

        public ConvertNumberToString() {
        }

        public String processNumber(int startValue) {
            if (startValue == 0) {
                return smalls[0];
            }
            if (startValue == Integer.MAX_VALUE) {
                return "out of range";
            }
            Stack<String> stack = new Stack<>();
            boolean negative = false;
            int bigCounter = 0;
            if (startValue < 0) {
                negative = true;
                startValue *= -1;
            }
            while (startValue > 0) {
                int process = startValue % 1000;
                if (process != 0) {
                    stack.add(largeUnits[bigCounter]);
                }
                int hundreds = process / 100;
                process = process % 100;
                if (process >= 20) {
                    int tens = process / 10;
                    int ones = process % 10;
                    if (ones != 0) {
                        stack.add(smalls[ones]);
                    }
                    stack.add(smallUnits[tens]);
                } else {
                    if (process != 0) {
                        stack.add(smalls[process]);
                    }
                }
                if (hundreds != 0) {
                    String hundred = "Hundred";
                    stack.add(hundred);
                    stack.add(smalls[hundreds]);
                }
                startValue /= 1000;
                bigCounter++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (negative) {
                String negativeSign = "Negative";
                stringBuilder.append(negativeSign);
            }
            while (!stack.isEmpty()) {
                if (!stack.peek().equals(smallUnits[0])) {
                    stringBuilder.append(" ").append(stack.pop());
                } else {
                    stack.pop();
                }
            }
            return stringBuilder.toString().trim();
        }
    }

    public static class ProcessBook {
        final HashMap<String, Integer> table;

        public ProcessBook(String[] book) {
            this.table = new HashMap<>();
            this.setWordFrequency(book);
        }

        private void setWordFrequency(String[] book) {
            for (String word : book) {
                word = word.trim().toLowerCase();
                if (!word.trim().isEmpty()) {
                    if (this.table.containsKey(word)) {
                        this.table.put(word, this.table.get(word) + 1);
                    } else {
                        this.table.put(word, +1);
                    }
                }
            }
        }

        public Integer getWordFrequency(String word) {
            return this.table.get(word.toLowerCase().trim());
        }
    }

    @SuppressWarnings("unused")
    public static class Tic_Tac_Toe {
        private final int size;
        private Tic_Tac_Toe_Piece[][] board;
        private Tic_Tac_Toe_Piece lastPlayer;
        private int moves;

        public Tic_Tac_Toe(int size) {
            this.size = size;
            this.initializeBoard();
            this.moves = size * size;
            this.lastPlayer = Tic_Tac_Toe_Piece.Empty;
        }

        public void initializeBoard() {
            this.board = new Tic_Tac_Toe_Piece[this.size][this.size];
            for (int row = 0; row < this.size; row++) {
                for (int column = 0; column < this.size; column++) {
                    this.board[row][column] = Tic_Tac_Toe_Piece.Empty;
                }
            }
        }

        public void placePiece(Tic_Tac_Toe_Piece piece, int xCoordinate, int yCoordinate) {
            if (this.moves == 0) {
                System.out.format("Sorry, this game is over.\n");
                return;
            }
            if ((xCoordinate < 0)
                    || (yCoordinate < 0)
                    || (xCoordinate >= this.size)
                    || (yCoordinate >= this.size)) {
                System.out.format("Invalid location placement '(%s, %s)'.\n", xCoordinate, yCoordinate);
                return;
            }
            if (piece == Tic_Tac_Toe_Piece.Empty) {
                System.out.format("Invalid piece placement '%s'.\n", Tic_Tac_Toe_Piece.Empty);
                return;
            }
            if (this.lastPlayer == Tic_Tac_Toe_Piece.Empty) {
                this.lastPlayer = piece;
            } else if (piece == this.lastPlayer) {
                System.out.format("Player '%s' can not go twice in a row, try again.\n", piece);
                return;
            }
            if (this.board[xCoordinate][yCoordinate] == Tic_Tac_Toe_Piece.Empty) {
                this.board[xCoordinate][yCoordinate] = piece;
                this.moves--;
                this.lastPlayer = piece;
            } else {
                System.out.format("That space is occupied, place again.\n");
                return;
            }
            if (evaluateBoard(piece, xCoordinate, yCoordinate, board)) {
                System.out.format("Player '%s' has won.\n", piece);
                this.moves = 0;
            }
            printBoard();
        }

        private boolean evaluateBoard(
                Tic_Tac_Toe_Piece piece, int xCoordinate, int yCoordinate, Tic_Tac_Toe_Piece[][] board) {
            boolean test = true;
            // column
            for (int index = 0; index < this.size; index++) {
                if (board[xCoordinate][index] != piece) {
                    test = false;
                    break;
                }
            }
            if (test) {
                return true;
            }
            // row
            for (int index = 0; index < this.size; index++) {
                if (board[index][yCoordinate] != piece) {
                    test = true;
                    break;
                }
            }
            if (!test) {
                return true;
            }
            // diagonal 1
            if (xCoordinate == yCoordinate) {
                for (int index = 0; index < this.size; index++) {
                    if (board[index][index] != piece) {
                        test = false;
                        break;
                    }
                }
            } else {
                test = false;
            }
            if (test) {
                return true;
            }
            // diagonal 1
            if ((xCoordinate + yCoordinate) == this.size) {
                for (int index = 1; index <= this.size; index++) {
                    if (board[this.size - index][index - 1] != piece) {
                        test = true;
                        break;
                    }
                }
            } else {
                test = true;
            }
            return !test;
        }

        private void printBoard() {
            System.out.println(this);
        }

        public void resetBoard() {
            this.initializeBoard();
            this.moves = size * size;
            this.lastPlayer = Tic_Tac_Toe_Piece.Empty;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Tic_Tac_Toe_Piece[] entry : this.board) {
                builder.append("[");
                if (entry.length > 0) {
                    builder.append(entry[0]);
                    if (entry.length > 1) {
                        for (int i = 1; i < entry.length; i++) {
                            builder.append("\t");
                            builder.append(entry[i]);
                        }
                    }
                }
                builder.append("]\n");
            }
            return builder.toString();
        }
    }
}
